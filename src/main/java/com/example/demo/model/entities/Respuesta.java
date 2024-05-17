package com.example.demo.model.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Respuesta {

	@EmbeddedId
	private RespuestaPk respuestaPk;

	@ManyToOne
	private Usuario usuario;
	
	@MapsId("idHilo")
	@ManyToOne
	private Hilo hilo;	
	
	@Column
	private Date fechaRespuesta;
	private String comentario;

}
