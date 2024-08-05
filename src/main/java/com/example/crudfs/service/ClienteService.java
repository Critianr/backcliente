package com.example.crudfs.service;

import com.example.crudfs.model.Ciudad;
import com.example.crudfs.model.Cliente;
import com.example.crudfs.repository.CiudadRepository;
import com.example.crudfs.repository.ClienteRepository;
import com.example.crudfs.repository.EstadoRepository;
import com.example.crudfs.repository.OcupacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OcupacionRepository ocupacionRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
//    public Cliente guardarCliente(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }

//     Crear o Actualizar Cliente
    //public Cliente guardarCliente(Cliente cliente) {
        //return clienteRepository.save(cliente);
    //}
@Transactional
public Cliente guardarCliente(Cliente cliente) {
    Ciudad ciudad = cliente.getCiudad();
    if (ciudad != null && ciudad.getId() == null) {
        // Si la ciudad no tiene id, guárdala primero
        Optional<Ciudad> ciudadExistente = ciudadRepository.findByNombre(ciudad.getNombre());
        if (ciudadExistente.isPresent()) {
            cliente.setCiudad(ciudadExistente.get());
        } else {
            ciudad = ciudadRepository.save(ciudad);
            cliente.setCiudad(ciudad);
        }
    }
    return clienteRepository.save(cliente);
}

//    public Cliente guardarCliente(Cliente cliente) {
//        if (cliente.getNumeroDocumento() == null || cliente.getNumeroDocumento().isEmpty()) {
//            throw new IllegalArgumentException("El número de documento es obligatorio");
//        }
//        return clienteRepository.save(cliente);
//    }

    // Obtener Cliente por ID
//    public Optional<Cliente> obtenerClientePorNumeroDocumento(String numero_documento) {
//        return clienteRepository.findById(numero_documento);
//    }
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