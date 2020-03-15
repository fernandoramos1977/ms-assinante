package br.com.netflix.cliente.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.netflix.cliente.dto.ClienteDto;
import br.com.netflix.cliente.model.Cliente;
import br.com.netflix.cliente.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteController() {
	};

	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// métodos do CRUD aqui
	@RequestMapping("/clientes")	
	public List<ClienteDto> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.converter(clientes); 		
	}

	public String home() {
        return "JUnit funcionando...";
    }
}
