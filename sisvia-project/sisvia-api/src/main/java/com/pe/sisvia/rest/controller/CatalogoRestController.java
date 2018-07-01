package com.pe.sisvia.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sisvia.model.Categoria;
import com.pe.sisvia.service.CataLogoService;

@RestController
public class CatalogoRestController {

	@Autowired
	private CataLogoService cataLogoService;

	@GetMapping(path = "/api/catalogos/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> listarCategorias() {
		List<Categoria> categorias = cataLogoService.obtenerCategorias();
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(categorias);
	}

}
