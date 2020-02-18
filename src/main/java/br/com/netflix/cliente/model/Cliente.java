package br.com.netflix.cliente.model;

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
public class Cliente {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long codigo;
	   
	   private String nome;
	   private String email;
	   private String telefone;
	   private Short plano_assinatura;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Short getPlano_assinatura() {
		return plano_assinatura;
	}
	public void setPlano_assinatura(Short plano_assinatura) {
		this.plano_assinatura = plano_assinatura;
	}
	   
	   
}
