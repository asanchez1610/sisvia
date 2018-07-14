package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RENDICION database table.
 * 
 */
@Entity
@NamedQuery(name="Rendicion.findAll", query="SELECT r FROM Rendicion r")
public class Rendicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RENDICION_RENDICIONID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RENDICION_RENDICIONID_GENERATOR")
	@Column(name="RENDICION_ID")
	private long rendicionId;

	private BigDecimal codrendicion;

	private BigDecimal duracion;

	@Temporal(TemporalType.DATE)
	private Date fecfin;

	@Temporal(TemporalType.DATE)
	private Date fecinicio;

	private double montodevolucion;

	private double montototal;

	//bi-directional one-to-one association to Gasto
	@OneToOne(mappedBy="rendicion")
	private Gasto gasto;

	//bi-directional many-to-one association to Viatico
	@ManyToOne
	@JoinColumn(name="VIATICO_ID")
	private Viatico viatico;

	public Rendicion() {
	}

	public long getRendicionId() {
		return this.rendicionId;
	}

	public void setRendicionId(long rendicionId) {
		this.rendicionId = rendicionId;
	}

	public BigDecimal getCodrendicion() {
		return this.codrendicion;
	}

	public void setCodrendicion(BigDecimal codrendicion) {
		this.codrendicion = codrendicion;
	}

	public BigDecimal getDuracion() {
		return this.duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		this.duracion = duracion;
	}

	public Date getFecfin() {
		return this.fecfin;
	}

	public void setFecfin(Date fecfin) {
		this.fecfin = fecfin;
	}

	public Date getFecinicio() {
		return this.fecinicio;
	}

	public void setFecinicio(Date fecinicio) {
		this.fecinicio = fecinicio;
	}

	public double getMontodevolucion() {
		return this.montodevolucion;
	}

	public void setMontodevolucion(double montodevolucion) {
		this.montodevolucion = montodevolucion;
	}

	public double getMontototal() {
		return this.montototal;
	}

	public void setMontototal(double montototal) {
		this.montototal = montototal;
	}

	public Gasto getGasto() {
		return this.gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}

	public Viatico getViatico() {
		return this.viatico;
	}

	public void setViatico(Viatico viatico) {
		this.viatico = viatico;
	}

}