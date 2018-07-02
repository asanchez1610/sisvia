package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONCEPTOGASTO database table.
 * 
 */
@Entity
@NamedQuery(name="Conceptogasto.findAll", query="SELECT c FROM Conceptogasto c")
public class Conceptogasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONCEPTOGASTO_CONCEPTOGASTOID_GENERATOR", sequenceName="SQ_CONCEPTOGASTO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONCEPTOGASTO_CONCEPTOGASTOID_GENERATOR")
	@Column(name="CONCEPTOGASTO_ID")
	private long conceptogastoId;

	private BigDecimal codconcepto;

	private String nomconcepto;

	public Conceptogasto() {
	}

	public long getConceptogastoId() {
		return this.conceptogastoId;
	}

	public void setConceptogastoId(long conceptogastoId) {
		this.conceptogastoId = conceptogastoId;
	}

	public BigDecimal getCodconcepto() {
		return this.codconcepto;
	}

	public void setCodconcepto(BigDecimal codconcepto) {
		this.codconcepto = codconcepto;
	}

	public String getNomconcepto() {
		return this.nomconcepto;
	}

	public void setNomconcepto(String nomconcepto) {
		this.nomconcepto = nomconcepto;
	}

}