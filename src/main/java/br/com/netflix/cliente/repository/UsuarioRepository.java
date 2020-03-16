package br.com.netflix.cliente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netflix.cliente.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}