package com.example.exercise.model.comment.dao;

import com.example.exercise.model.comment.Comment;
import com.example.exercise.model.product.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {}