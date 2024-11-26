package com.java.blogs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.blogs.entity.Blogs;

public interface BlogRepository extends JpaRepository<Blogs, Long>{
	Optional<Blogs> findByBlogname(String blogName);
}
