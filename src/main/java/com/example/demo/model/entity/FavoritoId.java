package com.example.demo.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class FavoritoId implements Serializable{

	@ManyToOne
    @JoinColumn(name = "id_usuario")
	private Usuario id_usuario;
	
	@ManyToOne
    @JoinColumn(name = "id_producto")
	private Producto id_producto;

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Producto getId_producto() {
		return id_producto;
	}

	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}

	public FavoritoId(Usuario id_usuario, Producto id_producto) {
		super();
		this.id_usuario = id_usuario;
		this.id_producto = id_producto;
	}

	public FavoritoId() {
		super();
	}
	
	
}