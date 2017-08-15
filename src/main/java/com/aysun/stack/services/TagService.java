package com.aysun.stack.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aysun.stack.models.Tag;
import com.aysun.stack.repositories.TagRepo;


@Service
public class TagService {
	
	private TagRepo tagRepo;
	
	public TagService(TagRepo tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public List<Tag> findAllTags(){
		return (List<Tag>) tagRepo.findAll();
	}
	
	public Tag findTag(String name) {
		return tagRepo.findOneByName(name);
	}
	
	public void createTag(Tag tag) {
		tagRepo.save(tag);
	}

}