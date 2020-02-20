package br.com.netflix.assinante;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

import br.com.netflix.cliente.controller.ClienteController;
import br.com.netflix.cliente.model.Cliente;

public class JUnitControllerTest {

	@Test
	public void testClienteController1(){
		ClienteController clienteController = new ClienteController();
		String resultado = clienteController.home();
		assertEquals(resultado, "JUnit funcionando...");
	}
	
	@Test
	public void testClienteController() {
		ClienteController clienteController = new ClienteController();
		List<Cliente> result = clienteController.findAll();
        assertNotNull(result);
	}
	
}