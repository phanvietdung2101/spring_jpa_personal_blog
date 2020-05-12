package com.yyy.service;

import com.yyy.model.Blog;
import com.yyy.model.BlogType;
import com.yyy.repository.BlogRepository;
import com.yyy.repository.BlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    BlogTypeRepository blogTypeRepository;

    @Override
    public List<Blog> findAll() {
       return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        Optional<Blog> optionalBlog = blogRepository.findById(id);
        if(optionalBlog.isPresent()){
            return optionalBlog.get();
        }
        throw new RuntimeException("Khong ton tai");
    }

    @Override
    public void save(Blog model) {
        blogRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<BlogType> findAllBlogType() {
        return ( List<BlogType> ) blogTypeRepository.findAll();
    }

    @Override
    public List<Blog> findAllBlogByBlogType_Id(long id) {
        return blogRepository.findBlogsByBlogType_Id(id);
    }
}
