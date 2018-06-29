package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TIPOCOMISION database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocomision.findAll", query="SELECT t FROM Tipocomision t")
public class Tipocomision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOCOMISION_TIPOCOMISIONID_GENERATOR", sequenceName="SQ_TIPOCOMISION_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOCOMISION_TIPOCOMISIONID_GENERATOR")
	@Column(name="TIPOCOMISION_ID")
	private long tipocomisionId;

	private BigDecimal codcomision;

	private String nomcomision;

	public Tipocomision() {
	}

	public long getTipocomisionId() {
		return this.tipocomisionId;
	}

	public void setTipocomisionId(long tipocomisionId) {
		this.tipocomisionId = tipocomisionId;
	}

	public BigDecimal getCodcomision() {
		return this.codcomision;
	}

	public void setCodcomision(BigDecimal codcomision) {
		this.codcomision = codcomision;
	}

	public String getNomcomision() {
		return this.nomcomision;
	}

	public void setNomcomision(String nomcomision) {
		this.nomcomision = nomcomision;
	}

}