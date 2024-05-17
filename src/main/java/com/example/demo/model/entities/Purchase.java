package com.example.demo.model.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="purchases")
public class Purchase {
	
	@EmbeddedId
	private PurchasePk purcharsePk;

	@Column
	private Date purchaseDate;

	@ManyToOne
	@MapsId("userId")
	private UserEntity user;

	@ManyToOne
	@MapsId("productId")
	private Product product;
	
}
