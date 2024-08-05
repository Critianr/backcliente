package com.example.crudfs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "name")  // Tipo actúa como la clave primaria
    private String name;

    public Ciudad() {
    }

    public Ciudad(String name) {
        this.name = name;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }
}
