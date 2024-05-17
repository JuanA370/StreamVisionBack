package com.example.demo.model.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Compra {
	@EmbeddedId
	private CompraPk CompraPk;

	@Column
	private Date fecha;

	@ManyToOne
	@MapsId("idUsuario")
	private Usuario usuario;

	@ManyToOne
	@MapsId("idProducto")
	private Producto producto;
}
