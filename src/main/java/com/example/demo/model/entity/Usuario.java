package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;

	@Column
	private String nombre;
	private String contrasena;
	private String email;
	private int monedas;
	private boolean activo;
	
	//Constructores
	public Usuario() {

	}

	public Usuario(int id_usuario, String nombre, String contrasena, String email, int monedas, boolean activo) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.monedas = monedas;
		this.activo = activo;

	}
	
	//Getters y Setters
	public int getId_usuario() {
		return id_usuario;
		
	}

	public void setId_usuario(int id_usuario) {
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

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", contrasena=" + contrasena + ", email="
				+ email + ", monedas=" + monedas + ", activo=" + activo + "]";
		
	}
	
	
	

}
