package com.pe.sisvia.rest.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sisvia.exception.ErrorResponse;
import com.pe.sisvia.model.Rendicion;
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
	
	@PostMapping(path = ViaticoController.context+"solicitud", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity registrarSolicitud(@RequestBody Solicitudviatico solicitud) {
		try {
			Solicitudviatico solicitudviatico = viaticoService.registrarSolicitud(solicitud);
			ResponseEntity<Solicitudviatico> response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(solicitudviatico);
			return response;	
		}catch (Exception e) {
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
	
	@PostMapping(path = ViaticoController.context+"solicitud/anular", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity anularSolicitud(@RequestBody Solicitudviatico solicitud) {
		try {
			Map<String, Object> data = new HashMap<>();
			viaticoService.anularSolicitud(solicitud);
			data.put("success", Boolean.TRUE);
			ResponseEntity response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(data);
			return response;	
		}catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage("No se pudo obtener la información.");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
	}
	
	@GetMapping(path = ViaticoController.context+"calcularMonto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity calcularMonto(@PathVariable Long id) {
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
	
	@GetMapping(path = ViaticoController.context+"consultarMovimientos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity consultarMovimientos() {
		try {
			Map<String, Object> calculo = viaticoService.consultarMovimientos();
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
	
	@PostMapping(path = ViaticoController.context+"rendicion")
	public ResponseEntity asignarViatico(Long idSolicitudViatico,boolean isSolicitudRendicinEfectivo) {
		try {
			Map<String, Object> data = new HashMap<String,Object>();
			Solicitudviatico  solicitud = viaticoService.obtenerSolicitudPorId(idSolicitudViatico);
			Rendicion rendicon = viaticoService.asignarRendicion(solicitud, isSolicitudRendicinEfectivo);
			data.put("rendicion", rendicon);
			ResponseEntity response = ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(data);
			return response;	
		}catch (Exception e) {
			ErrorResponse error = new ErrorResponse();
			error.setMessage("Error al intentar realizar la asignacion.");
			return ResponseEntity.badRequest().cacheControl(CacheControl.noCache()).body(error);
		}
	}
	
	@GetMapping(path = ViaticoController.context+"movimiento/repoorte/{idSolicitud}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<byte[]> reporteMovimientos(@PathVariable Long idSolicitud,HttpServletRequest request) {
		try {
			ServletContext servletContext = request.getServletContext();
			String contextPath = servletContext.getRealPath("/");
			viaticoService.generarReporte(contextPath+"/reports/reporte.pdf",idSolicitud);
			File file = new File(contextPath+"/reports/reporte.pdf"); 
			byte[] contents = Files.readAllBytes(file.toPath());
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.parseMediaType("application/pdf"));
		    // Here you have to set the actual filename of your pdf
		    String filename = "reporte.pdf";
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		    return response;
		}catch (Exception e) {
			return null;
		}
	}
	
}
