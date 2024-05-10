package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	//Variables
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;

	@Column
	private String titulo;
	private String imagen;
	private String tipo;

	//Constructores
	public Producto() {

	}

	public Producto(int id_producto, String titulo, String imagen, String tipo) {
		this.id_producto = id_producto;
		this.titulo = titulo;
		this.imagen = imagen;
		this.tipo =  tipo;

	}
	
	//Getters y Setters
	public int getId_producto() {
		return id_producto;
		
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
		
	}

	public String getTitulo() {
		return titulo;
		
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		
	}

	public String getImagen() {
		return imagen;
		
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
		
	}

	public String getTipo() {
		return tipo;
		
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
		
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", titulo=" + titulo + ", imagen=" + imagen + ", tipo=" + tipo
				+ "]";
		
	}
	
	
	
}
