package br.com.netflix.cliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netflix.cliente.model.DispositivoAssinante;
import br.com.netflix.cliente.repository.DispositivoAssinanteRepository;

@RestController
@RequestMapping({"/dispositivos-assinantes"})
public class DispositivoAssinanteController {
	
	private DispositivoAssinanteRepository repository;

	public DispositivoAssinanteController(DispositivoAssinanteRepository repository) {
		super();
		this.repository = repository;
	}
	
	// métodos do CRUD aqui
	   @GetMapping 
	   public List<DispositivoAssinante> findAll(){
	      return repository.findAll();
	   }

}
