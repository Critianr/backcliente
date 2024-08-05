package com.example.crudfs.service;

import com.example.crudfs.model.Ciudad;
import com.example.crudfs.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Ciudad> getCiudadById(Long id) {
        return ciudadRepository.findById(id);
    }
    public void deleteCiudad(Long id) {
        ciudadRepository.deleteById(id);
    }
}
