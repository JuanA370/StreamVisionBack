package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Favorito {
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	private int id_producto;

	@Column
	private boolean favorito;

	//Constructores
	public Favorito() {

	}

	public Favorito(int id_usuario, int id_producto, boolean fecha) {
		this.id_usuario = id_usuario;
		this.id_producto = id_producto;
		this.favorito = favorito;

	}
	
	//Getters y Setters
	public int getId_usuario() {
		return id_usuario;
		
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
		
	}

	public int getId_producto() {
		return id_producto;
		
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
		
	}

	public boolean isFavorito() {
		return favorito;
		
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
		
	}

	@Override
	public String toString() {
		return "Favorito [id_usuario=" + id_usuario + ", id_producto=" + id_producto + ", favorito=" + favorito + "]";
		
	}
	

}
