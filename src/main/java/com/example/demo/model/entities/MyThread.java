package com.example.demo.model.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name="threads")
public class MyThread {

	@EmbeddedId
	private MyThreadPk threadPk;

	@Column
	private String title;
	private String content;
	private Date creationDate;
	
	@ManyToOne
	@MapsId("productId")
	private Product product;
	
	@ManyToOne
	private UserEntity user;

}
