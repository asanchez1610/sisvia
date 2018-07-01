package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SOLICITUDVIATICOS database table.
 * 
 */
@Entity
@Table(name="SOLICITUDVIATICOS")
@NamedQuery(name="Solicitudviatico.findAll", query="SELECT s FROM Solicitudviatico s")
public class Solicitudviatico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOLICITUDVIATICOS_SOLICITUDVIATICOSID_GENERATOR", sequenceName="SQ_SOLICITUSVIATICOS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOLICITUDVIATICOS_SOLICITUDVIATICOSID_GENERATOR")
	@Column(name="SOLICITUDVIATICOS_ID")
	private long solicitudviaticosId;

	@Column(name="CENTROCOSTO_ID")
	private BigDecimal centrocostoId;

	private BigDecimal codsolicitud;

	@Column(name="COL_1")
	private BigDecimal col1;

	@Column(name="DESTINO_ID")
	private BigDecimal destinoId;

	private BigDecimal duracion;

	@Column(name="EMPLEADO_EMPLEADO_ID")
	private BigDecimal empleadoEmpleadoId;

	@Column(name="EMPLEADO_ID")
	private BigDecimal empleadoId;

	@Temporal(TemporalType.DATE)
	private Date fecfin;

	@Temporal(TemporalType.DATE)
	private Date fecinicio;

	@Temporal(TemporalType.DATE)
	private Date fecregistro;

	private BigDecimal horas;

	private String motivocomision;

	private String motivorechazo;

	private BigDecimal pernocta;

	@Column(name="TIPOCOMISION_ID")
	private BigDecimal tipocomisionId;

	public Solicitudviatico() {
	}

	public long getSolicitudviaticosId() {
		return this.solicitudviaticosId;
	}

	public void setSolicitudviaticosId(long solicitudviaticosId) {
		this.solicitudviaticosId = solicitudviaticosId;
	}

	public BigDecimal getCentrocostoId() {
		return this.centrocostoId;
	}

	public void setCentrocostoId(BigDecimal centrocostoId) {
		this.centrocostoId = centrocostoId;
	}

	public BigDecimal getCodsolicitud() {
		return this.codsolicitud;
	}

	public void setCodsolicitud(BigDecimal codsolicitud) {
		this.codsolicitud = codsolicitud;
	}

	public BigDecimal getCol1() {
		return this.col1;
	}

	public void setCol1(BigDecimal col1) {
		this.col1 = col1;
	}

	public BigDecimal getDestinoId() {
		return this.destinoId;
	}

	public void setDestinoId(BigDecimal destinoId) {
		this.destinoId = destinoId;
	}

	public BigDecimal getDuracion() {
		return this.duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		this.duracion = duracion;
	}

	public BigDecimal getEmpleadoEmpleadoId() {
		return this.empleadoEmpleadoId;
	}

	public void setEmpleadoEmpleadoId(BigDecimal empleadoEmpleadoId) {
		this.empleadoEmpleadoId = empleadoEmpleadoId;
	}

	public BigDecimal getEmpleadoId() {
		return this.empleadoId;
	}

	public void setEmpleadoId(BigDecimal empleadoId) {
		this.empleadoId = empleadoId;
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

	public BigDecimal getTipocomisionId() {
		return this.tipocomisionId;
	}

	public void setTipocomisionId(BigDecimal tipocomisionId) {
		this.tipocomisionId = tipocomisionId;
	}

}