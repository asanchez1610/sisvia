package com.pe.sisvia.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.TarjetaCorporativaDAO;
import com.pe.sisvia.model.Tarjetacorporativa;

@Repository
public class TarjetaCorporativaDAOImpl implements TarjetaCorporativaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Tarjetacorporativa grabar(Tarjetacorporativa tarjeta) {
		if(tarjeta.getTarjetacorporativaId() == null) {
			em.persist(tarjeta);
		}else {
			em.merge(tarjeta);
			em.flush();
		}
		return tarjeta;
	}

	public Tarjetacorporativa obtenerPorViatico(Long idViatico) {
		String sql = "SELECT t FROM Tarjetacorporativa t WHERE t.viatico.viaticoId = :idViatico";
		TypedQuery<Tarjetacorporativa> query = em.createQuery(sql, Tarjetacorporativa.class);	
		Tarjetacorporativa tarjeta = query.setParameter("idViatico", idViatico).getSingleResult();
		return tarjeta;
	}


}
