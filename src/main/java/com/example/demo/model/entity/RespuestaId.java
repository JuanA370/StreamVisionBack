package com.example.demo.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class RespuestaId implements Serializable{
	
	private Long id_respuesta;
	private Long id_hilo;
	private Long id_producto;
}
