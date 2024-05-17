package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.repository.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository UsuarioDAO;

	public UserEntity saveUser(UserEntity u) {
		if (u.getNombre() == null || u.getNombre().isEmpty()) {
			return null;
		}
		return UsuarioDAO.save(u);
	}

	public List<UserEntity> listUsers() {
		return UsuarioDAO.findAll();
	}

	public UserEntity searchUser(int id) {
		Optional<UserEntity> opU;
		opU = UsuarioDAO.findById(id);
		if (opU.isPresent()) {
			return opU.get();
		} else {
			return null;
		}
	}

	public void eliminarUsuario(UserEntity u) {
		UsuarioDAO.delete(u);
	}
}