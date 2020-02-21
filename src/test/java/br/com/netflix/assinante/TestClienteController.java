package br.com.netflix.assinante;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import br.com.netflix.cliente.controller.ClienteController;

@ContextConfiguration(classes = ClienteController.class)
public class TestClienteController {

	@Test
	public void testClienteController(){
		ClienteController clienteController = new ClienteController();
		String resultado = clienteController.home();
		assertEquals(resultado, "JUnit funcionando...");
	}
	
	//@Test
	//public void testClienteController() {
	//	ClienteController clienteController = new ClienteController();
	//	List<Cliente> result = clienteController.findAll();
    //    assertNotNull(result);
	//}
	
}