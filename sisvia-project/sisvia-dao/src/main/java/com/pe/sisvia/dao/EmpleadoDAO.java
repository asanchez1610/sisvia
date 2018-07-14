package com.pe.sisvia.dao;

import java.util.List;

import com.pe.sisvia.model.Empleado;

public interface EmpleadoDAO {

	public Empleado obtenerEmpleadoPorDni(String dni);
	public List<Empleado> listarEmpleado();
	
}
