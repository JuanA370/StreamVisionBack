package com.example.demo.model.persist;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Compra;
import com.example.demo.model.entity.CompraId;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;

@Repository
public interface CompraDAO extends JpaRepository<Compra,CompraId> {

	@Query("SELECT p FROM Producto p JOIN Compra c ON p.id_producto = c.id_producto WHERE c.id_usuario = :usuario")
	public List<Producto> findProductosCompradosPorUsuario(@Param("usuario") long idUsuario);
	
	@Query("SELECT c FROM Compra c JOIN c.idCompra.producto p WHERE c.idCompra.idUsuario = :usuario AND c.idCompra.idProducto = :producto")
	public Compra findCompraPorUsuarioYProducto(@Param("usuario") Long usuario, @Param("producto") Long producto);
}