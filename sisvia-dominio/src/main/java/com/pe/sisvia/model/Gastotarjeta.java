package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GASTOTARJETA database table.
 * 
 */
@Entity
@NamedQuery(name="Gastotarjeta.findAll", query="SELECT g FROM Gastotarjeta g")
public class Gastotarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GASTOTARJETA_RENDICIONID_GENERATOR", sequenceName="SQ_GASTOTARJETA_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GASTOTARJETA_RENDICIONID_GENERATOR")
	@Column(name="RENDICION_ID")
	private long rendicionId;

	@Column(name="CONCEPTOGASTO_ID")
	private BigDecimal conceptogastoId;

	@Temporal(TemporalType.DATE)
	private Date fecoperacion;

	private double montocomprobante;

	private String nrocomprobante;

	@Column(name="PROVEEDOR_ID")
	private BigDecimal proveedorId;

	@Column(name="TIPOCOMPROBANTE_ID")
	private BigDecimal tipocomprobanteId;

	public Gastotarjeta() {
	}

	public long getRendicionId() {
		return this.rendicionId;
	}

	public void setRendicionId(long rendicionId) {
		this.rendicionId = rendicionId;
	}

	public BigDecimal getConceptogastoId() {
		return this.conceptogastoId;
	}

	public void setConceptogastoId(BigDecimal conceptogastoId) {
		this.conceptogastoId = conceptogastoId;
	}

	public Date getFecoperacion() {
		return this.fecoperacion;
	}

	public void setFecoperacion(Date fecoperacion) {
		this.fecoperacion = fecoperacion;
	}

	public double getMontocomprobante() {
		return this.montocomprobante;
	}

	public void setMontocomprobante(double montocomprobante) {
		this.montocomprobante = montocomprobante;
	}

	public String getNrocomprobante() {
		return this.nrocomprobante;
	}

	public void setNrocomprobante(String nrocomprobante) {
		this.nrocomprobante = nrocomprobante;
	}

	public BigDecimal getProveedorId() {
		return this.proveedorId;
	}

	public void setProveedorId(BigDecimal proveedorId) {
		this.proveedorId = proveedorId;
	}

	public BigDecimal getTipocomprobanteId() {
		return this.tipocomprobanteId;
	}

	public void setTipocomprobanteId(BigDecimal tipocomprobanteId) {
		this.tipocomprobanteId = tipocomprobanteId;
	}

}