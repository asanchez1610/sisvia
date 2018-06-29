package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DESTINO database table.
 * 
 */
@Entity
@NamedQuery(name="Destino.findAll", query="SELECT d FROM Destino d")
public class Destino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DESTINO_DESTINOID_GENERATOR", sequenceName="SQ_DESTINO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DESTINO_DESTINOID_GENERATOR")
	@Column(name="DESTINO_ID")
	private long destinoId;

	private BigDecimal coddestino;

	private String nomdestino;

	private BigDecimal zonacritica;

	public Destino() {
	}

	public long getDestinoId() {
		return this.destinoId;
	}

	public void setDestinoId(long destinoId) {
		this.destinoId = destinoId;
	}

	public BigDecimal getCoddestino() {
		return this.coddestino;
	}

	public void setCoddestino(BigDecimal coddestino) {
		this.coddestino = coddestino;
	}

	public String getNomdestino() {
		return this.nomdestino;
	}

	public void setNomdestino(String nomdestino) {
		this.nomdestino = nomdestino;
	}

	public BigDecimal getZonacritica() {
		return this.zonacritica;
	}

	public void setZonacritica(BigDecimal zonacritica) {
		this.zonacritica = zonacritica;
	}

}