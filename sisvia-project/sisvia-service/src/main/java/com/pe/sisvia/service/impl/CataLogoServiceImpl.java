package com.pe.sisvia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.sisvia.dao.CatalogoDAO;
import com.pe.sisvia.model.Categoria;
import com.pe.sisvia.model.Centrocosto;
import com.pe.sisvia.model.Destino;
import com.pe.sisvia.model.Tipocomision;
import com.pe.sisvia.service.CataLogoService;

@Service
public class CataLogoServiceImpl implements CataLogoService {

	@Autowired
	private CatalogoDAO catalogoDAO;
	
	@Transactional(readOnly = true)
	public List<Categoria> listarCategorias() {
		return catalogoDAO.listarCategorias();
	}
	
	@Transactional(readOnly = true)
	public List<Destino> listarDestinos() {
		return catalogoDAO.listarDestinos();
	}
	@Transactional(readOnly = true)
	public List<Tipocomision> listarTipocomision() {
		return catalogoDAO.listarTipoComision();
	}

	public List<Centrocosto> listarCentroCosto() {
		return catalogoDAO.listarCentroCosto();
	}
	

}
