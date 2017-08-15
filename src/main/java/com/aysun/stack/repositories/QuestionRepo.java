package com.aysun.stack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.stack.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {

}