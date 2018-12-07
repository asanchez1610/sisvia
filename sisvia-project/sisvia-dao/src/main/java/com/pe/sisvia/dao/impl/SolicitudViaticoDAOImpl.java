package com.pe.sisvia.dao.impl;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
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
		
		if(solicitud.getCodTipoComision() != null) {
			sql+=" AND s.tipocomision.tipocomisionId = :tcomision  ";
		}
		
		if(solicitud.getStrFechaInicio() != null) {
			sql+=" AND s.fecinicio >= TO_DATE('"+solicitud.getStrFechaInicio()+"', 'yyyy-mm-dd')  ";
		}
		
		if(solicitud.getStrFechaFin() != null) {
			sql+=" AND s.fecfin <= TO_DATE('"+solicitud.getStrFechaFin()+"', 'yyyy-mm-dd')  ";
		}
		
		if(solicitud.getStrFechaAprobacion() != null) {
			sql+=" AND s.fecautoriza = TO_DATE('"+solicitud.getStrFechaAprobacion()+"', 'yyyy-mm-dd')  ";
		}

		if(solicitud.getNombreCompleto() != null) {
			sql+=" AND upper(s.empleadoComisionado.nombre || ' ' ||s.empleadoComisionado.apellido) like upper('%"+solicitud.getNombreCompleto()+"%') ";
		}
		
		String estado = Constantes.ESTADO_AUTHORIZED;
		String order = "solicitudviaticosId";
		if(StringUtils.isNotBlank(solicitud.getEstado())) {
			estado = solicitud.getEstado();
			if(solicitud.getEstado().equals(Constantes.ESTADO_ASSIGNED)) {
				order = "fecfin";
				
				if(solicitud.isRendido() && solicitud.isxRendir()) {
					sql+=" AND s.estado in ("
							+ "'"+Constantes.ESTADO_PENDIENTE_RENDICION+"',"
							+ "'"+Constantes.ESTADO_RENDIDO_EFECTIVO+"') ";
				}else if(solicitud.isRendido() && !solicitud.isxRendir()) {
					sql+=" AND s.estado in ("
							+ "'"+Constantes.ESTADO_RENDIDO_EFECTIVO+"') ";
				}else if(!solicitud.isRendido() && solicitud.isxRendir()) {
					sql+=" AND s.estado in ("
							+ "'"+Constantes.ESTADO_PENDIENTE_RENDICION+"') ";	
				}else if(!solicitud.isRendido() && !solicitud.isxRendir()) {
					sql+=" AND s.estado in ('"+Constantes.ESTADO_ASSIGNED+"',"
							+ "'"+Constantes.ESTADO_PENDIENTE_RENDICION+"',"
							+ "'"+Constantes.ESTADO_RENDIDO_EFECTIVO+"') ";
				}else {
					sql+=" AND s.estado in ('"+Constantes.ESTADO_ASSIGNED+"',"
							+ "'"+Constantes.ESTADO_PENDIENTE_RENDICION+"',"
							+ "'"+Constantes.ESTADO_RENDIDO_EFECTIVO+"') ";
				}
				
				sql+=" AND s.fecfin < sysdate ORDER BY s."+order+" DESC ";

			}else {
				sql+=" AND s.estado = '"+estado+"' ORDER BY s."+order+" DESC ";
			}
		}else {
			sql+=" AND s.estado = '"+estado+"' ORDER BY s."+order+" DESC ";
		}
		
		
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
	
		if( solicitud.getCodTipoComision() != null ) {
			query.setParameter("tcomision", new Long(solicitud.getCodTipoComision()));
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



	public void actualizarEstado(Long id,String estado) {
		// TODO Auto-generated method stub
		javax.persistence.Query q = em.createNativeQuery("UPDATE SOLICITUDVIATICOS s SET s.ESTADO = '"+estado+"' where s.SOLICITUDVIATICOS_ID="+id);
		q.executeUpdate();
	}

}
