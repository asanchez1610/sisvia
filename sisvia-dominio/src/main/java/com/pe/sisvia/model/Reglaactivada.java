package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REGLAACTIVADA database table.
 * 
 */
@Entity
@NamedQuery(name="Reglaactivada.findAll", query="SELECT r FROM Reglaactivada r")
public class Reglaactivada implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReglaactivadaPK id;

	private String orden;

	public Reglaactivada() {
	}

	public ReglaactivadaPK getId() {
		return this.id;
	}

	public void setId(ReglaactivadaPK id) {
		this.id = id;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

}