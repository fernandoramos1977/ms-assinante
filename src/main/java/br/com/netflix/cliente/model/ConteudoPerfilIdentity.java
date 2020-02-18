package br.com.netflix.cliente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConteudoPerfilIdentity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "perfil_cliente_codigo", unique = true)
	private Long perfil_cliente_codigo;
	
	@Column(name = "codigo_conteudo", unique = true)
	private Integer codigo_conteudo;

	public ConteudoPerfilIdentity() {
		super();
	}

	public ConteudoPerfilIdentity(Long perfil_cliente_codigo, Integer codigo_conteudo) {
		super();
		this.perfil_cliente_codigo = perfil_cliente_codigo;
		this.codigo_conteudo = codigo_conteudo;
	}

	public Long getPerfil_cliente_codigo() {
		return perfil_cliente_codigo;
	}

	public void setPerfil_cliente_codigo(Long perfil_cliente_codigo) {
		this.perfil_cliente_codigo = perfil_cliente_codigo;
	}

	public Integer getCodigo_conteudo() {
		return codigo_conteudo;
	}

	public void setCodigo_conteudo(Integer codigo_conteudo) {
		this.codigo_conteudo = codigo_conteudo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_conteudo == null) ? 0 : codigo_conteudo.hashCode());
		result = prime * result + ((perfil_cliente_codigo == null) ? 0 : perfil_cliente_codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConteudoPerfilIdentity other = (ConteudoPerfilIdentity) obj;
		if (codigo_conteudo == null) {
			if (other.codigo_conteudo != null)
				return false;
		} else if (!codigo_conteudo.equals(other.codigo_conteudo))
			return false;
		if (perfil_cliente_codigo == null) {
			if (other.perfil_cliente_codigo != null)
				return false;
		} else if (!perfil_cliente_codigo.equals(other.perfil_cliente_codigo))
			return false;
		return true;
	}

	
}
