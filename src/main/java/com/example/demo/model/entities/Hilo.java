package com.example.demo.model.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Hilo {

	@EmbeddedId
	@MapsId("idHilo")
	private HiloPk idHilo;

	@Column
	private String titulo;
	private String contenido;
	private Date fechaCreacion;
	@ManyToOne
	@MapsId("idProducto")
	private Usuario usuario;

}
