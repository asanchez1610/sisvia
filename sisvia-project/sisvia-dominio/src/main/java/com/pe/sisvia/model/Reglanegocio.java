package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the REGLANEGOCIO database table.
 * 
 */
@Entity
@NamedQuery(name="Reglanegocio.findAll", query="SELECT r FROM Reglanegocio r")
public class Reglanegocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGLANEGOCIO_REGLANEGOCIOID_GENERATOR", sequenceName="SQ_REGLANEGOCIO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGLANEGOCIO_REGLANEGOCIOID_GENERATOR")
	@Column(name="REGLANEGOCIO_ID")
	private long reglanegocioId;

	private BigDecimal codregla;

	private BigDecimal conclusion;

	private String condicion;

	private String ordenevaluacion;

	public Reglanegocio() {
	}

	public long getReglanegocioId() {
		return this.reglanegocioId;
	}

	public void setReglanegocioId(long reglanegocioId) {
		this.reglanegocioId = reglanegocioId;
	}

	public BigDecimal getCodregla() {
		return this.codregla;
	}

	public void setCodregla(BigDecimal codregla) {
		this.codregla = codregla;
	}

	public BigDecimal getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(BigDecimal conclusion) {
		this.conclusion = conclusion;
	}

	public String getCondicion() {
		return this.condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getOrdenevaluacion() {
		return this.ordenevaluacion;
	}

	public void setOrdenevaluacion(String ordenevaluacion) {
		this.ordenevaluacion = ordenevaluacion;
	}

}