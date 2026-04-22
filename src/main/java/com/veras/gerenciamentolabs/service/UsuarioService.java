package com.veras.gerenciamentolabs.service;

import com.veras.gerenciamentolabs.domain.Usuario;
import com.veras.gerenciamentolabs.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Erro: Já existe um usuário cadastrado com o e-mail " + usuario.getEmail());
        }

        return usuarioRepository.save(usuario);
    }

    // Método simples para listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro: Usuário com ID " + id + " não encontrado!"));
    }
}