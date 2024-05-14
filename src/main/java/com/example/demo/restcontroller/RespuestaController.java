package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.business.GestorRespuesta;
import com.example.demo.model.entity.Respuesta;
import com.example.demo.model.entity.Usuario;

@RestController
public class RespuestaController {
	@Autowired
	private GestorRespuesta gr;
	
	@PostMapping(path = "respuesta", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Respuesta> altaRespuesta(@RequestBody Respuesta r) {
		try {
			
			r = gr.crearRespuesta(r);
			if (r != null)
				return new ResponseEntity<Respuesta>(r, HttpStatus.CREATED);
			else
				return new ResponseEntity<Respuesta>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Respuesta>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "respuesta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Respuesta>> listarRespuesta(@PathVariable long id_usuario) {
		List<Respuesta> listaRespuestas = gr.listarRespuestasUsuario(id_usuario);

		
		if(listaRespuestas != null) {
			return new ResponseEntity<List<Respuesta>>(listaRespuestas, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Respuesta>>(HttpStatus.NOT_FOUND);
		}
		

	}
	
	@GetMapping(path = "respuesta/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Respuesta>> listarRespuestaAdmin(@PathVariable Usuario usuario) {
		List<Respuesta> listaRespuestas = gr.listarRespuestasUsuario(usuario.getId_usuario());

		
		if(listaRespuestas != null) {
			return new ResponseEntity<List<Respuesta>>(listaRespuestas, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Respuesta>>(HttpStatus.NOT_FOUND);
		}
		

	}
	
	@DeleteMapping("/respuesta/{respuesta}")
	public ResponseEntity<Void> borrarRespuesta(@RequestBody Respuesta respuesta) {
	    try {
	        gr.eliminarRespuesta(respuesta);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	

}
