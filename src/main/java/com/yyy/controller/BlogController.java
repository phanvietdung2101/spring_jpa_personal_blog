package com.yyy.controller;


import com.yyy.model.Blog;
import com.yyy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/create-blog")
    public String showCreateForm(Model model){
        model.addAttribute("blogType",blogService.findAllBlogType());
        model.addAttribute("blog",new Blog());
        return "create-blog";
    }

    @PostMapping(value = "/create-blog")
    public String createBlog(@ModelAttribute("blog") Blog blog,Model model){
        blogService.save(blog);
        model.addAttribute("blog",new Blog());
        model.addAttribute("msg","New blog created successfully");
        return "create-blog";
    }

    @GetMapping(value = "/blogs")
    public String showBlogs(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs",blogs);
        return "blogs";
    }

    @GetMapping("/index")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken))
        {
            String currentUserName = authentication.getName();
            modelAndView.addObject("currentUserName",currentUserName);
        }
        return modelAndView;
    }
}
