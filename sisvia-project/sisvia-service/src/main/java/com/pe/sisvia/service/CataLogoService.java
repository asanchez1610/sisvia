package com.pe.sisvia.service;

import java.util.List;

import com.pe.sisvia.model.Categoria;
import com.pe.sisvia.model.Centrocosto;
import com.pe.sisvia.model.Destino;
import com.pe.sisvia.model.Tipocomision;

public interface CataLogoService {

	public List<Categoria> listarCategorias();

	public List<Destino> listarDestinos();

	public List<Tipocomision> listarTipocomision();
	
	public List<Centrocosto> listarCentroCosto();

}
