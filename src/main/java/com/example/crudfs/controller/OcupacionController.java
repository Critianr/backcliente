package com.example.crudfs.controller;

import com.example.crudfs.controller.OcupacionController;
import com.example.crudfs.model.Ocupacion;
import com.example.crudfs.service.OcupacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ocupaciones")
public class OcupacionController {

    @Autowired
    private OcupacionService ocupacionService;

    @PostMapping
    public Ocupacion createOcupacion(@RequestBody Ocupacion ocupacion) {
        return ocupacionService.saveOcupacion(ocupacion);
    }

    @GetMapping
    public List<Ocupacion> getAllOcupaciones() {
        return ocupacionService.getAllOcupaciones();
    }

    @GetMapping("/{tipo}")
    public Ocupacion getOcupacionById(@PathVariable String tipo) {
        return ocupacionService.getOcupacionById(tipo);
    }

    @DeleteMapping("/{tipo}")
    public void deleteOcupacion(@PathVariable String tipo) {
        ocupacionService.deleteOcupacion(tipo);
    }
}
