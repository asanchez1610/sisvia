package com.pe.sisvia.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.pe.sisvia.model.Conceptoasignado;
import com.pe.sisvia.model.Rendicion;
import com.pe.sisvia.model.Solicitudviatico;
import com.pe.sisvia.model.vo.AsignacionRequestVo;

public interface ViaticoService {

	public Solicitudviatico registrarSolicitud( Solicitudviatico solicitud );
	
	public List<Solicitudviatico> listarSolicitudes(Solicitudviatico solicitud);
	
	public Solicitudviatico obtenerSolicitudPorId(Long id);
	
	public Map<String, Object> calcularMonto() throws IOException;
	
	public Map<String, Object> consultarTC() throws IOException;
	
	public Map<String, Object> generarTCRegistrarViatico(AsignacionRequestVo asignacion) throws Exception ;
	
	public void registrarConceptoAsignado(Conceptoasignado concepto)  throws Exception;
	
	public void anularSolicitud(Solicitudviatico solicitud);
	
	public Map<String, Object> consultarMovimientos() throws IOException;
	
	public void generarReporte(String pathFileOutput,Long idSolicitud) throws Exception;
	
	public Rendicion asignarRendicion(Solicitudviatico solicitud , boolean isSolicitudRendicinEfectivo) throws Exception;

}
