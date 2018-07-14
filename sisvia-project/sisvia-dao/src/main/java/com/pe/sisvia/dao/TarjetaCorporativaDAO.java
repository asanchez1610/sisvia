package com.pe.sisvia.dao;

import com.pe.sisvia.model.Tarjetacorporativa;

public interface TarjetaCorporativaDAO {

	public Tarjetacorporativa grabar(Tarjetacorporativa tarjeta);
	
	public Tarjetacorporativa obtenerPorViatico(Long idViatico);
	
}
