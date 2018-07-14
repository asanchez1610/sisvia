package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AREA database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_AREAID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_AREAID_GENERATOR")
	@Column(name="AREA_ID")
	private long areaId;

	private BigDecimal codarea;

	private String nomarea;

	//bi-directional many-to-one association to Centrocosto
	@ManyToOne
	@JoinColumn(name="CENTROCOSTO_ID")
	private Centrocosto centrocosto;


	public Area() {
	}

	public long getAreaId() {
		return this.areaId;
	}

	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	public BigDecimal getCodarea() {
		return this.codarea;
	}

	public void setCodarea(BigDecimal codarea) {
		this.codarea = codarea;
	}

	public String getNomarea() {
		return this.nomarea;
	}

	public void setNomarea(String nomarea) {
		this.nomarea = nomarea;
	}

	public Centrocosto getCentrocosto() {
		return this.centrocosto;
	}

	public void setCentrocosto(Centrocosto centrocosto) {
		this.centrocosto = centrocosto;
	}


}