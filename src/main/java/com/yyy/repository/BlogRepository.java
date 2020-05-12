package com.yyy.repository;

import com.yyy.model.Blog;
import com.yyy.model.BlogType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog,Long> {
    List<Blog> findBlogsByBlogType_Id(long id);
}
