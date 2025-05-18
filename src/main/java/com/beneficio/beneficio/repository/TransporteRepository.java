package com.beneficio.beneficio.repository;

import com.beneficio.beneficio.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransporteRepository extends JpaRepository<Transporte, String> {
List<Transporte> findByEstado(String estado);
}