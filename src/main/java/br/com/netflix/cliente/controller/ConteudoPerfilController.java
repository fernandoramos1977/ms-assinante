package br.com.netflix.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netflix.cliente.model.ConteudoPerfilCliente;
import br.com.netflix.cliente.model.ConteudoPerfilIdentity;
import br.com.netflix.cliente.repository.ConteudoPerfilRepository;


@RestController
@RequestMapping({"v1/conteudos-perfil"})
public class ConteudoPerfilController {
	
	private ConteudoPerfilRepository repository;

	public ConteudoPerfilController(ConteudoPerfilRepository repository) {
		super();
		this.repository = repository;
	}
	
	// métodos do CRUD aqui
	   @GetMapping 
	   public List<ConteudoPerfilCliente> findAll(){
	      return repository.findAll();
	   }

	   @GetMapping(path = {"/detalha/{codigo}"})
		public ResponseEntity<ConteudoPerfilCliente> findById(@PathVariable ConteudoPerfilIdentity codigo){
		   return repository.findById(codigo)
		           .map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
		} 
		
	   
   
	   @PutMapping(value="/votar/{id}")
	   public ResponseEntity<ConteudoPerfilCliente> update(@PathVariable("id") ConteudoPerfilIdentity id,
	                                         @RequestBody ConteudoPerfilCliente cliente) {
	      return repository.findById(id)
	              .map(record -> {
	                  record.setFavorito(cliente.getFavorito());
	                  record.setAvaliacao(cliente.getAvaliacao());
	                  record.setTimestamp_ultimo_acesso(cliente.getTimestamp_ultimo_acesso());
	                  ConteudoPerfilCliente updated = repository.save(record);
	                  return ResponseEntity.ok().body(updated);
	              }).orElse(ResponseEntity.notFound().build());
	   }
	   
	   @PostMapping
	   public ConteudoPerfilCliente create(@RequestBody ConteudoPerfilCliente conteudo){
	      return repository.save(conteudo);
	   }
	   
}
