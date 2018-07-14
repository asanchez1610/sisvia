package com.pe.sisvia.dao;

import com.pe.sisvia.model.Viatico;

public interface ViaticoDAO {

	public Viatico grabar(Viatico viatico);
	
	public Viatico obtenerPorSolicitud(Long idSolicitud);
	
}
