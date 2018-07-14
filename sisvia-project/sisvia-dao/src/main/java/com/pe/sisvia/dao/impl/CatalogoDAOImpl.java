package com.pe.sisvia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.CatalogoDAO;
import com.pe.sisvia.model.Categoria;
import com.pe.sisvia.model.Centrocosto;
import com.pe.sisvia.model.Destino;
import com.pe.sisvia.model.Tipocomision;

@Repository
public class CatalogoDAOImpl implements CatalogoDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Tipocomision> listarTipoComision() {
		TypedQuery<Tipocomision> query = em.createNamedQuery("Tipocomision.findAll", Tipocomision.class);
		return query.getResultList();
	}

	public List<Destino> listarDestinos() {
		TypedQuery<Destino> query = em.createNamedQuery("Destino.findAll", Destino.class);
		return query.getResultList();
	}
	
	public List<Categoria> listarCategorias() {
		TypedQuery<Categoria>  query = em.createNamedQuery("Categoria.findAll", Categoria.class);
		return query.getResultList();
	}

	public List<Centrocosto> listarCentroCosto() {
		TypedQuery<Centrocosto>  query = em.createNamedQuery("Centrocosto.findAll", Centrocosto.class);
		return query.getResultList();
	}

}
