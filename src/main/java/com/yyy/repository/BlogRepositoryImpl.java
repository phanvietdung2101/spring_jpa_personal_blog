package com.yyy.repository;

import com.yyy.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepositoryImpl implements BlogRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> typedQuery = entityManager.createQuery("select b from Blog b",Blog.class);
        return typedQuery.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> typedQuery = entityManager.createQuery("select b from Blog b where b.id=:id",Blog.class);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Blog model) {
        if(model.getId() == null){
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if(blog != null){
            entityManager.remove(blog);
        }
    }
}
