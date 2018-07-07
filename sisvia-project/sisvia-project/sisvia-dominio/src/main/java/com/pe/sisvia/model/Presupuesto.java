package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRESUPUESTO database table.
 * 
 */
@Entity
@NamedQuery(name="Presupuesto.findAll", query="SELECT p FROM Presupuesto p")
public class Presupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRESUPUESTO_PRESUPUESTOID_GENERATOR", sequenceName="SQ_PRESUPUESTO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESUPUESTO_PRESUPUESTOID_GENERATOR")
	@Column(name="PRESUPUESTO_ID")
	private long presupuestoId;

	private String anno;

	@Column(name="CENTROCOSTO_ID")
	private BigDecimal centrocostoId;

	private BigDecimal codpresupuesto;

	private double presupuestoasignado;

	private double presupuestoejecutado;

	public Presupuesto() {
	}

	public long getPresupuestoId() {
		return this.presupuestoId;
	}

	public void setPresupuestoId(long presupuestoId) {
		this.presupuestoId = presupuestoId;
	}

	public String getAnno() {
		return this.anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public BigDecimal getCentrocostoId() {
		return this.centrocostoId;
	}

	public void setCentrocostoId(BigDecimal centrocostoId) {
		this.centrocostoId = centrocostoId;
	}

	public BigDecimal getCodpresupuesto() {
		return this.codpresupuesto;
	}

	public void setCodpresupuesto(BigDecimal codpresupuesto) {
		this.codpresupuesto = codpresupuesto;
	}

	public double getPresupuestoasignado() {
		return this.presupuestoasignado;
	}

	public void setPresupuestoasignado(double presupuestoasignado) {
		this.presupuestoasignado = presupuestoasignado;
	}

	public double getPresupuestoejecutado() {
		return this.presupuestoejecutado;
	}

	public void setPresupuestoejecutado(double presupuestoejecutado) {
		this.presupuestoejecutado = presupuestoejecutado;
	}

}