package com.example.demo.model.business;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Respuesta;
import com.example.demo.model.persist.RespuestaDAO;

@Service
public class GestorRespuesta {

	@Autowired
	
	private RespuestaDAO respuestaDAO;
	
	
	public Respuesta crearRespuesta(Respuesta r) {
	    return respuestaDAO.save(r); 
	}

	
	public void eliminarRespuesta(Respuesta r) {
	    respuestaDAO.delete(r);;
	}


	public List<Respuesta> listarRespuestasUsuario(Long id_usuario) {
	        return respuestaDAO.findByUsuarioId(id_usuario);
	}
	 


	public List<Respuesta> buscarRespuesta(Long id_usuario, Long id_hilo, Long id_producto) {
	    List<Respuesta> respuestas = respuestaDAO.findByUsuarioAndHiloAndProducto(id_usuario, id_hilo, id_producto);
	    return respuestas;
	}




}
