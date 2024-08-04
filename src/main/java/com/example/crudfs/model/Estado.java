package com.example.crudfs.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    @OneToMany(mappedBy = "estado")
    private List<Cliente> clientes;

    public Estado() {
    }


    public String geEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
