package com.pe.sisvia.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pe.sisvia.dao.ConceptoAsignadoDAO;
import com.pe.sisvia.dao.SolicitudViaticoDAO;
import com.pe.sisvia.dao.TarjetaCorporativaDAO;
import com.pe.sisvia.dao.ViaticoDAO;
import com.pe.sisvia.model.Conceptoasignado;
import com.pe.sisvia.model.Gasto;
import com.pe.sisvia.model.Gastoefectivo;
import com.pe.sisvia.model.Gastotarjeta;
import com.pe.sisvia.model.Rendicion;
import com.pe.sisvia.model.Solicitudviatico;
import com.pe.sisvia.model.Tarjetacorporativa;
import com.pe.sisvia.model.Viatico;
import com.pe.sisvia.model.vo.AsignacionRequestVo;
import com.pe.sisvia.service.ViaticoService;
import com.pe.sisvia.util.Constantes;
import com.pe.sisvia.util.TemplateConverter;
import com.pe.sisvia.ws.client.Cliente;

@Service
public class ViaticoServiceImpl implements ViaticoService {

	@Autowired
	private SolicitudViaticoDAO solicitudViaticoDAO;

	@Autowired
	private Cliente cliente;

	@Autowired
	private ViaticoDAO viaticoDAO;

	@Autowired
	private ConceptoAsignadoDAO conceptoAsignadoDAO;

	@Autowired
	private TarjetaCorporativaDAO tarjetaCorporativaDAO;

