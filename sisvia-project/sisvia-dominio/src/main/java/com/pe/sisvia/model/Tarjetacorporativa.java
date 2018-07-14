package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
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
	@SequenceGenerator(name="TARJETACORPORATIVA_TARJETACORPORATIVAID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TARJETACORPORATIVA_TARJETACORPORATIVAID_GENERATOR")
	@Column(name="TARJETACORPORATIVA_ID")
	private Long tarjetacorporativaId;

	private Double credito;

	@Temporal(TemporalType.DATE)
	private Date fecactivacion;

	@Temporal(TemporalType.DATE)
	private Date feccancelacion;

	@Temporal(TemporalType.DATE)
	private Date fecregistro;

	private String numcuenta;

	private String numtarjeta;

	//bi-directional many-to-one association to Viatico
	@ManyToOne
	@JoinColumn(name="VIATICO_ID")
	private Viatico viatico;

	public Tarjetacorporativa() {
	}

	public Long getTarjetacorporativaId() {
		return this.tarjetacorporativaId;
	}

	public void setTarjetacorporativaId(Long tarjetacorporativaId) {
		this.tarjetacorporativaId = tarjetacorporativaId;
	}

	public Double getCredito() {
		return this.credito;
	}

	public void setCredito(Double credito) {
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

	public Viatico getViatico() {
		return this.viatico;
	}

	public void setViatico(Viatico viatico) {
		this.viatico = viatico;
	}

}