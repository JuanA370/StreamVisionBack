package com.example.demo.model.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Favorito {

	@EmbeddedId
	private FavoritoPk favoritoPk;

	private boolean favorito;
}
