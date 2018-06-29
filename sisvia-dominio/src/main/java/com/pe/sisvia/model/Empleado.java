package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EMPLEADO database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLEADO_EMPLEADOID_GENERATOR", sequenceName="SQ_EMPLEADO_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLEADO_EMPLEADOID_GENERATOR")
	@Column(name="EMPLEADO_ID")
	private long empleadoId;

	private String apellido;

	@Column(name="AREA_ID")
	private BigDecimal areaId;

	@Column(name="CATEGORIA_ID")
	private BigDecimal categoriaId;

	private BigDecimal codemleado;

	private String correo;

	@Temporal(TemporalType.DATE)
	private Date fecnacimiento;

	private String nombre;

	private String numerodocuento;

	private String tipodocumento;

	public Empleado() {
	}

	public long getEmpleadoId() {
		return this.empleadoId;
	}

	public void setEmpleadoId(long empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public BigDecimal getAreaId() {
		return this.areaId;
	}

	public void setAreaId(BigDecimal areaId) {
		this.areaId = areaId;
	}

	public BigDecimal getCategoriaId() {
		return this.categoriaId;
	}

	public void setCategoriaId(BigDecimal categoriaId) {
		this.categoriaId = categoriaId;
	}

	public BigDecimal getCodemleado() {
		return this.codemleado;
	}

	public void setCodemleado(BigDecimal codemleado) {
		this.codemleado = codemleado;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFecnacimiento() {
		return this.fecnacimiento;
	}

	public void setFecnacimiento(Date fecnacimiento) {
		this.fecnacimiento = fecnacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumerodocuento() {
		return this.numerodocuento;
	}

	public void setNumerodocuento(String numerodocuento) {
		this.numerodocuento = numerodocuento;
	}

	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

}