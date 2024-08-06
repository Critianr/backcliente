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
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(savedCliente);
    }
//    @PostMapping
//    public Cliente guardarCliente(@RequestBody Cliente cliente) {
//        return clienteService.guardarCliente(cliente);
//    }
    @GetMapping("/numero_documento")
    public Optional<Cliente> obtenerCliente(@PathVariable String numero_documento) {
        return clienteService.obtenerClientePorNumeroDocumento(numero_documento);
    }

    @CrossOrigin(origins = "http://localhost:5173/") // Cambia esto al origen que necesites permitir
    @PutMapping("/upgrade/{numero_documento}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable String numero_documento,
            @RequestBody Cliente cliente) {
        // Verificar si el cliente con el número de documento existe
        Optional<Cliente> clienteExistente = clienteService.obtenerClientePorNumeroDocumento(numero_documento);
        if (clienteExistente.isPresent()) {
            // Actualizar el cliente
            cliente.setNumeroDocumento(numero_documento);
            Cliente updatedCliente = clienteService.guardarCliente(cliente);
            return ResponseEntity.ok(updatedCliente);
        } else {
            // Cliente no encontrado
            return ResponseEntity.notFound().build();
        }
    }
//    public Optional<Cliente> obtenerClientePorNumeroDocumento(String numero_documento) {
//        return clienteRepository.findById(numero_documento);
//    }
    @CrossOrigin(origins = "http://localhost:5173/") // Cambia esto al origen que necesites permitir
    @DeleteMapping("/eliminar/{numero_documento}")
    public void eliminarCliente(@PathVariable String numero_documento) {
        clienteService.eliminarClientePorNumeroDocumento(numero_documento);
    }
}
