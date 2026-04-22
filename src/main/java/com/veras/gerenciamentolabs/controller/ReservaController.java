package com.veras.gerenciamentolabs.controller;

import com.veras.gerenciamentolabs.domain.Reserva;
import com.veras.gerenciamentolabs.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> realizarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.realizarReserva(reserva);
        return ResponseEntity.ok(novaReserva);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {
        List<Reserva> reservas = reservaService.listarTodas();
        return ResponseEntity.ok(reservas);
    }
}