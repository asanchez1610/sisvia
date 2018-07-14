package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROVEEDOR database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROVEEDOR_PROVEEDORID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROVEEDOR_PROVEEDORID_GENERATOR")
	@Column(name="PROVEEDOR_ID")
	private long proveedorId;

	private String nomproveedor;

	private String ruc;

	public Proveedor() {
	}

	public long getProveedorId() {
		return this.proveedorId;
	}

	public void setProveedorId(long proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getNomproveedor() {
		return this.nomproveedor;
	}

	public void setNomproveedor(String nomproveedor) {
		this.nomproveedor = nomproveedor;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

}