package br.com.netflix.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.netflix.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
