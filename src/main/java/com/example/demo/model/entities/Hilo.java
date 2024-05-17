package com.example.demo.model.entities;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Hilo {

	@EmbeddedId
	private HiloId idHilo;
	
	@Column
	private String titulo;
	private String contenido;
	private Date fecha_creacion;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario id_usuario;

	//Constructores
	public Hilo() {

	}

	public HiloId getIdHilo() {
		return idHilo;
	}

	public void setIdHilo(HiloId idHilo) {
		this.idHilo = idHilo;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Hilo(HiloId idHilo, String titulo, String contenido, Date fecha_creacion, Usuario id_usuario) {
		super();
		this.idHilo = idHilo;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha_creacion = fecha_creacion;
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString() {
		return "Hilo [idHilo=" + idHilo + ", titulo=" + titulo + ", contenido=" + contenido + ", fecha_creacion="
				+ fecha_creacion + ", id_usuario=" + id_usuario + "]";
	}

	
	
}
