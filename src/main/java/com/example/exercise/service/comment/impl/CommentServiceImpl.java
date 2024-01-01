package com.example.exercise.service.comment.impl;

import com.example.exercise.model.comment.dao.CommentRepository;
import com.example.exercise.model.product.Product;
import com.example.exercise.service.comment.CommentService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {


	private final CommentRepository commentRepository;

	// Save operation

	@Override
	public Product saveComment(Product product) {
		return null;
	}
}