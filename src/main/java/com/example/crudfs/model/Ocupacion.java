package com.example.crudfs.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
@Entity
@Table(name = "ocupacion")
public class Ocupacion {

    @Id
    @Column(name = "tipo")  // Tipo actúa como la clave primaria
    private String tipo;



    // Constructor sin argumentos
    public Ocupacion() {}

    // Constructor con parámetros
    public Ocupacion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Ocupacion{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
