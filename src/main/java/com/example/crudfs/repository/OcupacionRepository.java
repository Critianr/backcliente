package com.example.crudfs.repository;


import com.example.crudfs.model.Ocupacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OcupacionRepository extends JpaRepository<Ocupacion, String> {
}
