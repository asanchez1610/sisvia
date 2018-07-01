package com.pe.sisvia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.sisvia.dao.CategoriaDAO;
import com.pe.sisvia.model.Categoria;
import com.pe.sisvia.service.CataLogoService;

@Service
public class CataLogoServiceImpl implements CataLogoService {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Transactional(readOnly = true)
	public List<Categoria> obtenerCategorias() {
		return categoriaDAO.listar();
	}

}
