package com.pe.sisvia.dao;

import java.util.List;

import com.pe.sisvia.model.Categoria;
import com.pe.sisvia.model.Centrocosto;
import com.pe.sisvia.model.Destino;
import com.pe.sisvia.model.Tipocomision;

public interface CatalogoDAO {

	public List<Tipocomision> listarTipoComision();
	
	public List<Destino> listarDestinos();
	
	public List<Categoria> listarCategorias(); 
	
	public List<Centrocosto> listarCentroCosto(); 
	
}
