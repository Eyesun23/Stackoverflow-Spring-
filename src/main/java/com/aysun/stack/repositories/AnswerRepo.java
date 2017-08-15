package com.aysun.stack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.stack.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long> {

}