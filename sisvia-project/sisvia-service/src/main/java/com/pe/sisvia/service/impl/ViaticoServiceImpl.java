package com.pe.sisvia.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pe.sisvia.dao.ConceptoAsignadoDAO;
import com.pe.sisvia.dao.SolicitudViaticoDAO;
import com.pe.sisvia.dao.TarjetaCorporativaDAO;
import com.pe.sisvia.dao.ViaticoDAO;
import com.pe.sisvia.model.Conceptoasignado;
import com.pe.sisvia.model.Solicitudviatico;
import com.pe.sisvia.model.Tarjetacorporativa;
import com.pe.sisvia.model.Viatico;
import com.pe.sisvia.model.vo.AsignacionRequestVo;
import com.pe.sisvia.service.ViaticoService;
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
			} catch (ParseException e) {
				e.printStackTrace();
			}
			solicitud.setFecautoriza(new Date());
			solicitud.setFecregistro(new Date());
		}
		return solicitudViaticoDAO.grabar(solicitud);
	}

	public List<Solicitudviatico> listarSolicitudes(Solicitudviatico solicitud) {
		return solicitudViaticoDAO.listarSolicitudes(solicitud);
	}

	public Solicitudviatico obtenerSolicitudPorId(Long id) {
		Solicitudviatico solicitud = solicitudViaticoDAO.obtenerId(id);
		try {
			Viatico viatico = viaticoDAO.obtenerPorSolicitud(solicitud.getSolicitudviaticosId());
			viatico.setDestino(null);
			viatico.setPresupuesto(null);
			viatico.setSolicitudviatico(null);
			Tarjetacorporativa tarjeta = tarjetaCorporativaDAO.obtenerPorViatico(viatico.getViaticoId());
			tarjeta.setViatico(null);
			viatico.setTarjetaCorporativa(tarjeta);
			viatico.setConceptosAsignados(conceptoAsignadoDAO.listarConceptosAsignadosPorViatico(viatico.getViaticoId()));
			solicitud.setViatico(viatico);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return solicitud;
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

		return data;
	}

	@Transactional(rollbackFor = Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void registrarConceptoAsignado(Conceptoasignado concepto) throws Exception {
		conceptoAsignadoDAO.grabar(concepto);
	}

}
