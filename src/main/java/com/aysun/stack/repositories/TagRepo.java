package com.aysun.stack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.stack.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long>{

	public Tag findOneByName(String name);
	
}