package br.com.netflix.cliente.events;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

import br.com.netflix.cliente.model.ConteudoPerfilCliente;


@Component
public class SimpleSourceBean {
	private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

	@Autowired
	private Source source;

	public void publishOrgChange(String action, String orgId) {
		logger.debug("Sending Kafka message {} for Organization Id: {}", action, orgId);
		//OrganizationChangeModel change = new OrganizationChangeModel(OrganizationChangeModel.class.getTypeName(),
		//		action, orgId);
		//source.output().send(MessageBuilder.withPayload(change).build());
	}

	public void publishFindGenero(String string, List<ConteudoPerfilCliente> listaConteudos) {
		// TODO Auto-generated method stub
		
	}

}
