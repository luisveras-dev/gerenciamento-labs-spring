package com.veras.gerenciamentolabs.repository;

import com.veras.gerenciamentolabs.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // busca todas as reservas feitas para um laboratório específico
    List<Reserva> findByLaboratorioId(Long laboratorioId);
}