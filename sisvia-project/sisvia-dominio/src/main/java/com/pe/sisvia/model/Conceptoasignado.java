package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONCEPTOASIGNADO database table.
 * 
 */
@Entity
@NamedQuery(name="Conceptoasignado.findAll", query="SELECT c FROM Conceptoasignado c")
public class Conceptoasignado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONCEPTOASIGNADO_CONCEPTOASIGNADOID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCEPTOASIGNADO_CONCEPTOASIGNADOID_GENERATOR")
	@Column(name="CONCEPTOASIGNADO_ID")
	private Long conceptoasignadoId;

	@Column(name="CONCEPTOGASTO_ID")
	private Long conceptogastoId;

	private double montogasto;

	@Column(name="VIATICO_ID")
	private Long viaticoId;

	public Conceptoasignado() {
	}

	public long getConceptoasignadoId() {
		return this.conceptoasignadoId;
	}

	public void setConceptoasignadoId(long conceptoasignadoId) {
		this.conceptoasignadoId = conceptoasignadoId;
	}

	public Long getConceptogastoId() {
		return this.conceptogastoId;
	}

	public void setConceptogastoId(Long conceptogastoId) {
		this.conceptogastoId = conceptogastoId;
	}

	public double getMontogasto() {
		return this.montogasto;
	}

	public void setMontogasto(double montogasto) {
		this.montogasto = montogasto;
	}

	public Long getViaticoId() {
		return this.viaticoId;
	}

	public void setViaticoId(Long viaticoId) {
		this.viaticoId = viaticoId;
	}

}