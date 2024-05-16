package com.example.demo.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class HiloId implements Serializable{

	private Long idProducto;
	private Long idHilo;
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Long getIdHilo() {
		return idHilo;
	}
	public void setIdHilo(Long idHilo) {
		this.idHilo = idHilo;
	}
}