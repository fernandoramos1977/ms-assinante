package br.com.netflix.cliente.model;

import java.sql.Blob;
import java.sql.Timestamp;

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
public class ChamadoTecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer protocolo;
	
	private Long dispositivo_assinante_codigo;
	private Timestamp timestamp_abertura;
	private Timestamp timestamp_fechamento;
	private String descricao;
	private Blob foto;
	private String avaliacao;
	public Integer getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(Integer protocolo) {
		this.protocolo = protocolo;
	}
	public Long getDispositivo_assinante_codigo() {
		return dispositivo_assinante_codigo;
	}
	public void setDispositivo_assinante_codigo(Long dispositivo_assinante_codigo) {
		this.dispositivo_assinante_codigo = dispositivo_assinante_codigo;
	}
	public Timestamp getTimestamp_abertura() {
		return timestamp_abertura;
	}
	public void setTimestamp_abertura(Timestamp timestamp_abertura) {
		this.timestamp_abertura = timestamp_abertura;
	}
	public Timestamp getTimestamp_fechamento() {
		return timestamp_fechamento;
	}
	public void setTimestamp_fechamento(Timestamp timestamp_fechamento) {
		this.timestamp_fechamento = timestamp_fechamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
	

}
