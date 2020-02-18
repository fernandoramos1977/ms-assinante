package br.com.netflix.cliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netflix.cliente.model.ChamadoTecnico;
import br.com.netflix.cliente.repository.ChamadoTecnicoRepository;

@RestController
@RequestMapping({"/chamados-tecnico"})
public class ChamadoTecnicoController {
	
	private ChamadoTecnicoRepository repository;

	public ChamadoTecnicoController(ChamadoTecnicoRepository repository) {
		super();
		this.repository = repository;
	}
	
	// métodos do CRUD aqui
	@GetMapping 
	public List<ChamadoTecnico> findAll(){
	   return repository.findAll();
	}

}
