package com.pe.sisvia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CATEGORIA database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIA_CATEGORIAID_GENERATOR", sequenceName="SQ_CATEGORIA_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIA_CATEGORIAID_GENERATOR")
	@Column(name="CATEGORIA_ID")
	private long categoriaId;

	private BigDecimal codcategoria;

	private String nomcategoria;

	public Categoria() {
	}

	public long getCategoriaId() {
		return this.categoriaId;
	}

	public void setCategoriaId(long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public BigDecimal getCodcategoria() {
		return this.codcategoria;
	}

	public void setCodcategoria(BigDecimal codcategoria) {
		this.codcategoria = codcategoria;
	}

	public String getNomcategoria() {
		return this.nomcategoria;
	}

	public void setNomcategoria(String nomcategoria) {
		this.nomcategoria = nomcategoria;
	}
	
	

}