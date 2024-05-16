package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RoleEntity {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ERole name;

	public RoleEntity(Long id, ERole name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	public RoleEntity() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", name=" + name + "]";
	}
	
	
}
