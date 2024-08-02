package com.example.crudfs;

import com.example.crudfs.Cliente;
import com.example.crudfs.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @PostMapping
//    public Cliente guardarCliente(@RequestBody Cliente cliente) {
//        return clienteService.guardarCliente(cliente);
//    }
    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
       if (cliente.getNumeroDocumento() == null || cliente.getNumeroDocumento().isEmpty()) {
           return ResponseEntity.badRequest().body(null);
    }
    Cliente clienteGuardado = clienteService.guardarCliente(cliente);
    return ResponseEntity.ok(clienteGuardado);
}
    @GetMapping("/numero_documento")
    public Optional<Cliente> obtenerCliente(@PathVariable String numero_documento) {
        return clienteService.obtenerClientePorNumeroDocumento(numero_documento);
    }

    //@GetMapping
    //public Iterable<Cliente> obtenerTodosClientes() {
    //    return clienteService.obtenerTodosClientes();
    //}

    @DeleteMapping("/{numero_documento}")
    public void eliminarCliente(@PathVariable String numero_documento) {
        clienteService.eliminarClientePorNumeroDocumento(numero_documento);
    }
}
