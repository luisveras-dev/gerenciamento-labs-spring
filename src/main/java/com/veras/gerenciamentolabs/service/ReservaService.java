package com.veras.gerenciamentolabs.service;

import com.veras.gerenciamentolabs.domain.Laboratorio;
import com.veras.gerenciamentolabs.domain.Reserva;
import com.veras.gerenciamentolabs.domain.Usuario;
import com.veras.gerenciamentolabs.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final LaboratorioService laboratorioService;
    private final UsuarioService usuarioService;

    // Agora o serviço de reservas trabalha em conjunto com os outros dois
    public ReservaService(ReservaRepository reservaRepository,
                          LaboratorioService laboratorioService,
                          UsuarioService usuarioService) {
        this.reservaRepository = reservaRepository;
        this.laboratorioService = laboratorioService;
        this.usuarioService = usuarioService;
    }

    public Reserva realizarReserva(Reserva novaReserva) {
        Laboratorio labReal = laboratorioService.buscarPorId(novaReserva.getLaboratorio().getId());
        Usuario usuarioReal = usuarioService.buscarPorId(novaReserva.getUsuario().getId());

        novaReserva.setLaboratorio(labReal);
        novaReserva.setUsuario(usuarioReal);

        // testando o status do laboratório real
        if (!"ATIVO".equals(labReal.getStatus())) {
            throw new RuntimeException("Erro: O laboratório selecionado não está disponível para reservas.");
        }

        // validando se a data de início é antes da data de fim
        if (novaReserva.getDataHoraInicio().isAfter(novaReserva.getDataHoraFim())) {
            throw new RuntimeException("Erro: A data de início não pode ser posterior à data de término.");
        }

        // 4. validando conflito de horário
        List<Reserva> reservasExistentes = reservaRepository.findByLaboratorioId(labReal.getId());

        for (Reserva existente : reservasExistentes) {
            if (houveConflito(novaReserva, existente)) {
                throw new RuntimeException("Erro: Já existe uma reserva para este laboratório no horário selecionado.");
            }
        }

        novaReserva.setStatus("CONFIRMADA");
        return reservaRepository.save(novaReserva);
    }

    private boolean houveConflito(Reserva nova, Reserva existente) {
        return nova.getDataHoraInicio().isBefore(existente.getDataHoraFim()) &&
                nova.getDataHoraFim().isAfter(existente.getDataHoraInicio());
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }
}