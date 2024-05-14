package com.example.demo.model.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Usuario;
import com.example.demo.model.persist.UsuarioDAO;

@Service
public class GestorUsuario {

	@Autowired
	private UsuarioDAO UsuarioDAO;

	public Usuario crearActualizarUsuario(Usuario u) {
		if (u.getNombre() == null || u.getNombre().isEmpty()) {
			return null;

		}

		return UsuarioDAO.save(u);
		
	}

	public List<Usuario> listarUsuarios() {
		return UsuarioDAO.findAll();

	}

	public Usuario buscarUsuario(int id) {
		Optional<Usuario> opU;
		opU = UsuarioDAO.findById(id);

		if (opU.isPresent()) {
			return opU.get();

		} else {
			return null;

		}

	}
	
	public void eliminarUsuario(Usuario u) {
		UsuarioDAO.delete(u);

	}

}
