package com.example.crudfs.controller;

import com.example.crudfs.model.Cliente;
import com.example.crudfs.model.Ocupacion;
import com.example.crudfs.model.Ocupacion;
import com.example.crudfs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }
    @GetMapping("/numero_documento")
    public Optional<Cliente> obtenerCliente(@PathVariable String numero_documento) {
        return clienteService.obtenerClientePorNumeroDocumento(numero_documento);
    }
    @DeleteMapping("/eliminar/{numero_documento}")
    public void eliminarCliente(@PathVariable String numero_documento) {
        clienteService.eliminarClientePorNumeroDocumento(numero_documento);
    }
}
