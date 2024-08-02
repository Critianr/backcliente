package com.example.crudfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    // Crear o Actualizar Cliente
//    public Cliente guardarCliente(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }
    public Cliente guardarCliente(Cliente cliente) {
        if (cliente.getNumeroDocumento() == null || cliente.getNumeroDocumento().isEmpty()) {
            throw new IllegalArgumentException("El número de documento es obligatorio");
        }
        return clienteRepository.save(cliente);
    }

    // Obtener Cliente por ID
    public Optional<Cliente> obtenerClientePorNumeroDocumento(String numero_documento) {
        return clienteRepository.findById(numero_documento);
    }

    // Obtener Todos los Clientes
    // public Iterable<Cliente> obtenerTodosClientes() {
    //    return clienteRepository.findAll();
    //}

    // Eliminar Cliente por ID
    public void eliminarClientePorNumeroDocumento(String numero_documento) {
        clienteRepository.deleteById(numero_documento);
    }
}