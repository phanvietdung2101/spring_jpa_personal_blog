package com.yyy.service;

import com.yyy.model.Blog;
import com.yyy.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
       return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog model) {
        blogRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
