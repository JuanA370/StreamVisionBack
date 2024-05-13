package com.example.demo.model.persist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Favorito;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;

@Repository
public interface FavoritoDAO extends JpaRepository<Favorito, Integer> {

	@Query("SELECT * FROM Producto p WHERE f.id_usuario = :usuario AND f.id_producto = :producto AND f.favorito = true")
	public Favorito findFavById(@Param("usuario") Usuario usuario, @Param("producto") Producto producto);

	@Query("SELECT * FROM Producto JOIN Favorito ON Producto.id_producto = Favorito.id_producto WHERE Favorito.favorito = true AND Favorito.id_usuario = :usuario")
	public List<Producto> findFavByUser(@Param("usuario") long l);
}
