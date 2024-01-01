package com.example.exercise.model.vote.dao;

import com.example.exercise.model.vote.Vote;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {}