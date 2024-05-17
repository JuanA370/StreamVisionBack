package com.example.demo.model.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class RespuestaId implements Serializable{
	
	private Long id_respuesta;
	private Long id_hilo;
	private Long id_producto;
	
	
	public RespuestaId(Long id_respuesta, Long id_hilo, Long id_producto) {
		super();
		this.id_respuesta = id_respuesta;
		this.id_hilo = id_hilo;
		this.id_producto = id_producto;
	}


	public RespuestaId() {
		super();
	}


	public Long getId_respuesta() {
		return id_respuesta;
	}


	public void setId_respuesta(Long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}


	public Long getId_hilo() {
		return id_hilo;
	}


	public void setId_hilo(Long id_hilo) {
		this.id_hilo = id_hilo;
	}


	public Long getId_producto() {
		return id_producto;
	}


	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	
}
