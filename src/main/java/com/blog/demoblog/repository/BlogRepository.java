package com.blog.demoblog.repository;

import com.blog.demoblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("SELECT p FROM Blog p WHERE (:titulo is null or p.titulo = :titulo) and (:categoria is null" + " or p.categoria = :categoria) ")
    List<Blogbusqueda> tituloycategoria(@Param("titulo") String titulo, @Param("categoria") String categoria);

    public Iterable<Blog> findByTitulo(String titulo);

    public Iterable<Blog> findByCategoria(String categoria);
}
