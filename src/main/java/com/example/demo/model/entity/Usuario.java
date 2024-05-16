package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;

	@Column
	private String nombre;
	private String contrasena;
	private String email;
	private int monedas;
	private boolean activo;

	@OneToMany(mappedBy = "id_usuario", fetch = FetchType.EAGER)
	private List<Hilo> hilos;

	@OneToMany(mappedBy = "id_usuario", fetch = FetchType.EAGER)
	private List<Respuesta> respuestas;

	public Usuario() {

	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Hilo> getHilos() {
		return hilos;
	}

	public void setHilos(List<Hilo> hilos) {
		this.hilos = hilos;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Usuario(long id_usuario, String nombre, String contrasena, String email, int monedas, boolean activo,
			List<Hilo> hilos, List<Respuesta> respuestas) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.monedas = monedas;
		this.activo = activo;
		this.hilos = hilos;
		this.respuestas = respuestas;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", contrasena=" + contrasena + ", email="
				+ email + ", monedas=" + monedas + ", activo=" + activo + ", hilos=" + hilos + ", respuestas="
				+ respuestas + "]";
	}

}
