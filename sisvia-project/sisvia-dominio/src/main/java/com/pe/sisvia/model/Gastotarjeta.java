package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
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
	@SequenceGenerator(name="GASTOTARJETA_RENDICIONID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GASTOTARJETA_RENDICIONID_GENERATOR")
	@Column(name="ID")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fecoperacion;

	private double montocomprobante;

	private String nrocomprobante;

	@Column(name="RENDICION_ID")
	private Long rendicionId;
	
	//bi-directional many-to-one association to Conceptogasto
//	@ManyToOne
//	@JoinColumn(name="CONCEPTOGASTO_ID")
//	private Conceptogasto conceptogasto;

	//bi-directional one-to-one association to Gasto
//	@OneToOne
//	@JoinColumn(name="RENDICION_ID")
//	private Gasto gasto;

	//bi-directional many-to-one association to Proveedor
//	@ManyToOne
//	@JoinColumn(name="PROVEEDOR_ID")
//	private Proveedor proveedor;

	//bi-directional many-to-one association to Tipocomprobante
//	@ManyToOne
//	@JoinColumn(name="TIPOCOMPROBANTE_ID")
//	private Tipocomprobante tipocomprobante;

	public Long getRendicionId() {
		return rendicionId;
	}

	public void setRendicionId(Long rendicionId) {
		this.rendicionId = rendicionId;
	}

	public Gastotarjeta() {
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

//	public Conceptogasto getConceptogasto() {
//		return this.conceptogasto;
//	}
//
//	public void setConceptogasto(Conceptogasto conceptogasto) {
//		this.conceptogasto = conceptogasto;
//	}

//	public Gasto getGasto() {
//		return this.gasto;
//	}
//
//	public void setGasto(Gasto gasto) {
//		this.gasto = gasto;
//	}
//
//	public Proveedor getProveedor() {
//		return this.proveedor;
//	}
//
//	public void setProveedor(Proveedor proveedor) {
//		this.proveedor = proveedor;
//	}
//
//	public Tipocomprobante getTipocomprobante() {
//		return this.tipocomprobante;
//	}
//
//	public void setTipocomprobante(Tipocomprobante tipocomprobante) {
//		this.tipocomprobante = tipocomprobante;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}