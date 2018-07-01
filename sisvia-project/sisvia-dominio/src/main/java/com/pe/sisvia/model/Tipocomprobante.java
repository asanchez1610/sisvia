package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPOCOMPROBANTE database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocomprobante.findAll", query="SELECT t FROM Tipocomprobante t")
public class Tipocomprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOCOMPROBANTE_TIPOCOMPROBANTEID_GENERATOR", sequenceName="SQ_TIPOCOMPROBANTE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOCOMPROBANTE_TIPOCOMPROBANTEID_GENERATOR")
	@Column(name="TIPOCOMPROBANTE_ID")
	private long tipocomprobanteId;

	private String descripcion;

	private String tipocomprobante;

	public Tipocomprobante() {
	}

	public long getTipocomprobanteId() {
		return this.tipocomprobanteId;
	}

	public void setTipocomprobanteId(long tipocomprobanteId) {
		this.tipocomprobanteId = tipocomprobanteId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipocomprobante() {
		return this.tipocomprobante;
	}

	public void setTipocomprobante(String tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}

}