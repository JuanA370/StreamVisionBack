package com.example.demo.model.persist;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Compra;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;

@Repository
public interface CompraDAO extends JpaRepository<Compra,Integer> {
	//@Query("SELECT * from Compra c WHERE id_usuario = ?1 AND id_producto = ?2")
	//public List<Producto> findCompras(@Param("id_usuario") Usuario usuario, @Param("id_producto") Producto producto);

	@Query("SELECT * FROM Producto JOIN Compra ON Producto.id_producto = Compra.id_producto WHERE Compra.id_usuario = :usuario")
	public List<Producto> findCompraByUser(@Param("usuario") long l);

	@Query("SELECT * FROM Producto p JOIN Compra c ON p.id_producto = c.id_producto WHERE c.id_usuario = :usuario AND c.id_producto = :producto")
	public Compra findCompraById(@Param("usuario") Usuario usuario, @Param("producto") Producto producto);
	
	@Query("SELECT * FROM Producto p JOIN Compra c ON p.id_producto = c.id_producto WHERE c.id_usuario = :usuario AND c.id_producto = :producto")
	public Optional<Producto> findProductoComprado(@Param("usuario") Usuario usuario, @Param("producto") Producto producto);
}