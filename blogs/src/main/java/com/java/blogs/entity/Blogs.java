package com.java.blogs.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(	name = "blogs")
@Getter
@Setter
public class Blogs {

	@Id
	@NotNull(message = "Blog Name cannot be blank#######")
	@Size(min=10, message="Minimum 10 Characters")
	private String blogname;
	private String userid;
	@NotNull(message = "Category cannot be blank#######")
	private String category;
	@NotNull(message = "Author Name cannot be blank#######")
	@Size(min=3, message="Minimum 3 Characters")
	private String authorname;
	@NotNull(message = "Article cannot be blank#######")
	@Size(min=10, message="Minimum 10 Characters")
	private String article;
	private String timestamp;
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
