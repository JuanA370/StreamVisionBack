package com.example.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="favorites")
public class Favorite {

	@EmbeddedId
	private FavoritePk favoritePk;

	private boolean isFavorite;
	
	@ManyToOne
	@MapsId("userId")
	@JsonIgnore
	private UserEntity user;
	
	@ManyToOne
	@MapsId("productId")
	@JsonIgnore
	private Product product;
}