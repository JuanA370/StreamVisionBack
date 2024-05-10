package com.example.demo.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Hilo {
	//Variables
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_hilo;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private int id_producto;

	@Column
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private int id_usuario;

	@Column
	private Date fecha_creacion;
	private String titulo;
	private String contenido;


	//Constructores
	public Hilo() {

	}

	public Hilo(int id_hilo, int id_producto, int id_usuario, Date fecha_creacion, String titulo, String contenido) {
		this.id_hilo = id_hilo;
		this.id_producto = id_producto;
		this.id_usuario = id_usuario;
		this.fecha_creacion = fecha_creacion;
		this.titulo = titulo;
		this.contenido = contenido;

	}
	
	//Getters y Setters
	public int getId_hilo() {
		return id_hilo;
		
	}

	public void setId_hilo(int id_hilo) {
		this.id_hilo = id_hilo;
		
	}

	public int getId_producto() {
		return id_producto;
		
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
		
	}

	public int getId_usuario() {
		return id_usuario;
		
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
		
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
		
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
		
	}

	public String getTitulo() {
		return titulo;
		
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		
	}

	public String getContenido() {
		return contenido;
		
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
		
	}

	@Override
	public String toString() {
		return "Hilo [id_hilo=" + id_hilo + ", id_producto=" + id_producto + ", id_usuario=" + id_usuario
				+ ", fecha_creacion=" + fecha_creacion + ", titulo=" + titulo + ", contenido=" + contenido + "]";
		
	}
	
	
	
}
