package com.example.demo.model.entity;

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

	@EmbeddedId
	private RespuestaId idRespuesta;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario id_usuario;
	
	@Column
	private Date fecha_respuesta;
	private String comentario;
	//Constructores
	public Respuesta() {

	}
	public Respuesta(RespuestaId idRespuesta, Usuario id_usuario, Date fecha_respuesta, String comentario) {
		super();
		this.idRespuesta = idRespuesta;
		this.id_usuario = id_usuario;
		this.fecha_respuesta = fecha_respuesta;
		this.comentario = comentario;
	}
	public RespuestaId getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(RespuestaId idRespuesta) {
		this.idRespuesta = idRespuesta;
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
		return "Respuesta [idRespuesta=" + idRespuesta + ", id_usuario=" + id_usuario + ", fecha_respuesta="
				+ fecha_respuesta + ", comentario=" + comentario + "]";
	}

	

}
