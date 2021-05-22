package com.blog.demoblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URL;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@SQLDelete(sql = "UPDATE blog SET deleted=true WHERE id = ?")
@Where(clause = "deleted = false")
public class Blog {

    @Id
    @GeneratedValue
    private int Id;
     @Column
    private String titulo;
     @Column
    private String contenido;
     @Column
    private URL imagen;
     @Column
    private String categoria;
     @Column
     @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaCreacion;
     @Column
    private  int Id_Creador;
     @Column
    private boolean deleted;



}
