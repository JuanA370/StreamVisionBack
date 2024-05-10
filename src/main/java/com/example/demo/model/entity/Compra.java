package com.example.demo.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compra {
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	private int id_producto;

	@Column
	private Date fecha;
	
	//Constructores
	public Compra() {

	}

	public Compra(int id_usuario, int id_producto, Date fecha) {
		this.id_usuario = id_usuario;
		this.id_producto = id_producto;
		this.fecha = fecha;

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
