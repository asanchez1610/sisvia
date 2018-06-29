package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CENTROCOSTO database table.
 * 
 */
@Entity
@NamedQuery(name="Centrocosto.findAll", query="SELECT c FROM Centrocosto c")
public class Centrocosto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CENTROCOSTO_CENTROCOSTOID_GENERATOR", sequenceName="SQ_CENTROCOSTO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CENTROCOSTO_CENTROCOSTOID_GENERATOR")
	@Column(name="CENTROCOSTO_ID")
	private long centrocostoId;

	private BigDecimal codcc;

	private String nomcc;

	@Column(name="VIATICO_ID")
	private BigDecimal viaticoId;

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

	public BigDecimal getViaticoId() {
		return this.viaticoId;
	}

	public void setViaticoId(BigDecimal viaticoId) {
		this.viaticoId = viaticoId;
	}

}