package com.example.demo.model.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_respuesta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hilo", nullable = false)
	private Hilo id_hilo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario id_usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto id_producto;


	@Column
	private Date fecha_respuesta;
	private String comentario;


	//Constructores
	public Respuesta() {

	}


	public Respuesta(long id_respuesta, Hilo id_hilo, Usuario id_usuario, Producto id_producto, Date fecha_respuesta,
			String comentario) {
		this.id_respuesta = id_respuesta;
		this.id_hilo = id_hilo;
		this.id_usuario = id_usuario;
		this.id_producto = id_producto;
		this.fecha_respuesta = fecha_respuesta;
		this.comentario = comentario;
	}


	public long getId_respuesta() {
		return id_respuesta;
	}


	public void setId_respuesta(long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}


	public Hilo getId_hilo() {
		return id_hilo;
	}


	public void setId_hilo(Hilo id_hilo) {
		this.id_hilo = id_hilo;
	}


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


	public Date getFecha_respuesta() {
		return fecha_respuesta;
	}


	public void setFecha_respuesta(Date fecha_respuesta) {
		this.fecha_respuesta = fecha_respuesta;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	@Override
	public String toString() {
		return "Respuesta [id_respuesta=" + id_respuesta + ", id_hilo=" + id_hilo + ", id_usuario=" + id_usuario
				+ ", id_producto=" + id_producto + ", fecha_respuesta=" + fecha_respuesta + ", comentario=" + comentario
				+ "]";
	}


	
	

}
