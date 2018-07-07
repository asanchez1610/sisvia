package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the GASTOEFECTIVO database table.
 * 
 */
@Entity
@NamedQuery(name="Gastoefectivo.findAll", query="SELECT g FROM Gastoefectivo g")
public class Gastoefectivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GASTOEFECTIVO_RENDICIONID_GENERATOR", sequenceName="SQ_GASTOEFECTIVO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GASTOEFECTIVO_RENDICIONID_GENERATOR")
	@Column(name="RENDICION_ID")
	private long rendicionId;

	@Temporal(TemporalType.DATE)
	private Date fecgasto;

	private double montogasto;

	private String observacion;

	public Gastoefectivo() {
	}

	public long getRendicionId() {
		return this.rendicionId;
	}

	public void setRendicionId(long rendicionId) {
		this.rendicionId = rendicionId;
	}

	public Date getFecgasto() {
		return this.fecgasto;
	}

	public void setFecgasto(Date fecgasto) {
		this.fecgasto = fecgasto;
	}

	public double getMontogasto() {
		return this.montogasto;
	}

	public void setMontogasto(double montogasto) {
		this.montogasto = montogasto;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}