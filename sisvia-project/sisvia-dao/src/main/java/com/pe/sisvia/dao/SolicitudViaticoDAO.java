package com.pe.sisvia.dao;

import java.util.List;

import com.pe.sisvia.model.Solicitudviatico;

public interface SolicitudViaticoDAO {
	
	public Solicitudviatico grabar(Solicitudviatico solicitud);
	
	public List<Solicitudviatico> listarSolicitudes(Solicitudviatico solicitud);
	
	public Solicitudviatico obtenerId(Long id);

	public void actualizarEstado(Long id,String estado);
	
}
