package com.example.exercise.model.purchase.dao;

import com.example.exercise.model.purchase.Purchase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchseRepository extends CrudRepository<Purchase, Long> {}