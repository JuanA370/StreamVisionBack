package com.example.demo.model.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="replies")
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	//@MapsId("threadId")
	@ManyToOne
	private MyThread thread;	
	
	//@MapsId("productId")
	@ManyToOne
	private Product product;	
	
	@Column
	private Date replyDate;
	private String content;

}