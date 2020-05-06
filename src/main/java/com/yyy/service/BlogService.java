package com.yyy.service;

import com.yyy.model.Blog;
import com.yyy.model.BlogType;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog model);

    void remove(Long id);

    List<BlogType> findAllBlogType();
}
