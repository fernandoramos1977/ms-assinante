package br.com.netflix.cliente.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ConteudoPerfilCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ConteudoPerfilIdentity conteudoPerfilIdentity;
	
	private String favorito;
	private String avaliacao;
	private Timestamp timestamp_ultimo_acesso;
	
	public String getFavorito() {
		return favorito;
	}
	public void setFavorito(String favorito) {
		this.favorito = favorito;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Timestamp getTimestamp_ultimo_acesso() {
		return timestamp_ultimo_acesso;
	}
	public void setTimestamp_ultimo_acesso(Timestamp timestamp_ultimo_acesso) {
		this.timestamp_ultimo_acesso = timestamp_ultimo_acesso;
	}
	
	

}
