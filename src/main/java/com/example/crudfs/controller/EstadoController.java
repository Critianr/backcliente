package com.example.crudfs.controller;

import com.example.crudfs.model.Estado;
import com.example.crudfs.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public Estado createEstado(@RequestBody Estado estado) {
        return estadoService.saveEstado(estado);
    }

    @GetMapping
    public List<Estado> getAllEstados() {
        return estadoService.getAllEstados();
    }

    @GetMapping("/{id}")
    public Estado getEstadoById(@PathVariable Long id) {
        return estadoService.getEstadoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEstado(@PathVariable Long id) {
        estadoService.deleteEstado(id);
    }
}
