package com.pe.sisvia.model.vo;

import java.io.Serializable;

public class AsignacionRequestVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long solicitudviaticosId;

	private Double montoTotal;

	private Double montogastoMovilidad;

	private Double montogastoViatico;


	public Long getSolicitudviaticosId() {
		return solicitudviaticosId;
	}

	public void setSolicitudviaticosId(Long solicitudviaticosId) {
		this.solicitudviaticosId = solicitudviaticosId;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Double getMontogastoMovilidad() {
		return montogastoMovilidad;
	}

	public void setMontogastoMovilidad(Double montogastoMovilidad) {
		this.montogastoMovilidad = montogastoMovilidad;
	}

	public Double getMontogastoViatico() {
		return montogastoViatico;
	}

	public void setMontogastoViatico(Double montogastoViatico) {
		this.montogastoViatico = montogastoViatico;
	}

}
