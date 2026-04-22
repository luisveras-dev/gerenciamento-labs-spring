package com.veras.gerenciamentolabs.controller;

import com.veras.gerenciamentolabs.domain.Laboratorio;
import com.veras.gerenciamentolabs.service.LaboratorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratorios")
public class LaboratorioController {

    private final LaboratorioService laboratorioService;

    public LaboratorioController(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    @PostMapping
    public ResponseEntity<Laboratorio> criar(@RequestBody Laboratorio laboratorio) {
        Laboratorio novoLaboratorio = laboratorioService.salvar(laboratorio);
        return ResponseEntity.ok(novoLaboratorio);
    }

    @GetMapping
    public ResponseEntity<List<Laboratorio>> listar() {
        List<Laboratorio> laboratorios = laboratorioService.listarTodos();
        return ResponseEntity.ok(laboratorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> buscar(@PathVariable Long id) {
        Laboratorio laboratorio = laboratorioService.buscarPorId(id);
        return ResponseEntity.ok(laboratorio);
    }
}