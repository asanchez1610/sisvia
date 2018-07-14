package com.pe.sisvia.model;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the VIATICO database table.
 * 
 */
@Entity
@NamedQuery(name="Viatico.findAll", query="SELECT v FROM Viatico v")
public class Viatico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VIATICO_VIATICOID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIATICO_VIATICOID_GENERATOR")
	@Column(name="VIATICO_ID")
	private Long viaticoId;

	private BigDecimal codviatico;

	private String destino;

	@Temporal(TemporalType.DATE)
	private Date fecaprobacion;

	@Temporal(TemporalType.DATE)
	private Date fecfin;

	@Temporal(TemporalType.DATE)
	private Date fecinicio;

	private Double montototal;

	private String motivocomision;

	//bi-directional many-to-one association to Presupuesto
	@ManyToOne
	@JoinColumn(name="PRESUPUESTO_ID")
	private Presupuesto presupuesto;

	//bi-directional many-to-one association to Solicitudviatico
	@ManyToOne
	@JoinColumn(name="SOLICITUDVIATICOS_ID")
	private Solicitudviatico solicitudviatico;
	
	@Transient
	private Tarjetacorporativa tarjetaCorporativa;

	public Tarjetacorporativa getTarjetaCorporativa() {
		return tarjetaCorporativa;
	}

	public void setTarjetaCorporativa(Tarjetacorporativa tarjetaCorporativa) {
		this.tarjetaCorporativa = tarjetaCorporativa;
	}
	
	@Transient
	private List<Conceptoasignado> conceptosAsignados;

	public List<Conceptoasignado> getConceptosAsignados() {
		return conceptosAsignados;
	}

	public void setConceptosAsignados(List<Conceptoasignado> conceptosAsignados) {
		this.conceptosAsignados = conceptosAsignados;
	}

	public Viatico() {
	}

	public Long getViaticoId() {
		return this.viaticoId;
	}

	public void setViaticoId(Long viaticoId) {
		this.viaticoId = viaticoId;
	}

	public BigDecimal getCodviatico() {
		return this.codviatico;
	}

	public void setCodviatico(BigDecimal codviatico) {
		this.codviatico = codviatico;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getFecaprobacion() {
		return this.fecaprobacion;
	}

	public void setFecaprobacion(Date fecaprobacion) {
		this.fecaprobacion = fecaprobacion;
	}

	public Date getFecfin() {
		return this.fecfin;
	}

	public void setFecfin(Date fecfin) {
		this.fecfin = fecfin;
	}

	public Date getFecinicio() {
		return this.fecinicio;
	}

	public void setFecinicio(Date fecinicio) {
		this.fecinicio = fecinicio;
	}

	public Double getMontototal() {
		return this.montototal;
	}

	public void setMontototal(Double montototal) {
		this.montototal = montototal;
	}

	public String getMotivocomision() {
		return this.motivocomision;
	}

	public void setMotivocomision(String motivocomision) {
		this.motivocomision = motivocomision;
	}

	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Solicitudviatico getSolicitudviatico() {
		return this.solicitudviatico;
	}

	public void setSolicitudviatico(Solicitudviatico solicitudviatico) {
		this.solicitudviatico = solicitudviatico;
	}
	

	
	

}