package com.aysun.stack.services;

import org.springframework.stereotype.Service;

import com.aysun.stack.models.Answer;
import com.aysun.stack.repositories.AnswerRepo;

@Service
public class AnswersService {
	
	private AnswerRepo answerRepo;
	
	public AnswersService(AnswerRepo answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	public void createAnswer(Answer answer) {
		answerRepo.save(answer);
	}

}