package com.example.demo.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class FavoritoId implements Serializable{

	private Long idUsuario;
	private Long idProducto;
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	
}