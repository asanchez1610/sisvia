package com.pe.sisvia.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sisvia.exception.ErrorResponse;
import com.pe.sisvia.model.Solicitudviatico;
import com.pe.sisvia.model.vo.AsignacionRequestVo;
import com.pe.sisvia.service.ViaticoService;
import com.pe.sisvia.util.Constantes;

@SuppressWarnings("rawtypes")
@RestController
public class ViaticoController {

	public static final String context = Constantes.PATH_API+"viatico/";
	
	@Autowired
	private ViaticoService viaticoService;
	
	Logger LOG = Logger.getLogger(ViaticoController.class);
	
	@PostMapping(path = ViaticoController.context+"solicitud", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity registrarSolicitud(@RequestBody Solicitudviatico solicitud) {
		try {
			Solicitudviatico solicitudviatico = viaticoService.registrarSolicitud(solicitud);
			ResponseEntity<Solicitudviatico> response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(solicitudviatico);
			return response;	
		}catch (Exception e) {
			LOG.error(e);
			ErrorResponse error = new ErrorResponse();
			error.setMessage("La solisitud no se pudo registrar.");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
		
	}
	
	@PostMapping(path = ViaticoController.context+"solicitudes", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity listarSolicitudes(@RequestBody Solicitudviatico solicitud) {
		try {
			Map<String, Object> data = new HashMap<>();
			List<Solicitudviatico> list = viaticoService.listarSolicitudes(solicitud);
			data.put("data", list);
			ResponseEntity response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(data);
			return response;	
		}catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage("No se pudo obtener la información.");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
	}
	
	@GetMapping(path = ViaticoController.context+"solicitudes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity obtenerSolicitudPorId(@PathVariable Long id) {
		try {
			Solicitudviatico solicitud = viaticoService.obtenerSolicitudPorId(id);
			ResponseEntity response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(solicitud);
			return response;	
		}catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage("No se pudo obtener la información.");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
	}
	
	@GetMapping(path = ViaticoController.context+"calcularMonto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity calcularMonto() {
		try {
			Map<String, Object> calculo = viaticoService.calcularMonto();
			ResponseEntity response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(calculo);
			return response;	
		}catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage("No se pudo obtener la información.");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
	}
	
	@PostMapping(path = ViaticoController.context+"asignacion", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity asignarViatico(@RequestBody AsignacionRequestVo asignacion) {
		try {
			Map<String, Object> data = viaticoService.generarTCRegistrarViatico(asignacion);
			ResponseEntity response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(data);
			return response;	
		}catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage("Error al intentar realizar la asignacion.");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
	}
	
}
