package com.veras.gerenciamentolabs.service;

import com.veras.gerenciamentolabs.domain.Laboratorio;
import com.veras.gerenciamentolabs.repository.LaboratorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratorioService {

    private final LaboratorioRepository laboratorioRepository;

    public LaboratorioService(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    // Regra de Negócio: Salvar um novo laboratório com validações
    public Laboratorio salvar(Laboratorio laboratorio) {
        // Validação 1: Um laboratório não pode ter capacidade zero ou negativa
        if (laboratorio.getCapacidade() == null || laboratorio.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Erro: A capacidade do laboratório deve ser maior que zero.");
        }

        // Validação 2: Se ninguém informar o status, ele nasce como "ATIVO" por padrão
        if (laboratorio.getStatus() == null || laboratorio.getStatus().trim().isEmpty()) {
            laboratorio.setStatus("ATIVO");
        }

        return laboratorioRepository.save(laboratorio);
    }

    public List<Laboratorio> listarTodos() {
        return laboratorioRepository.findAll();
    }

    public Laboratorio buscarPorId(Long id) {
        return laboratorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro: Laboratório com ID " + id + " não encontrado!"));
    }
}