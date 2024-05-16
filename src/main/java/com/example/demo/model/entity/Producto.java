package com.example.demo.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_producto;

	@Column
	private String titulo;
	private String imagen;
	private String tipo;

	public Producto() {

	}

	public Producto(long id_producto, String titulo, String imagen, String tipo) {
		super();
		this.id_producto = id_producto;
		this.titulo = titulo;
		this.imagen = imagen;
		this.tipo = tipo;
	}

	public long getId_producto() {
		return id_producto;
	}

	public void setId_producto(long id_producto) {
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
