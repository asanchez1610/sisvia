package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONCEPTOASIGNADO database table.
 * 
 */
@Entity
@NamedQuery(name="Conceptoasignado.findAll", query="SELECT c FROM Conceptoasignado c")
public class Conceptoasignado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONCEPTOASIGNADO_VIATICOID_GENERATOR", sequenceName="SQ_CONCEPTOASIGNADO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCEPTOASIGNADO_VIATICOID_GENERATOR")
	@Column(name="VIATICO_ID")
	private long viaticoId;

	@Column(name="CONCEPTOGASTO_ID")
	private BigDecimal conceptogastoId;

	private double montogasto;

	public Conceptoasignado() {
	}

	public long getViaticoId() {
		return this.viaticoId;
	}

	public void setViaticoId(long viaticoId) {
		this.viaticoId = viaticoId;
	}

	public BigDecimal getConceptogastoId() {
		return this.conceptogastoId;
	}

	public void setConceptogastoId(BigDecimal conceptogastoId) {
		this.conceptogastoId = conceptogastoId;
	}

	public double getMontogasto() {
		return this.montogasto;
	}

	public void setMontogasto(double montogasto) {
		this.montogasto = montogasto;
	}

}