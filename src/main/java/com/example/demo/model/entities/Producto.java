package com.example.demo.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Producto {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProducto;

	@Column
	private String titulo;
	private String imagen;
	private String tipo;

}
