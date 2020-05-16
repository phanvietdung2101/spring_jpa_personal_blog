package com.yyy.repository;

import com.yyy.model.Blog;
import com.yyy.model.BlogType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    List<Blog> findBlogsByBlogType_Id(long id);
    List<Blog> findBlogsByTitleContaining(String regex);
}
