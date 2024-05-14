package com.example.demo.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class FavoritoId implements Serializable{

	private Long idUsuario;
	private Long idProducto;
	
}