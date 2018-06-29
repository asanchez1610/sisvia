package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TARJETACORPORATIVA database table.
 * 
 */
@Entity
@NamedQuery(name="Tarjetacorporativa.findAll", query="SELECT t FROM Tarjetacorporativa t")
public class Tarjetacorporativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TARJETACORPORATIVA_TARJETACORPORATIVAID_GENERATOR", sequenceName="SQ_TARJETACOOPERATIVA_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TARJETACORPORATIVA_TARJETACORPORATIVAID_GENERATOR")
	@Column(name="TARJETACORPORATIVA_ID")
	private long tarjetacorporativaId;

	private double credito;

	@Temporal(TemporalType.DATE)
	private Date fecactivacion;

	@Temporal(TemporalType.DATE)
	private Date feccancelacion;

	@Temporal(TemporalType.DATE)
	private Date fecregistro;

	private String numcuenta;

	private String numtarjeta;

	@Column(name="VIATICO_ID")
	private BigDecimal viaticoId;

	public Tarjetacorporativa() {
	}

	public long getTarjetacorporativaId() {
		return this.tarjetacorporativaId;
	}

	public void setTarjetacorporativaId(long tarjetacorporativaId) {
		this.tarjetacorporativaId = tarjetacorporativaId;
	}

	public double getCredito() {
		return this.credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public Date getFecactivacion() {
		return this.fecactivacion;
	}

	public void setFecactivacion(Date fecactivacion) {
		this.fecactivacion = fecactivacion;
	}

	public Date getFeccancelacion() {
		return this.feccancelacion;
	}

	public void setFeccancelacion(Date feccancelacion) {
		this.feccancelacion = feccancelacion;
	}

	public Date getFecregistro() {
		return this.fecregistro;
	}

	public void setFecregistro(Date fecregistro) {
		this.fecregistro = fecregistro;
	}

	public String getNumcuenta() {
		return this.numcuenta;
	}

	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}

	public String getNumtarjeta() {
		return this.numtarjeta;
	}

	public void setNumtarjeta(String numtarjeta) {
		this.numtarjeta = numtarjeta;
	}

	public BigDecimal getViaticoId() {
		return this.viaticoId;
	}

	public void setViaticoId(BigDecimal viaticoId) {
		this.viaticoId = viaticoId;
	}

}