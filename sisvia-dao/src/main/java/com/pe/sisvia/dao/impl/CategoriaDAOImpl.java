package com.pe.sisvia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.CategoriaDAO;
import com.pe.sisvia.model.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
	
	@PersistenceContext
	private EntityManager em;

	public List<Categoria> listar() {
		TypedQuery<Categoria>  query = em.createNamedQuery("Categoria.findAll", Categoria.class);
		return query.getResultList();
	}

}
