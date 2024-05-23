package com.example.demo.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.ERole;
import com.example.demo.model.entities.RoleEntity;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.repository.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository UsuarioDAO;

	public UserEntity saveUser(UserDto u) {
		RoleEntity role = RoleEntity.builder()
				.name(ERole.valueOf("USER"))
				.build();
		Set<RoleEntity> roles = new HashSet<>();
		roles.add(role);
		UserEntity user=  UserEntity.builder()
				.username(u.username())
				.password(u.password())
				.email(u.email())
				.coins(100)
				.active(true)
				.roles(roles)
				.build();
		return UsuarioDAO.save(user);
	}

	public List<UserEntity> listUsers() {
		return UsuarioDAO.findAll();
	}

	public UserEntity searchUser(Long id) {
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