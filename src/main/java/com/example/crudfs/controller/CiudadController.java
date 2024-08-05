package com.example.crudfs.controller;

import com.example.crudfs.model.Ciudad;
import com.example.crudfs.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ciudades")
@CrossOrigin(origins = "http://localhost:5173/")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @PostMapping
    public Ciudad createCiudad(@RequestBody Ciudad ciudad) {
        return ciudadService.saveCiudad(ciudad);
    }

    @GetMapping
    public List<Ciudad> getAllCiudades() {
        return ciudadService.getAllCiudades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ciudad>> getCiudadById(@PathVariable Long id) {
        Optional<Ciudad> ciudad = ciudadService.getCiudadById(id);
        if (ciudad != null) {
            return ResponseEntity.ok(ciudad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiudad(@PathVariable Long id) {
        ciudadService.deleteCiudad(id);
        return ResponseEntity.noContent().build();
    }
}