	@Transactional
	public Solicitudviatico registrarSolicitud(Solicitudviatico solicitud) {
		if (solicitud.getSolicitudviaticosId() == null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				solicitud.setFecinicio(formatter.parse(solicitud.getStrFechaInicio()));
				solicitud.setFecfin(formatter.parse(solicitud.getStrFechaFin()));
				solicitud.setEstado(Constantes.ESTADO_AUTHORIZED);
			} catch (ParseException e) {
			}
			solicitud.setFecautoriza(new Date());
			solicitud.setFecregistro(new Date());
		}
		return solicitudViaticoDAO.grabar(solicitud);
	}

	public List<Solicitudviatico> listarSolicitudes(Solicitudviatico solicitud) {
		List<Solicitudviatico> solicitudes = solicitudViaticoDAO.listarSolicitudes(solicitud);
		for (Solicitudviatico solicitudviatico : solicitudes) {
			solicitudviatico.setViatico(this.procesarViaticoSolicitud(solicitudviatico.getSolicitudviaticosId()));
		}		
		return solicitudes;
	}
	

	public Solicitudviatico obtenerSolicitudPorId(Long id) {
		Solicitudviatico solicitud = solicitudViaticoDAO.obtenerId(id);
		try {
			solicitud.setViatico(this.procesarViaticoSolicitud(id));

			if(solicitud.getEstado().equals(Constantes.ESTADO_RENDIDO_EFECTIVO)) {
				Rendicion rendicion = this.obtenerRendicionPorViatico(solicitud.getViatico().getViaticoId());
				Gastoefectivo gastoEfectivo = this.obtenerGastoEfectivo(rendicion.getRendicionId());
				gastoEfectivo.setGasto(null);
				solicitud.setGastoEfectivo(gastoEfectivo);
			}
			
		} catch (Exception e) {
		}
		return solicitud;
	}

	private Gastoefectivo obtenerGastoEfectivo(Long rendicionId) {
		return viaticoDAO.obtenerGastoEfectivoPorRendicion(rendicionId);
	}

	private Viatico procesarViaticoSolicitud(Long id) {
		try {
			Viatico viatico = viaticoDAO.obtenerPorSolicitud(id);
			viatico.setDestino(null);
			viatico.setPresupuesto(null);
			viatico.setSolicitudviatico(null);
			Tarjetacorporativa tarjeta = tarjetaCorporativaDAO.obtenerPorViatico(viatico.getViaticoId());
			tarjeta.setViatico(null);
			viatico.setTarjetaCorporativa(tarjeta);
			viatico.setConceptosAsignados(
			conceptoAsignadoDAO.listarConceptosAsignadosPorViatico(viatico.getViaticoId()));
			return viatico;	
		}catch (Exception e) {
			return null;
		}
		
	}

	public Map<String, Object> calcularMonto() throws IOException {
		return cliente.calcularMontoTotal();
	}

	public Map<String, Object> consultarTC() throws IOException {
		return cliente.consultarTC();
	}

	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> generarTCRegistrarViatico(AsignacionRequestVo asignacion) throws Exception {

		Map<String, Object> data = new HashMap<String, Object>();

		// Registro de viatico
		Solicitudviatico solicitud = this.obtenerSolicitudPorId(asignacion.getSolicitudviaticosId());
		Viatico viatico = new Viatico();
		viatico.setCodviatico(new BigDecimal("1"));
		viatico.setDestino(solicitud.getDestino().getNomdestino());
		viatico.setFecaprobacion(solicitud.getFecautoriza());
		viatico.setFecinicio(solicitud.getFecinicio());
		viatico.setFecfin(solicitud.getFecfin());
		viatico.setMotivocomision(solicitud.getMotivocomision());
		viatico.setMontototal(asignacion.getMontoTotal());
		viatico.setSolicitudviatico(solicitud);
		viatico.setPresupuesto(solicitud.getEmpleadoComisionado().getArea().getCentrocosto().getPresupuesto());
		viaticoDAO.grabar(viatico);

		// Registro de conceptos asignados
		Conceptoasignado conceptoViatico = new Conceptoasignado();
		conceptoViatico.setViaticoId(viatico.getViaticoId());
		conceptoViatico.setMontogasto(asignacion.getMontogastoViatico());
		conceptoViatico.setConceptogastoId(Long.valueOf(1));
		this.registrarConceptoAsignado(conceptoViatico);

		Conceptoasignado conceptoMovilidad = new Conceptoasignado();
		conceptoMovilidad.setViaticoId(viatico.getViaticoId());
		conceptoMovilidad.setMontogasto(asignacion.getMontogastoMovilidad());
		conceptoMovilidad.setConceptogastoId(Long.valueOf(2));
		this.registrarConceptoAsignado(conceptoMovilidad);

		// Registro de TC
		Map<String, Object> dataTarjeta;
		try {
			dataTarjeta = cliente.consultarTC();
			Map<String, Object> tcResponse = (Map<String, Object>) dataTarjeta.get("tarjeta");
			Double credito = Double.parseDouble(tcResponse.get("credito").toString());
			String numeroTarjeta = tcResponse.get("numeroTarjeta").toString();
			String numeroCuenta = tcResponse.get("numeroCuenta").toString();

			Tarjetacorporativa tarjeta = new Tarjetacorporativa();
			tarjeta.setCredito(credito);
			tarjeta.setFecregistro(new Date());
			tarjeta.setNumcuenta(numeroCuenta);
			tarjeta.setNumtarjeta(numeroTarjeta);
			tarjeta.setViatico(viatico);
			tarjetaCorporativaDAO.grabar(tarjeta);
			data.put("tarjeta", tarjeta);

		} catch (IOException e) {
			throw new Exception("Error al registrar la asignacion");
		}

		solicitud.setEstado(Constantes.ESTADO_ASSIGNED);
		solicitudViaticoDAO.grabar(solicitud);

		return data;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public void registrarConceptoAsignado(Conceptoasignado concepto) throws Exception {
		conceptoAsignadoDAO.grabar(concepto);
	}

	@Transactional
	public void anularSolicitud(Solicitudviatico solicitud) {
		Solicitudviatico solicitudAnular = solicitudViaticoDAO.obtenerId(solicitud.getSolicitudviaticosId());
		solicitudAnular.setEstado(Constantes.ESTADO_CANCELLED);
		solicitudAnular.setMotivorechazo(solicitud.getMotivorechazo());
		solicitudViaticoDAO.grabar(solicitudAnular);
	}

	public Map<String, Object> consultarMovimientos() throws IOException {
		return cliente.consultarMovimientos();
	}

	@SuppressWarnings("unchecked")
	public void generarReporte(String pathFileOutput,Long idSolicitud) throws Exception {
		TemplateConverter t = new TemplateConverter();
		Map<String, Object> input = new HashMap<String, Object>();
		
		Solicitudviatico solicitud = this.obtenerSolicitudPorId(idSolicitud);
		
		Map<String, Object> responseMovimientos = this.consultarMovimientos();
		Map<String, Object> movimientos = (Map<String, Object>) responseMovimientos.get("movimientos");
		
		Map<String, Object> alimentacion = (Map<String, Object>) movimientos.get("alimentacion");
		List<Map<String, Object>> alimentacionComprobantes = (List<Map<String, Object>>) alimentacion.get("comprobantes");
		
		Map<String, Object> alojamiento = (Map<String, Object>) movimientos.get("alojamiento");
		List<Map<String, Object>> alojamientoComprobantes = (List<Map<String, Object>>) alojamiento.get("comprobantes");
		
		Map<String, Object> movilidad = (Map<String, Object>) movimientos.get("movilidad");
		List<Map<String, Object>> movilidadComprobantes = (List<Map<String, Object>>) movilidad.get("comprobantes");
		
		Map<String, Object> mTotalSolicitado = (Map<String, Object>) responseMovimientos.get("totalSolicitado");
		Map<String, Object> mTotalEjecutado = (Map<String, Object>) responseMovimientos.get("totalEjecutado");
		Map<String, Object> mMontoDevolucion = (Map<String, Object>) responseMovimientos.get("montoDevolucion");
		
		input.put("totalPagado", mTotalSolicitado.get("monto").toString());
		input.put("totalEjecutado", mTotalEjecutado.get("monto").toString());
		input.put("totalDevolucion", mMontoDevolucion.get("monto").toString());
		
		String textoSubtitulo = "";
		
		if(solicitud.getDestino().getZonacritica().compareTo(BigDecimal.ZERO) == 0) {
			textoSubtitulo = "<div style =\"width100%;color:red\">Retiro en efectivo: "+movimientos.get("retiroEfectivo").toString()+" (30% según acuerdo Nro. 001-2013/006-FONAFE)</div>";
		}else {
			textoSubtitulo = "<div style =\"width100%;color:black\">Retiro en efectivo: "+movimientos.get("retiroEfectivo").toString()+" (60% permitido por ser zona critica)</div>";
		}
		//<span>Este textto</span><br />
		
		input.put("textoSubtitulo",textoSubtitulo);
		input.put("montoAlimentacion", "S/. "+alimentacion.get("total"));
		input.put("filasAlimentacion", this.printRowsComprobantes(alimentacionComprobantes) );
		input.put("montoAlojamiento", "S/. "+alojamiento.get("total"));
		input.put("filasAojamiento", this.printRowsComprobantes(alojamientoComprobantes));
		input.put("montoMovilidad", "S/. "+movilidad.get("total"));
		input.put("filasMovilidad", this.printRowsComprobantes(movilidadComprobantes));
		t.converterTemplateDocumentoPDF(Constantes.PATH_TEMPLATES, Constantes.NAME_TPL_REPORT_MOV, input,pathFileOutput);
		
	}

	private String printRowsComprobantes(List<Map<String, Object>> alimentacionComprobantes) {
		String rows = StringUtils.EMPTY;
		String fecha = null;
        String tipoComprobante = null;
        String numeroComprobante = null;
        String detalleComprobante = null;
        String monedaComprobante = null;
        String totalComprobante= null;
		if(alimentacionComprobantes != null) {
			for (Map<String, Object> map : alimentacionComprobantes) {
				rows+= "<tr>";
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if(entry.getKey().equals("fecha")) {
						fecha = entry.getValue().toString();
					}else if(entry.getKey().equals("tipoComprobante")) {
						tipoComprobante = entry.getValue().toString();
					}else if(entry.getKey().equals("numeroComprobante")) {
						numeroComprobante = entry.getValue().toString();
					}else if(entry.getKey().equals("detalleComprobante")) {
						detalleComprobante = entry.getValue().toString();
					}else if(entry.getKey().equals("monedaComprobante")) {
						monedaComprobante = entry.getValue().toString();
					}else if(entry.getKey().equals("totalComprobante")) {
						totalComprobante = entry.getValue().toString();
					}
				}
				
				rows+= "<td>"+fecha+"</td>"
						+ "<td>"+tipoComprobante+"</td>"
						+ "<td>"+numeroComprobante+"</td>"
						+ "<td>"+detalleComprobante+"</td>"
						+ "<td>"+monedaComprobante+" "+totalComprobante+"</td>";
				
				rows+= "</tr>";
			}
		}
		return rows;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Rendicion asignarRendicion(Solicitudviatico solicitud, boolean isSolicitudRendicinEfectivo) throws Exception {
	
		Solicitudviatico solicitudOrigen = solicitud;
		Map<String, Object> responseMovimientos = this.consultarMovimientos();
		Map<String, Object> totalEjecutado = (Map<String, Object>) responseMovimientos.get("totalEjecutado");
		Map<String, Object> montoDevolucion = (Map<String, Object>) responseMovimientos.get("montoDevolucion");
		
		String valorTotalEjecutado = totalEjecutado.get("monto").toString();
		String valorDevolucion = montoDevolucion.get("monto").toString();
		
		boolean esRendidoEfectivo = false;
		if(solicitud.getEstado().equals(Constantes.ESTADO_RENDIDO_EFECTIVO)) {
			esRendidoEfectivo = true;
		}
		
		Rendicion rendicion = null;
		if(!esRendidoEfectivo) {
			rendicion = new Rendicion();
			rendicion.setDuracion(solicitudOrigen.getDuracion());
			rendicion.setFecinicio(solicitudOrigen.getFecinicio());
			rendicion.setFecfin(solicitudOrigen.getFecfin());
			
			rendicion.setViaticoId(solicitud.getViatico().getViaticoId());
			if(totalEjecutado != null) {
				rendicion.setMontodevolucion(Double.parseDouble(valorDevolucion));	
			}
			
			if(totalEjecutado != null) {
				rendicion.setMontototal(Double.parseDouble(valorTotalEjecutado));	
			}
			
			viaticoDAO.grabarRendicion(rendicion);
		
		}else {
			solicitudViaticoDAO.actualizarEstado(solicitudOrigen.getSolicitudviaticosId(),Constantes.ESTADO_RENDICION);
			return this.obtenerRendicionPorViatico(solicitudOrigen.getViatico().getViaticoId());
		}
		
		
		if(!isSolicitudRendicinEfectivo) {
		Gasto gasto = new Gasto();
		gasto.setRendicionId(rendicion.getRendicionId());
		gasto.setFecregistrogasto(new Date());
		if(esRendidoEfectivo) {
			gasto.setTipogasto(Constantes.GASTO_EFECTIVO);
		}else {
			gasto.setTipogasto(Constantes.GASTO_TARJETA);	
		}
		viaticoDAO.grabarGasto(gasto);
		
		Gastotarjeta gastoTarjeta = null;
		
		Map<String, Object> movimientos = (Map<String, Object>) responseMovimientos.get("movimientos");
		
		Map<String, Object> alimentacion = (Map<String, Object>) movimientos.get("alimentacion");
		List<Map<String, Object>> alimentacionComprobantes = (List<Map<String, Object>>) alimentacion.get("comprobantes");
		
		if(alimentacionComprobantes != null) {
			for (Map<String, Object> map : alimentacionComprobantes) {
				gastoTarjeta = new Gastotarjeta();
				gastoTarjeta.setFecoperacion(new Date());
				gastoTarjeta.setRendicionId(rendicion.getRendicionId());
				if(map.get("totalComprobante") != null) {
					gastoTarjeta.setMontocomprobante(Double.parseDouble(map.get("totalComprobante").toString()));
				}
				if(map.get("numeroComprobante") != null) {
					gastoTarjeta.setNrocomprobante(map.get("numeroComprobante").toString());
				}
				viaticoDAO.grabarGastoTarjeta(gastoTarjeta);
			}
		}
		
		Map<String, Object> alojamiento = (Map<String, Object>) movimientos.get("alojamiento");
		List<Map<String, Object>> alojamientoComprobantes = (List<Map<String, Object>>) alojamiento.get("comprobantes");
		
		if(alojamientoComprobantes != null) {
			for (Map<String, Object> map : alojamientoComprobantes) {
				gastoTarjeta = new Gastotarjeta();
				gastoTarjeta.setFecoperacion(new Date());
				gastoTarjeta.setRendicionId(rendicion.getRendicionId());
				if(map.get("totalComprobante") != null) {
					gastoTarjeta.setMontocomprobante(Double.parseDouble(map.get("totalComprobante").toString()));
				}
				if(map.get("numeroComprobante") != null) {
					gastoTarjeta.setNrocomprobante(map.get("numeroComprobante").toString());
				}
				viaticoDAO.grabarGastoTarjeta(gastoTarjeta);
			}
		}
		
		Map<String, Object> movilidad = (Map<String, Object>) movimientos.get("movilidad");
		List<Map<String, Object>> movilidadComprobantes = (List<Map<String, Object>>) movilidad.get("comprobantes");
		
		if(movilidadComprobantes != null) {
			for (Map<String, Object> map : movilidadComprobantes) {
				gastoTarjeta = new Gastotarjeta();
				gastoTarjeta.setFecoperacion(new Date());
				gastoTarjeta.setRendicionId(rendicion.getRendicionId());
				if(map.get("totalComprobante") != null) {
					gastoTarjeta.setMontocomprobante(Double.parseDouble(map.get("totalComprobante").toString()));
				}
				if(map.get("numeroComprobante") != null) {
					gastoTarjeta.setNrocomprobante(map.get("numeroComprobante").toString());
				}
				viaticoDAO.grabarGastoTarjeta(gastoTarjeta);
			}
		}
		solicitudViaticoDAO.actualizarEstado(solicitudOrigen.getSolicitudviaticosId(),Constantes.ESTADO_RENDICION);

		}else {
			solicitudViaticoDAO.actualizarEstado(solicitudOrigen.getSolicitudviaticosId(),Constantes.ESTADO_PENDIENTE_RENDICION);
		}
		
		return rendicion;
		
	}

	private Rendicion obtenerRendicionPorViatico(Long viaticoId) {
		return viaticoDAO.obtenerRendicionPorViatico(viaticoId);
	}

}
