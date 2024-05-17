package com.example.demo.model.entities;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Respuesta {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_respuesta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hilo", nullable = false)
	private long id_hilo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private long id_usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", nullable = false)
	private long id_producto;


	@Column
	private Date fecha_respuesta;
	private String comentario;

	 */
	
	@EmbeddedId
	private RespuestaId id_respuesta;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario id_usuario;
	
	@Column
	private Date fecha_respuesta;
	private String comentario;
	//Constructores
	public Respuesta() {

	}
	public Respuesta(RespuestaId id_respuesta, Usuario id_usuario, Date fecha_respuesta, String comentario) {
		super();
		this.id_respuesta = id_respuesta;
		this.id_usuario = id_usuario;
		this.fecha_respuesta = fecha_respuesta;
		this.comentario = comentario;
	}
	public RespuestaId getIdRespuesta() {
		return id_respuesta;
	}
	public void setIdRespuesta(RespuestaId idRespuesta) {
		this.id_respuesta = idRespuesta;
	}
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
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
		return "Respuesta [idRespuesta=" + id_respuesta + ", id_usuario=" + id_usuario + ", fecha_respuesta="
				+ fecha_respuesta + ", comentario=" + comentario + "]";
	}

	

}
