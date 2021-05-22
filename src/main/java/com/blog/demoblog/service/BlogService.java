package com.blog.demoblog.service;

import com.blog.demoblog.entity.Blog;
import com.blog.demoblog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;


    public List<Blog> listar(){
        return blogRepository.findAll();
    }
    public void insertar(Blog blog){

        blogRepository.save(blog);

    }

    public Iterable<Blog> findByTitulo(String titulo){

        return blogRepository.findByTitulo(titulo);
    }

    public Iterable<Blog> findByCategoria(String categoria){

        return blogRepository.findByCategoria(categoria);
    }



}
