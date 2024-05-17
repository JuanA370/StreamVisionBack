package com.example.demo.model.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class HiloId implements Serializable{

	@ManyToOne
    @JoinColumn(name = "id_producto")
	private Producto id_producto;
	
	private Long id_hilo;

	public HiloId(Producto id_producto, Long id_hilo) {
		super();
		this.id_producto = id_producto;
		this.id_hilo = id_hilo;
	}

	public Producto getId_producto() {
		return id_producto;
	}

	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}

	public Long getId_hilo() {
		return id_hilo;
	}

	public void setId_hilo(Long id_hilo) {
		this.id_hilo = id_hilo;
	}

	public HiloId() {
		super();
	}
	
	
}