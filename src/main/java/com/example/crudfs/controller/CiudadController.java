package com.example.crudfs.controller;

import com.example.crudfs.model.Ciudad;
import com.example.crudfs.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{name}")
    public Ciudad getCiudadById(@PathVariable String name) {
        return ciudadService.getCiudadById(name);
    }

}
