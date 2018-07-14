package com.pe.sisvia.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.ViaticoDAO;
import com.pe.sisvia.model.Viatico;

@Repository
public class ViaticoDAOImpl implements ViaticoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Viatico grabar(Viatico viatico) {
		if(viatico.getViaticoId() == null) {
			em.persist(viatico);
		}else{
			em.merge(viatico);
			em.flush();
		}
		return viatico;
	}

	public Viatico obtenerPorSolicitud(Long idSolicitud) {
		String sql = "SELECT v FROM Viatico v WHERE v.solicitudviatico.solicitudviaticosId = :idSolicitud";
		TypedQuery<Viatico> query = em.createQuery(sql, Viatico.class);	
		Viatico viatico = query.setParameter("idSolicitud", idSolicitud).getSingleResult();
		return viatico;
	}

}
