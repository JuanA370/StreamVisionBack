package com.example.demo.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Compra {
	//Variables
	@ManyToMany
	@PrimaryKeyJoinColumn
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Usuario id_usuario;
	private Producto id_producto;

	@Column
	private Date fecha;
	
	//Constructores
	public Compra() {

	}

	public Compra(Usuario id_usuario, Producto id_producto, Date fecha) {
		this.id_usuario = id_usuario;
		this.id_producto = id_producto;
		this.fecha = fecha;

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

	public Date getFecha() {
		return fecha;
		
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
		
	}

	@Override
	public String toString() {
		return "Compra [id_usuario=" + id_usuario + ", id_producto=" + id_producto + ", fecha=" + fecha + "]";
		
	}
	
	
}
