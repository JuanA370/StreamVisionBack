package com.example.demo.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class HiloId implements Serializable{

	private Long idProducto;
	private Long idHilo;
}