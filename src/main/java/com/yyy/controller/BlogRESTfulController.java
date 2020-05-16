package com.yyy.controller;

import com.yyy.model.Blog;
import com.yyy.model.BlogType;
import com.yyy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class BlogRESTfulController {
    @Autowired
    BlogService blogService;


    @GetMapping("/api/blogTypes")
    public ResponseEntity<List<BlogType>> listAllBlogType(){
        List<BlogType> blogTypes = blogService.findAllBlogType();
        if(blogTypes.isEmpty())
            return new ResponseEntity<List<BlogType>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<BlogType>>(blogTypes,HttpStatus.OK);
    }

    @GetMapping("/api/blogs")
    public ResponseEntity<List<Blog>> listAllBlog(){
        List<Blog> blogs = blogService.findAll();
        if(blogs.isEmpty())
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }

    @GetMapping("/api/blogs/{id}")
    public ResponseEntity<List<Blog>> listAllBlogByBlogType(@PathVariable("id") Long id){
        List<Blog> blogs = blogService.findAllBlogByBlogType_Id(id);
        if(blogs.isEmpty())
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
    }
    
    @GetMapping("/api/find/{keyword}")
    public List<Blog> findBlogByName(@PathVariable String keyword){
        List<Blog> blogs = blogService.findBlogsByBlogTitle(keyword);
        return blogs;
    }

//    @GetMapping("/api/find/{keyword}")
//    public ResponseEntity<List<Blog>> findBlogByName(@PathVariable String keyword){
//        List<Blog> blogIterator = blogService.findBlogsByBlogTitle(keyword);
//        return new ResponseEntity<>(blogIterator, HttpStatus.OK);
//    }

}
