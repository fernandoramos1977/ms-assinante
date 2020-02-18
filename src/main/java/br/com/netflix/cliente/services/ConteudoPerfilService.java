package br.com.netflix.cliente.services;

import br.com.netflix.cliente.events.SimpleSourceBean;
import br.com.netflix.cliente.model.ConteudoPerfilCliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.netflix.cliente.repository.ConteudoPerfilRepository;


@Service
public class ConteudoPerfilService {
	
	@Autowired
	private ConteudoPerfilRepository conteudoRepository;
	
	@Autowired
	private SimpleSourceBean simpleSourceBean;
	
	public List<ConteudoPerfilCliente> getConteudo() {
		List<ConteudoPerfilCliente> listaConteudos = conteudoRepository.findAll();		
		simpleSourceBean.publishFindGenero("SELECT", listaConteudos);
		return listaConteudos;
	}
	
	

}
