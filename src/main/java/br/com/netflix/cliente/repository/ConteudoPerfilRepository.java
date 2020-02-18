package br.com.netflix.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.netflix.cliente.model.ConteudoPerfilCliente;
import br.com.netflix.cliente.model.ConteudoPerfilIdentity;

@Repository
public interface ConteudoPerfilRepository extends JpaRepository<ConteudoPerfilCliente, 
	ConteudoPerfilIdentity>{

}
