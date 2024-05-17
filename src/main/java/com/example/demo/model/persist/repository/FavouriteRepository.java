package com.example.demo.model.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.FavoritePk;
import com.example.demo.model.entities.Product;

@Repository
public interface FavouriteRepository extends JpaRepository<Favorite, FavoritePk> {

	@Query("SELECT f FROM Favorito f WHERE f.idFavorito.id_usuario.id_usuario = ?1 AND f.idFavorito.id_producto.id_producto = ?2")
	public Favorite findFavById(Long usuario, Long producto);

	@Query("SELECT p FROM Producto p JOIN Favorito f ON p.id_producto = f.idFavorito.id_producto.id_producto WHERE f.favorito = true AND f.idFavorito.id_usuario.id_usuario = ?1")
	public List<Product> findFavProductByUser(Long id_usuario);
}
