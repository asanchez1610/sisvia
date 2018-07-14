package com.pe.sisvia.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * The persistent class for the CENTROCOSTO database table.
 * 
 */
@Entity
@NamedQuery(name = "Centrocosto.findAll", query = "SELECT c FROM Centrocosto c")
public class Centrocosto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CENTROCOSTO_CENTROCOSTOID_GENERATOR", sequenceName = "SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CENTROCOSTO_CENTROCOSTOID_GENERATOR")
	@Column(name = "CENTROCOSTO_ID")
	private long centrocostoId;

	private BigDecimal codcc;

	private String nomcc;

	@OneToOne(mappedBy = "centrocosto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JsonManagedReference
	private Presupuesto presupuesto;

	public Centrocosto() {
	}

	public long getCentrocostoId() {
		return this.centrocostoId;
	}

	public void setCentrocostoId(long centrocostoId) {
		this.centrocostoId = centrocostoId;
	}

	public BigDecimal getCodcc() {
		return this.codcc;
	}

	public void setCodcc(BigDecimal codcc) {
		this.codcc = codcc;
	}

	public String getNomcc() {
		return this.nomcc;
	}

	public void setNomcc(String nomcc) {
		this.nomcc = nomcc;
	}

	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	

}