package com.pe.sisvia.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the PRESUPUESTO database table.
 * 
 */
@Entity
@NamedQuery(name="Presupuesto.findAll", query="SELECT p FROM Presupuesto p")
public class Presupuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRESUPUESTO_PRESUPUESTOID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRESUPUESTO_PRESUPUESTOID_GENERATOR")
	@Column(name="PRESUPUESTO_ID")
	private long presupuestoId;

	private String anno;

	private BigDecimal codpresupuesto;

	private double presupuestoasignado;

	private double presupuestoejecutado;

	//bi-directional many-to-one association to Centrocosto
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CENTROCOSTO_ID")
	@JsonBackReference
	private Centrocosto centrocosto;

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

	public Centrocosto getCentrocosto() {
		return this.centrocosto;
	}

	public void setCentrocosto(Centrocosto centrocosto) {
		this.centrocosto = centrocosto;
	}

}