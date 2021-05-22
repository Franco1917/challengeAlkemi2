package com.blog.demoblog.controller;


import com.blog.demoblog.entity.Blog;
import com.blog.demoblog.repository.BlogRepository;
import com.blog.demoblog.repository.Blogbusqueda;
import com.blog.demoblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/home")
public class Controller {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/home/landing")
    public String home(){
        return "hola esta funcionando vieja";
    }

    @GetMapping("/home/blog")
    public List<Blog> listar(){
        return blogService.listar();

    }

    @PostMapping("/home/blog")
    public String insetar(@RequestBody Blog blog){

        blogService.insertar(blog);

        return "insertado con exito";
    }
     @GetMapping("home/blog/")
    List<Blogbusqueda> posts(String titulo, String categoria) {

        return blogRepository.tituloycategoria(titulo, categoria);}

    @GetMapping("/home/blog/{titulo}")
    public Iterable<Blog> findbytitulo(@PathVariable(name="titulo") String titulo ){

        return blogService.findByTitulo(titulo);
    }



    @PutMapping("home/blog")
    public String modificar(@RequestBody  Blog blog){
       blogRepository.save(blog);
        return "modificado";
    }

    @PatchMapping("home/blog")
    public String modif(@RequestBody  Blog blog){
        if(blog.getId() == 0){
            return "no se encuentra ese id";

        }
        blogRepository.save(blog);
        return "modificado";
    }
    @DeleteMapping("/home/blog/{id}")
    public String eliminar(@PathVariable(name="id") int id){
        blogRepository.deleteById(id);
        return "eliminado";
    }
}
