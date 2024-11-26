package com.java.blogs.controller;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.blogs.commands.CreateBlogCommand;
import com.java.blogs.entity.Blogs;
import com.java.blogs.repository.BlogRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/blogsite/user/blogs")
public class BlogController {
	@Autowired
	BlogRepository blogRepository;
	@Autowired 
	CommandGateway commandGateway;
	
	@Autowired QueryGateway queryGateway;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addBlog(@Valid @RequestBody Blogs blog, HttpServletRequest http) {
		
			Optional<Blogs> blog1 = blogRepository.findByBlogname(blog.getBlogname());
			if (!blog1.isPresent()) {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
				String timestamp1 = timestamp.toString();
				Blogs blogsModalNew = new Blogs();
				blogsModalNew.setBlogname(blog.getBlogname());
				blogsModalNew.setAuthorname(blog.getAuthorname());
				blogsModalNew.setArticle(blog.getArticle());
				blogsModalNew.setCategory(blog.getCategory());
				blogsModalNew.setTimestamp(timestamp1);
				blogsModalNew.setUserid(UUID.randomUUID().toString());

				CreateBlogCommand createBlogCommand = new CreateBlogCommand(
						UUID.randomUUID().toString(),
						blogsModalNew.getBlogname(),
						blogsModalNew.getCategory(),
						blogsModalNew.getAuthorname(),
						blogsModalNew.getArticle(),
						blogsModalNew.getTimestamp(),
						blogsModalNew.getUserid()
				);
				commandGateway.sendAndWait(createBlogCommand);
				//kafkaProducerService.addDelBlog(blog, AppConstants.TOPIC_ADD_BLOG);
				return new ResponseEntity<Object>("Blog added Success", HttpStatus.OK);
			}
			return ResponseEntity.badRequest().body("Blog Name already Exist");
	}
}
