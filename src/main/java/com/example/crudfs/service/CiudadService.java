package com.example.crudfs.service;

import com.example.crudfs.model.Ciudad;
import com.example.crudfs.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public Ciudad saveCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public List<Ciudad> getAllCiudades() {
        return ciudadRepository.findAll();
    }

    public Ciudad getCiudadById(String nombre) {
        return ciudadRepository.findById(nombre).orElse(null);
    }

    public void deleteCiudad(String nombre) {
        ciudadRepository.deleteById(nombre);
    }
}
