package com.pe.sisvia.rest.controller;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sisvia.exception.ErrorResponse;
import com.pe.sisvia.model.Empleado;
import com.pe.sisvia.service.EmpleadoService;
import com.pe.sisvia.util.Constantes;
import com.pe.sisvia.util.Mensajes;

@SuppressWarnings("rawtypes")
@RestController
public class EmpleadoRestController {

	public static final String context = Constantes.PATH_API+"empleado/";
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private MessageSource messageSource;
	
	Logger LOG = Logger.getLogger(EmpleadoRestController.class);
	
	@GetMapping(path = EmpleadoRestController.context+"{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity obtenerPorDni(@PathVariable String dni) {
		try {
			Empleado empleado = empleadoService.obtenerEmpleadoPorDni(dni);
			ResponseEntity<Empleado> response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(empleado);
			return response;	
		}catch (Exception e) {
			LOG.error("Error al consultar empleado por dni", e);
			ErrorResponse error = new ErrorResponse();
			error.setMessage(messageSource.getMessage(Mensajes.DNI_EMPLEADO_NO_ENCONTRADO, null, Locale.getDefault()));
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
		
	}
	
}
