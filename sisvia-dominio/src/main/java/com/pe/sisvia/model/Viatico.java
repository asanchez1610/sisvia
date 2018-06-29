package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VIATICO database table.
 * 
 */
@Entity
@NamedQuery(name="Viatico.findAll", query="SELECT v FROM Viatico v")
public class Viatico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VIATICO_VIATICOID_GENERATOR", sequenceName="SQ_VIATICO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIATICO_VIATICOID_GENERATOR")
	@Column(name="VIATICO_ID")
	private long viaticoId;

	private BigDecimal codviatico;

	private String destino;

	@Column(name="EMPLEADO_ID")
	private BigDecimal empleadoId;

	@Temporal(TemporalType.DATE)
	private Date fecaprobacion;

	@Temporal(TemporalType.DATE)
	private Date fecautoriza;

	@Temporal(TemporalType.DATE)
	private Date fecfin;

	@Temporal(TemporalType.DATE)
	private Date fecinicio;

	private double montototal;

	private String motivocomision;

	@Column(name="PRESUPUESTO_ID")
	private BigDecimal presupuestoId;

	@Column(name="SOLICITUDVIATICOS_ID")
	private BigDecimal solicitudviaticosId;

	public Viatico() {
	}

	public long getViaticoId() {
		return this.viaticoId;
	}

	public void setViaticoId(long viaticoId) {
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

	public BigDecimal getEmpleadoId() {
		return this.empleadoId;
	}

	public void setEmpleadoId(BigDecimal empleadoId) {
		this.empleadoId = empleadoId;
	}

	public Date getFecaprobacion() {
		return this.fecaprobacion;
	}

	public void setFecaprobacion(Date fecaprobacion) {
		this.fecaprobacion = fecaprobacion;
	}

	public Date getFecautoriza() {
		return this.fecautoriza;
	}

	public void setFecautoriza(Date fecautoriza) {
		this.fecautoriza = fecautoriza;
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

	public double getMontototal() {
		return this.montototal;
	}

	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}

	public String getMotivocomision() {
		return this.motivocomision;
	}

	public void setMotivocomision(String motivocomision) {
		this.motivocomision = motivocomision;
	}

	public BigDecimal getPresupuestoId() {
		return this.presupuestoId;
	}

	public void setPresupuestoId(BigDecimal presupuestoId) {
		this.presupuestoId = presupuestoId;
	}

	public BigDecimal getSolicitudviaticosId() {
		return this.solicitudviaticosId;
	}

	public void setSolicitudviaticosId(BigDecimal solicitudviaticosId) {
		this.solicitudviaticosId = solicitudviaticosId;
	}

}