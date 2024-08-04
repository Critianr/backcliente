package com.example.crudfs.model;
import jakarta.persistence.*;
import com.example.crudfs.model.Ocupacion;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    // Llave primaria
    private String numero_documento;
    private String nombre;
    private String apellidos;
    private String fecha_nacimiento;
    private String ciudad;
    private String correo_electronico;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "ocupacion", referencedColumnName = "tipo")// Columna que referencia a Ocupacion    private Ocupacion ocupacion;
    private Ocupacion ocupacion;
    private String estado;
    // Constructor vacío (necesario para JPA)
    public Cliente() {
    }

    // Constructor con parámetros (opcional)
        public Cliente(String numero_documento, String nombre, String apellidos, String fecha_nacimiento, String ciudad, String correo_electronico, String telefono, Ocupacion ocupacion, String estado) {
        this.numero_documento = numero_documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.ciudad = ciudad;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
            //private Ocupacion ocupacion;

        }

    // Métodos getter y setter
    public String getNumeroDocumento() {
        return numero_documento;
    }

    public void setNumeroDocumento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreoElectronico() {
        return correo_electronico;
    }

    public void setCorreoElectronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}