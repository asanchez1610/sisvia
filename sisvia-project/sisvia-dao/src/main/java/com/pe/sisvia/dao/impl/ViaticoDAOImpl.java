package com.pe.sisvia.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.ViaticoDAO;
import com.pe.sisvia.model.Gasto;
import com.pe.sisvia.model.Gastoefectivo;
import com.pe.sisvia.model.Gastotarjeta;
import com.pe.sisvia.model.Rendicion;
import com.pe.sisvia.model.Solicitudviatico;
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

	public Rendicion grabarRendicion(Rendicion rendicion) {
		if(rendicion.getRendicionId() == null) {
			em.persist(rendicion);
		}else{
			em.merge(rendicion);
			em.flush();
		}
		return rendicion;
	}

	public Gasto grabarGasto(Gasto gasto) {
			em.persist(gasto);
		return gasto;
	}

	public Gastotarjeta grabarGastoTarjeta(Gastotarjeta gastoTarjeta) {
		if(gastoTarjeta.getId() == null) {
			em.persist(gastoTarjeta);
		}else{
			em.merge(gastoTarjeta);
			em.flush();
		}
		return gastoTarjeta;
	}

	public Viatico obtenerPorId(Long id) {
		try {
			return em.find(Viatico.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	public Rendicion obtenerRendicionPorViatico(Long idViatico) {
		String sql = "SELECT r FROM Rendicion r WHERE r.viaticoId = :idViatico";
		TypedQuery<Rendicion> query = em.createQuery(sql, Rendicion.class);	
		Rendicion rendicion = query.setParameter("idViatico", idViatico).getSingleResult();
		return rendicion;
	}

	public Gastoefectivo obtenerGastoEfectivoPorRendicion(Long idRendicion) {
		String sql = "SELECT g FROM Gastoefectivo g WHERE g.rendicionId = :idRendicion";
		TypedQuery<Gastoefectivo> query = em.createQuery(sql, Gastoefectivo.class);	
		Gastoefectivo gastoefectivo = query.setParameter("idRendicion", idRendicion).getSingleResult();
		return gastoefectivo;
	}

}
