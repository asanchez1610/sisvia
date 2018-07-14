package com.pe.sisvia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.EmpleadoDAO;
import com.pe.sisvia.model.Empleado;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Empleado obtenerEmpleadoPorDni(String dni) {
		String sql = "SELECT e FROM Empleado e WHERE e.numerodocuento = :dni";
		TypedQuery<Empleado> query = em.createQuery(sql, Empleado.class);	
		Empleado empleado = query.setParameter("dni", dni).getSingleResult();
		return empleado;
	}

	public List<Empleado> listarEmpleado() {
		TypedQuery<Empleado> query = em.createNamedQuery("SELECT e FROM Empleado e",Empleado.class);
		return query.getResultList();
	}

}
