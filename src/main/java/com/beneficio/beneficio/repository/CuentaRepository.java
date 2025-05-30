package com.beneficio.beneficio.repository;

import com.beneficio.beneficio.model.Cuenta;
import com.beneficio.beneficio.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByAgricultor(Integer agricultor);
}
