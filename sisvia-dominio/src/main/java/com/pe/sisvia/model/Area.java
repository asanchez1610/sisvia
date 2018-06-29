package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AREA database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_AREAID_GENERATOR", sequenceName="SQ_AREA_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_AREAID_GENERATOR")
	@Column(name="AREA_ID")
	private long areaId;

	@Column(name="CENTROCOSTO_ID")
	private BigDecimal centrocostoId;

	private BigDecimal codarea;

	private String nomarea;

	public Area() {
	}

	public long getAreaId() {
		return this.areaId;
	}

	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	public BigDecimal getCentrocostoId() {
		return this.centrocostoId;
	}

	public void setCentrocostoId(BigDecimal centrocostoId) {
		this.centrocostoId = centrocostoId;
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

}