package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REGLAACTIVADA database table.
 * 
 */
@Embeddable
public class ReglaactivadaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="VIATICO_ID")
	private long viaticoId;

	@Column(name="REGLANEGOCIO_ID")
	private long reglanegocioId;

	public ReglaactivadaPK() {
	}
	public long getViaticoId() {
		return this.viaticoId;
	}
	public void setViaticoId(long viaticoId) {
		this.viaticoId = viaticoId;
	}
	public long getReglanegocioId() {
		return this.reglanegocioId;
	}
	public void setReglanegocioId(long reglanegocioId) {
		this.reglanegocioId = reglanegocioId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReglaactivadaPK)) {
			return false;
		}
		ReglaactivadaPK castOther = (ReglaactivadaPK)other;
		return 
			(this.viaticoId == castOther.viaticoId)
			&& (this.reglanegocioId == castOther.reglanegocioId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.viaticoId ^ (this.viaticoId >>> 32)));
		hash = hash * prime + ((int) (this.reglanegocioId ^ (this.reglanegocioId >>> 32)));
		
		return hash;
	}
}