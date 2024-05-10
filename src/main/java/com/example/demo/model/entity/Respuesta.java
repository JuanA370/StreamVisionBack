package com.example.demo.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Respuesta {
	//Variables
	@Id
	private int id_hilo;

	@OneToOne
	@PrimaryKeyJoinColumn
	private int id_usuario;
	

	@Column
	private Date fecha_respuesta;
	private String comentario;


	//Constructores
	public Respuesta() {

	}

	public Respuesta(int id_usuario, int id_hilo, Date fecha_respuesta, String comentario) {
		this.id_usuario = id_usuario;
		this.id_hilo = id_hilo;
		this.fecha_respuesta = fecha_respuesta;
		this.comentario = comentario;

	}

	//Getters y Setters
	public int getId_hilo() {
		return id_hilo;
		
	}

	public void setId_hilo(int id_hilo) {
		this.id_hilo = id_hilo;
		
	}

	public int getId_usuario() {
		return id_usuario;
		
	}

	public void setId_usuario(int id_usuario) {
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
		return "Respuesta [id_hilo=" + id_hilo + ", id_usuario=" + id_usuario + ", fecha_respuesta=" + fecha_respuesta
				+ ", comentario=" + comentario + "]";
	}
	
	
	

}
