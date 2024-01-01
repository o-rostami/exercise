package com.example.exercise.model.comment;

import java.util.Date;

import com.example.exercise.model.Status;
import com.example.exercise.model.product.Product;
import com.example.exercise.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.springframework.data.annotation.Version;

@Entity(name = "tbl_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	private String title;

	private String comment;

	private Status status;

	@Version
	private Long version;

	@CreationTimestamp
	private Date createdAt;

	@UpdateTimestamp
	private Date updatedAt;

}
