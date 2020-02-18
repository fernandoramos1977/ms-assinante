package br.com.netflix.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.netflix.cliente.model.DispositivoAssinante;

@Repository
public interface DispositivoAssinanteRepository extends JpaRepository<DispositivoAssinante, Long> {

}
