package com.blog.demoblog.controller;

import com.blog.demoblog.entity.Blog;
import com.blog.demoblog.repository.BlogRepository;
import com.blog.demoblog.service.BlogService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.Instant;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogRepository blogRepository= Mockito.mock(BlogRepository.class);

    @Autowired
    Controller controller;

    @BeforeEach
    void setUp() {
        Blog mockblog = new Blog();
        mockblog.setCategoria("espectaculo");
        mockblog.setContenido("cloresdmpenfefaljlaefbfea");
        mockblog.setDeleted(false);
        mockblog.setId(4);
        mockblog.setTitulo("lorem");
        mockblog.setId_Creador(3);
        mockblog.setFechaCreacion(Date.from(Instant.now()));
        mockblog.setImagen(null);

        var lorem = Mockito.when(blogRepository.findByTitulo("lorem")).thenReturn(Collections.singleton(mockblog));

    }

    @AfterEach
    void tearDown() {
        System.out.println("despues de la prueba");
    }

    @Test
    void home() {

    }

    @Test
    void listar() {
    }

    @Test
    void findbytitulo() {
        Iterable<Blog> blogprueba;
        System.out.println("en la prueba");
        blogprueba= controller.findbytitulo("lorem");
        System.out.println(blogprueba);
    }
}