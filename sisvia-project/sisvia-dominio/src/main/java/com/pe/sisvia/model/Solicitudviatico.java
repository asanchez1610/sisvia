package com.pe.sisvia.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The persistent class for the SOLICITUDVIATICOS database table.
 * 
 */
@Entity
@Table(name = "SOLICITUDVIATICOS")
@NamedQuery(name = "Solicitudviatico.findAll", query = "SELECT s FROM Solicitudviatico s ORDER BY s.solicitudviaticosId DESC")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Solicitudviatico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SOLICITUDVIATICOS_SOLICITUDVIATICOSID_GENERATOR", sequenceName = "SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOLICITUDVIATICOS_SOLICITUDVIATICOSID_GENERATOR")
	@Column(name = "SOLICITUDVIATICOS_ID")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long solicitudviaticosId;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private BigDecimal codsolicitud;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private BigDecimal duracion;

	@Temporal(TemporalType.DATE)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date fecautoriza;

	@Temporal(TemporalType.DATE)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date fecfin;

	@Temporal(TemporalType.DATE)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date fecinicio;

	@Temporal(TemporalType.DATE)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date fecregistro;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private BigDecimal horas;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String motivocomision;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String motivorechazo;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private BigDecimal pernocta;

	// bi-directional many-to-one association to Destino
	@ManyToOne
	@JoinColumn(name = "DESTINO_ID")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Destino destino;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "EMPLEADOAUTORIZA_ID")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Empleado empleadoAuroriza;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "EMPLEADOCOMISIONADO_ID")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Empleado empleadoComisionado;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "EMPLEADOSOLICITA_ID")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Empleado empleadoSolicita;

	// bi-directional many-to-one association to Tipocomision
	@ManyToOne
	@JoinColumn(name = "TIPOCOMISION_ID")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Tipocomision tipocomision;

	@Column(name = "ESTADO")
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Solicitudviatico() {
	}

	public Long getSolicitudviaticosId() {
		return this.solicitudviaticosId;
	}

	public void setSolicitudviaticosId(Long solicitudviaticosId) {
		this.solicitudviaticosId = solicitudviaticosId;
	}

	public BigDecimal getCodsolicitud() {
		return this.codsolicitud;
	}

	public void setCodsolicitud(BigDecimal codsolicitud) {
		this.codsolicitud = codsolicitud;
	}

	public BigDecimal getDuracion() {
		return this.duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		this.duracion = duracion;
	}

	public Date getFecautoriza() {
		return this.fecautoriza;
	}

	public void setFecautoriza(Date fecautoriza) {
		this.fecautoriza = fecautoriza;
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

	public Date getFecregistro() {
		return this.fecregistro;
	}

	public void setFecregistro(Date fecregistro) {
		this.fecregistro = fecregistro;
	}

	public BigDecimal getHoras() {
		return this.horas;
	}

	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}

	public String getMotivocomision() {
		return this.motivocomision;
	}

	public void setMotivocomision(String motivocomision) {
		this.motivocomision = motivocomision;
	}

	public String getMotivorechazo() {
		return this.motivorechazo;
	}

	public void setMotivorechazo(String motivorechazo) {
		this.motivorechazo = motivorechazo;
	}

	public BigDecimal getPernocta() {
		return this.pernocta;
	}

	public void setPernocta(BigDecimal pernocta) {
		this.pernocta = pernocta;
	}

	public Destino getDestino() {
		return this.destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Empleado getEmpleadoAuroriza() {
		return empleadoAuroriza;
	}

	public void setEmpleadoAuroriza(Empleado empleadoAuroriza) {
		this.empleadoAuroriza = empleadoAuroriza;
	}

	public Empleado getEmpleadoComisionado() {
		return empleadoComisionado;
	}

	public void setEmpleadoComisionado(Empleado empleadoComisionado) {
		this.empleadoComisionado = empleadoComisionado;
	}

	public Empleado getEmpleadoSolicita() {
		return empleadoSolicita;
	}

	public void setEmpleadoSolicita(Empleado empleadoSolicita) {
		this.empleadoSolicita = empleadoSolicita;
	}

	public Tipocomision getTipocomision() {
		return this.tipocomision;
	}

	public void setTipocomision(Tipocomision tipocomision) {
		this.tipocomision = tipocomision;
	}

	// Atributos trasient
	@Transient
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String strFechaInicio;

	@Transient
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Viatico viatico;

	public Viatico getViatico() {
		return viatico;
	}

	public void setViatico(Viatico viatico) {
		this.viatico = viatico;
	}

	public String getStrFechaInicio() {
		return strFechaInicio;
	}

	public void setStrFechaInicio(String strFechaInicio) {
		this.strFechaInicio = strFechaInicio;
	}

	@Transient
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String strFechaFin;

	public String getStrFechaFin() {
		return strFechaFin;
	}

	public void setStrFechaFin(String strFechaFin) {
		this.strFechaFin = strFechaFin;
	}

	@Transient
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String numDni;

	public String getNumDni() {
		return numDni;
	}

	public void setNumDni(String numDni) {
		this.numDni = numDni;
	}

	@Transient
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String nombreCompleto;

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Transient
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String codCentroCosto;

	public String getCodCentroCosto() {
		return codCentroCosto;
	}

	public void setCodCentroCosto(String codCentroCosto) {
		this.codCentroCosto = codCentroCosto;
	}

}