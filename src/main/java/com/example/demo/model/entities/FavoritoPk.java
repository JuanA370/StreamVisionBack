package com.example.demo.model.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class FavoritoPk implements Serializable {

	private long idUsuario;

	private long idProducto;

}