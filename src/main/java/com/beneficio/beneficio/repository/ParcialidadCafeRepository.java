package com.beneficio.beneficio.repository;

import com.beneficio.beneficio.model.ParcialidadCafe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcialidadCafeRepository extends JpaRepository<ParcialidadCafe, Long> {
    List<ParcialidadCafe> findByCuenta_Cuenta(Long cuenta);
}
