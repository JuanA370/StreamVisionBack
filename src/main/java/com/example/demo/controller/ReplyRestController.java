package com.example.demo.controller;

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

import com.example.demo.model.entities.Reply;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.service.AnswersServices;

@RestController
public class ReplyRestController {
	@Autowired
	private AnswersServices gr;
	
	@PostMapping(path = "respuesta", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reply> altaRespuesta(@RequestBody Reply r) {
		try {
			
			r = gr.saveAns(r);
			if (r != null)
				return new ResponseEntity<Reply>(r, HttpStatus.CREATED);
			else
				return new ResponseEntity<Reply>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Reply>(r, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "respuesta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reply>> listarRespuesta(@PathVariable long id_usuario) {
		List<Reply> listaRespuestas = gr.listAns(id_usuario);

		
		if(listaRespuestas != null) {
			return new ResponseEntity<List<Reply>>(listaRespuestas, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Reply>>(HttpStatus.NOT_FOUND);
		}
		

	}
	
	@GetMapping(path = "respuesta/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reply>> listarRespuestaAdmin(@PathVariable UserEntity usuario) {
		List<Reply> listaRespuestas = gr.listAns(usuario.getId_usuario());

		
		if(listaRespuestas != null) {
			return new ResponseEntity<List<Reply>>(listaRespuestas, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Reply>>(HttpStatus.NOT_FOUND);
		}
		

	}
	
	@DeleteMapping("/respuesta/{respuesta}")
	public ResponseEntity<Void> borrarRespuesta(@RequestBody Reply respuesta) {
	    try {
	        gr.deleteAns(respuesta);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	

}
