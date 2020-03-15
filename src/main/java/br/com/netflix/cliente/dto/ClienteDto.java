package br.com.netflix.cliente.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.netflix.cliente.model.Cliente;

public class ClienteDto {
    
    private String nome;
    private String email;
    private String telefone;


    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public static List<ClienteDto> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }


    

}