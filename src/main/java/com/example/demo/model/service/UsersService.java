package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Usuario;
import com.example.demo.model.persist.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository UsuarioDAO;

	public Usuario saveUser(Usuario u) {
		if (u.getNombre() == null || u.getNombre().isEmpty()) {
			return null;
		}
		return UsuarioDAO.save(u);
	}

	public List<Usuario> listUsers() {
		return UsuarioDAO.findAll();
	}

	public Usuario searchUser(int id) {
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