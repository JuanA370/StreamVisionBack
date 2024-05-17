package com.example.demo.model.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Purchase;
import com.example.demo.model.entities.PurchasePk;
import com.example.demo.model.entities.Product;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, PurchasePk> {

	@Query("SELECT p FROM Producto p JOIN Compra c ON p.id_producto = c.idCompra.id_producto.id_producto WHERE c.idCompra.id_usuario.id_usuario = ?1")
	public List<Product> findShoppedProductsByUser(Long id_usuario);

	@Query("SELECT c FROM Compra c WHERE c.idCompra.id_usuario.id_usuario = ?1 AND c.idCompra.id_producto.id_producto = ?2")
	public Purchase findShoppingByUserANDProduct(Long usuario, Long producto);
	
}