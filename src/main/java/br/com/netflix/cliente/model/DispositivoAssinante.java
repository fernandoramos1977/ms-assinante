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
public class DispositivoAssinante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Long cliente_codigo;
	private String descricao;
	private Short tipo;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getCliente_codigo() {
		return cliente_codigo;
	}
	public void setCliente_codigo(Long cliente_codigo) {
		this.cliente_codigo = cliente_codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Short getTipo() {
		return tipo;
	}
	public void setTipo(Short tipo) {
		this.tipo = tipo;
	}
	
	
	

}
