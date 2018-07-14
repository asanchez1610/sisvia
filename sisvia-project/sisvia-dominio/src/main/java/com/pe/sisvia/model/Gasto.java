package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the GASTO database table.
 * 
 */
@Entity
@NamedQuery(name="Gasto.findAll", query="SELECT g FROM Gasto g")
public class Gasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GASTO_RENDICIONID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GASTO_RENDICIONID_GENERATOR")
	@Column(name="RENDICION_ID")
	private long rendicionId;

	@Temporal(TemporalType.DATE)
	private Date fecregistrogasto;

	private String tipogasto;

	//bi-directional one-to-one association to Rendicion
	@OneToOne
	@JoinColumn(name="RENDICION_ID")
	private Rendicion rendicion;

	//bi-directional one-to-one association to Gastoefectivo
	@OneToOne(mappedBy="gasto")
	private Gastoefectivo gastoefectivo;

	//bi-directional one-to-one association to Gastotarjeta
	@OneToOne(mappedBy="gasto")
	private Gastotarjeta gastotarjeta;

	public Gasto() {
	}

	public long getRendicionId() {
		return this.rendicionId;
	}

	public void setRendicionId(long rendicionId) {
		this.rendicionId = rendicionId;
	}

	public Date getFecregistrogasto() {
		return this.fecregistrogasto;
	}

	public void setFecregistrogasto(Date fecregistrogasto) {
		this.fecregistrogasto = fecregistrogasto;
	}

	public String getTipogasto() {
		return this.tipogasto;
	}

	public void setTipogasto(String tipogasto) {
		this.tipogasto = tipogasto;
	}

	public Rendicion getRendicion() {
		return this.rendicion;
	}

	public void setRendicion(Rendicion rendicion) {
		this.rendicion = rendicion;
	}

	public Gastoefectivo getGastoefectivo() {
		return this.gastoefectivo;
	}

	public void setGastoefectivo(Gastoefectivo gastoefectivo) {
		this.gastoefectivo = gastoefectivo;
	}

	public Gastotarjeta getGastotarjeta() {
		return this.gastotarjeta;
	}

	public void setGastotarjeta(Gastotarjeta gastotarjeta) {
		this.gastotarjeta = gastotarjeta;
	}

}