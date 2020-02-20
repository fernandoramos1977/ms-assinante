package br.com.netflix.cliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netflix.cliente.model.Cliente;
import br.com.netflix.cliente.repository.ClienteRepository;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {
	
	private ClienteRepository repository;

	public ClienteController()	{};

	   public ClienteController(ClienteRepository clienteRepository) {
	       this.repository = clienteRepository;
	   }
	   // métodos do CRUD aqui
	   @GetMapping 
	   public List<Cliente> findAll(){
	      return repository.findAll();
	   }

	   @GetMapping
    	public String home() {
          return "JUnit funcionando...";
       }
}
