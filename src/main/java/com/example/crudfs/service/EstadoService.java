package com.example.crudfs.service;

import com.example.crudfs.model.Estado;
import com.example.crudfs.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado saveEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    public Estado getEstadoById(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    public void deleteEstado(Long id) {
        estadoRepository.deleteById(id);
    }
}
