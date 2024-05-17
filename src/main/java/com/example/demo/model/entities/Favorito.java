package com.example.demo.model.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Favorito {

	@EmbeddedId
	private FavoritoId idFavorito;
	
	private boolean favorito;
	//Constructores
	public Favorito() {

	}
	public Favorito(FavoritoId idFavorito, boolean favorito) {
		super();
		this.idFavorito = idFavorito;
		this.favorito = favorito;
	}
	public FavoritoId getIdFavorito() {
		return idFavorito;
	}
	public void setIdFavorito(FavoritoId idFavorito) {
		this.idFavorito = idFavorito;
	}
	public boolean isFavorito() {
		return favorito;
	}
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	@Override
	public String toString() {
		return "Favorito [idFavorito=" + idFavorito + ", favorito=" + favorito + "]";
	}

	
	

}
