package com.example.demo.model.persist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Compra;
import com.example.demo.model.entities.CompraId;
import com.example.demo.model.entities.Producto;

@Repository
public interface ShoppingRepository extends JpaRepository<Compra,CompraId> {

	@Query("SELECT p FROM Producto p JOIN Compra c ON p.id_producto = c.idCompra.id_producto.id_producto WHERE c.idCompra.id_usuario.id_usuario = ?1")
	public List<Producto> findProductosCompradosPorUsuario(Long id_usuario);
	
	@Query("SELECT c FROM Compra c WHERE c.idCompra.id_usuario.id_usuario = ?1 AND c.idCompra.id_producto.id_producto = ?2")
	public Compra findCompraPorUsuarioYProducto(Long usuario, Long producto);
}