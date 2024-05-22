package com.example.demo.model.dto;

import java.util.Set;

import com.example.demo.model.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
	private String username;
	private String password;
	private String email;
}
