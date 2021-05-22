package com.blog.demoblog.repository;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface Blogbusqueda {


    int getId();
    String getTitulo();
    String getCategoria();
    String getImagen();
    @JsonFormat(pattern="yyyy-MM-dd")
    Date getFechaCreacion();
}
