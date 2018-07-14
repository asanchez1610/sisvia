package com.pe.sisvia.service;

import java.util.List;

import com.pe.sisvia.model.Empleado;

public interface EmpleadoService {

	public Empleado obtenerEmpleadoPorDni(String dni);
	
	public List<Empleado> listarEmpleados();
	
}
