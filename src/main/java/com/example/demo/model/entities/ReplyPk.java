package com.example.demo.model.entities;

import java.io.Serializable;

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
public class ReplyPk implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long replyId;
	
	private long threadId;
	
	private long productId;

}
