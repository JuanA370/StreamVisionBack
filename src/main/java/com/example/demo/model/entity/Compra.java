package com.example.demo.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Compra {
	@EmbeddedId
	private CompraId idCompra;
	
	@Column
	private Date fecha;
	
	//Constructores
	public Compra() {

	}

	public Compra(CompraId idCompra, Date fecha) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
	}

	public CompraId getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(CompraId idCompra) {
		this.idCompra = idCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
