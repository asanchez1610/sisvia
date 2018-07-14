package com.pe.sisvia.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sisvia.exception.ErrorResponse;
import com.pe.sisvia.service.CataLogoService;
import com.pe.sisvia.util.Constantes;

@SuppressWarnings("rawtypes")
@RestController
public class CatalogoRestController {

	public static final String context = Constantes.PATH_API + "catalogos/";

	@Autowired
	private CataLogoService cataLogoService;

	@GetMapping(path = CatalogoRestController.context + "{catalogoName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity listarCatalogos(@PathVariable String catalogoName) {
		try {
			Map<String, Object> data = new HashMap<>();
			if (Constantes.CATALOGO_NAME_DESTINO.equals(catalogoName)) {
				data.put("data", cataLogoService.listarDestinos());
			} else if (Constantes.CATALOGO_NAME_TCOMISION.equals(catalogoName)) {
				data.put("data", cataLogoService.listarTipocomision());
			} else if(Constantes.CATALOGO_NAME_CCOSTO.equals(catalogoName)) {
				data.put("data", cataLogoService.listarCentroCosto());
			}else {
				data.put("data", null);
			}
			return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(data);
		} catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage("Error al obtener los datos");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
	}

}
