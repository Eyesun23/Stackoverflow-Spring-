package com.aysun.stack.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aysun.stack.models.Answer;
import com.aysun.stack.models.Question;
import com.aysun.stack.models.Tag;
import com.aysun.stack.services.AnswersService;
import com.aysun.stack.services.QuestionService;
import com.aysun.stack.services.TagService;


@Controller
public class Control {
	
	private final QuestionService questionService;
	private final AnswersService answersService;
	private final TagService tagService;
	
	public Control(QuestionService questionService, AnswersService answersService, TagService tagService) {
		this.questionService = questionService;
		this.answersService = answersService;
		this.tagService = tagService;
	}
	
	private boolean tagCheck(List<Tag> tagList, String tagName){
		for(Tag item : tagList) {
			if(item.getName().equals(tagName.trim().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = questionService.pullQuestions();
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQ.jsp";
	}
	
	@RequestMapping("/questions/create")
	public String createQuestion(@RequestParam("content") String content, @RequestParam("tags") String tagStr) {
			Question question = new Question(content);
			List<Tag> questionTags = new ArrayList<Tag>();
			List<Tag> allTags = tagService.findAllTags();
			List<String> tagList = Arrays.asList(tagStr.split(","));
			for(String item : tagList) {
				if(tagCheck(allTags, item)) {
					Tag foundTag = tagService.findTag(item.trim().toLowerCase());
					questionTags.add(foundTag);
				}else {
					Tag newTag = new Tag(item.trim().toLowerCase());
					tagService.createTag(newTag);
					questionTags.add(newTag);
				}
			}
			question.setTags(questionTags);
			questionService.createQuestion(question);
			return "redirect:/";
	}
	
	@RequestMapping("/questions/{question_id}")
	public String questionDetail(@PathVariable("question_id") Long question_id, Model model, @ModelAttribute("newAnswer") Answer newAnswer) {
		Question question = questionService.pullOneQuestion(question_id);
		model.addAttribute("question", question);
		return "details.jsp";
	}
	
	@PostMapping("/questions/{question_id}/add_answer")
	public String createAnswer(@PathVariable("question_id") Long question_id, @ModelAttribute("newAnswer") Answer newAnswer, BindingResult result) {
		if(result.hasErrors()) {
			return "details.jsp";
		}else {
			Question question = questionService.pullOneQuestion(question_id);
			newAnswer.setQuestion(question);
			List<Answer> answers = question.getAnswers();
			answers.add(newAnswer);
			question.setAnswers(answers);
			answersService.createAnswer(newAnswer);
			questionService.updateQuestion(question);
			return "redirect:/questions/" + question.getId();
		}
	}
}
