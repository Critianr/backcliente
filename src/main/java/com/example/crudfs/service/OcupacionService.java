package com.example.crudfs.service;
import com.example.crudfs.model.Ocupacion;
import com.example.crudfs.repository.OcupacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OcupacionService {

    @Autowired
    private OcupacionRepository ocupacionRepository;

    public Ocupacion saveOcupacion(Ocupacion ocupacion) {
        return ocupacionRepository.save(ocupacion);
    }

    public List<Ocupacion> getAllOcupaciones() {
        return ocupacionRepository.findAll();
    }

    public Ocupacion getOcupacionById(String tipo) {
        return ocupacionRepository.findById(tipo).orElse(null);
    }

    public void deleteOcupacion(String tipo) {
        ocupacionRepository.deleteById(tipo);
    }
}
