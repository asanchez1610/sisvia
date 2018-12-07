package com.pe.sisvia.dao;

import com.pe.sisvia.model.Gasto;
import com.pe.sisvia.model.Gastoefectivo;
import com.pe.sisvia.model.Gastotarjeta;
import com.pe.sisvia.model.Rendicion;
import com.pe.sisvia.model.Viatico;

public interface ViaticoDAO {

	public Viatico grabar(Viatico viatico);
	
	public Viatico obtenerPorSolicitud(Long idSolicitud);
	
	public Viatico obtenerPorId(Long idSolicitud);
	
	public Rendicion grabarRendicion(Rendicion rendicion);
	
	public Gasto grabarGasto(Gasto gasto);
	
	public Gastotarjeta grabarGastoTarjeta(Gastotarjeta gastoTarjeta);
	
	public Rendicion obtenerRendicionPorViatico(Long idViatico);
	
	public Gastoefectivo obtenerGastoEfectivoPorRendicion(Long idRendicion);
	
}
