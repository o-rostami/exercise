package com.example.exercise.model.user.dao;

import com.example.exercise.model.user.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UesrRepository extends CrudRepository<User, Long> {}