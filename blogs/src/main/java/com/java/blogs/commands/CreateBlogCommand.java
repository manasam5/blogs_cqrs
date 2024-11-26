package com.java.blogs.commands;

import java.sql.Timestamp;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBlogCommand {

	@TargetAggregateIdentifier
	private String blogId;
	private String blogname;
	private String userid;
	private String category;
	private String authorname;
	private String article;
	private String timestamp;
	
	public CreateBlogCommand(String blogId, String blogname, String category, String authorname,
			 String article, String timestamp, String userId) {
this.blogId = blogId;
this.blogname = blogname;
this.category = category;
this.authorname = authorname;
this.article = article;
this.timestamp = timestamp;
this.userid = userId;
}
}
