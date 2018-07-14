package com.pe.sisvia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.sisvia.dao.EmpleadoDAO;
import com.pe.sisvia.model.Empleado;
import com.pe.sisvia.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	public Empleado obtenerEmpleadoPorDni(String dni) {
		return empleadoDAO.obtenerEmpleadoPorDni(dni);
	}

	public List<Empleado> listarEmpleados() {
		return empleadoDAO.listarEmpleado();
	}

}
