package com.example.demo.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class ThreadPk implements Serializable {

	@Column(name="thread_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long threadId;
	
	@Column(name = "product_id")
	private long productId;
	
}