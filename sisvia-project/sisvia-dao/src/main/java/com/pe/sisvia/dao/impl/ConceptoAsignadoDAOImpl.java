package com.pe.sisvia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.ConceptoAsignadoDAO;
import com.pe.sisvia.model.Conceptoasignado;

@Repository
public class ConceptoAsignadoDAOImpl implements ConceptoAsignadoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Conceptoasignado grabar(Conceptoasignado concepto) {
		if(concepto.getConceptogastoId() == null) {
			em.persist(concepto);
		}else {
			em.merge(concepto);
			em.flush();
		}
		return concepto;
	}

	public List<Conceptoasignado> listarConceptosAsignadosPorViatico(Long idViatico) {
		String sql = "SELECT c FROM Conceptoasignado c WHERE c.viaticoId = :idViatico";
		TypedQuery<Conceptoasignado> query = em.createQuery(sql, Conceptoasignado.class);	
		List<Conceptoasignado> list = query.setParameter("idViatico", idViatico).getResultList();
		return list;
	}

}
