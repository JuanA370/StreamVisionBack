package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Favorito {
	//Variables
	@ManyToMany
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Usuario id_usuario;
	private Producto id_producto;

	@Column
	private boolean favorito;

	//Constructores
	public Favorito() {

	}

	public Favorito(Usuario id_usuario, Producto id_producto, boolean favorito) {
		this.id_usuario = id_usuario;
		this.id_producto = id_producto;
		this.favorito = favorito;

	}
	
	//Getters y Setters
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
