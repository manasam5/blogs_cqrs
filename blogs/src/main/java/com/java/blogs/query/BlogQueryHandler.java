package com.java.blogs.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.blogs.entity.Blogs;
import com.java.blogs.repository.BlogRepository;

public class BlogQueryHandler {
	@Autowired 
	BlogRepository blogRepository;
	List<Blogs> blogs = new ArrayList<>();
	
	@QueryHandler
	public List<Blogs>  handle(GetAllBlogsQuery getAllBlogsQuery){
		return blogRepository.findAll();
	}
}
