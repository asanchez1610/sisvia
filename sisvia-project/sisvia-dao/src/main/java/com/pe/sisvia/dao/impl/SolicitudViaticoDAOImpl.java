package com.pe.sisvia.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pe.sisvia.dao.SolicitudViaticoDAO;
import com.pe.sisvia.model.Solicitudviatico;
import com.pe.sisvia.util.Constantes;

@Repository
public class SolicitudViaticoDAOImpl implements SolicitudViaticoDAO {

	@PersistenceContext
	private EntityManager em;

	public Solicitudviatico grabar(Solicitudviatico solicitud) {

		if (solicitud.getSolicitudviaticosId() == null) {
			em.persist(solicitud);
		} else {
			em.merge(solicitud);
			em.flush();
		}
		return solicitud;
	}

	public List<Solicitudviatico> listarSolicitudes(Solicitudviatico solicitud) {
		String sql = "SELECT s FROM Solicitudviatico s WHERE 1=1 ";
		
		if(solicitud.getSolicitudviaticosId() != null ) {
			sql+=" AND s.solicitudviaticosId = :solicitudviaticosId  ";
		}
		
		if(solicitud.getNumDni() != null) {
			sql+=" AND s.empleadoComisionado.numerodocuento = :dni  ";
		}
		
		if(solicitud.getCodCentroCosto() != null) {
			sql+=" AND s.empleadoComisionado.area.centrocosto.nomcc = :ccosto  ";
		}
		
		if(solicitud.getStrFechaInicio() != null) {
			sql+=" AND s.fecinicio >= TO_DATE('"+solicitud.getStrFechaInicio()+"', 'yyyy-mm-dd')  ";
		}
		
		if(solicitud.getStrFechaFin() != null) {
			sql+=" AND s.fecfin <= TO_DATE('"+solicitud.getStrFechaFin()+"', 'yyyy-mm-dd')  ";
		}

		if(solicitud.getNombreCompleto() != null) {
			sql+=" AND upper(s.empleadoComisionado.nombre || ' ' ||s.empleadoComisionado.apellido) like upper('%"+solicitud.getNombreCompleto()+"%') ";
		}
		
		sql+=" AND s.estado = '"+Constantes.ESTADO_AUTHORIZED+"' ORDER BY s.solicitudviaticosId DESC ";
		TypedQuery<Solicitudviatico> query = em.createQuery(sql, Solicitudviatico.class);	
		
		if( solicitud.getSolicitudviaticosId() != null ) {
			query.setParameter("solicitudviaticosId", solicitud.getSolicitudviaticosId());
		}
		
		if( solicitud.getNumDni() != null) {
			query.setParameter("dni", solicitud.getNumDni());
		}
		
		if( solicitud.getCodCentroCosto() != null ) {
			query.setParameter("ccosto", solicitud.getCodCentroCosto());
		}
		

		List<Solicitudviatico> list = query.getResultList();
		
		return list;
	}

	public Solicitudviatico obtenerId(Long id) {
		try {
			return em.find(Solicitudviatico.class, id);
		} catch (Exception e) {
			return null;
		}
	}

}
