package com.example.demo.model.persist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Favorito;
import com.example.demo.model.entity.FavoritoId;
import com.example.demo.model.entity.Producto;

@Repository
public interface FavoritoDAO extends JpaRepository<Favorito, FavoritoId> {

	@Query("SELECT f FROM Favorito f WHERE f.idFavorito.id_usuario.id_usuario = ?1 AND f.idFavorito.id_producto.id_producto = ?2")
	public Favorito findFavById( Long usuario, Long producto);

	@Query("SELECT p FROM Producto p JOIN Favorito f ON p.id_producto = f.idFavorito.id_producto.id_producto WHERE f.favorito = true AND f.idFavorito.id_usuario.id_usuario = ?1")
	public List<Producto> findFavByUser(Long id_usuario);
}
