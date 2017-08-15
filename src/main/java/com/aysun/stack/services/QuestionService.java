package com.aysun.stack.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aysun.stack.models.Question;
import com.aysun.stack.repositories.QuestionRepo;


@Service
public class QuestionService {

	private QuestionRepo questionRepo;
	
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public void createQuestion(Question question) {
		questionRepo.save(question);
	}
	
	public List<Question> pullQuestions(){
		return (List<Question>) questionRepo.findAll();
	}
	
	public Question pullOneQuestion(Long id) {
		return questionRepo.findOne(id);
	}
	
	public void updateQuestion(Question question) {
		questionRepo.save(question);
	}
	
}