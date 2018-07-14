package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLEADO database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLEADO_EMPLEADOID_GENERATOR", sequenceName="SQ_AUTO_INCREMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLEADO_EMPLEADOID_GENERATOR")
	@Column(name="EMPLEADO_ID")
	private long empleadoId;

	private String apellido;

	private BigDecimal codemleado;

	private String correo;

	@Temporal(TemporalType.DATE)
	private Date fecnacimiento;

	private String nombre;

	private String numerodocuento;

	private String tipodocumento;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="AREA_ID")
	private Area area;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="CATEGORIA_ID")
	private Categoria categoria;

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

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}