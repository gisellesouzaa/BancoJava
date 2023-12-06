package banco.modelo;

import java.time.LocalDateTime;

import banco.modelo.enums.TipoPessoa;

public class Pessoa {
	
	private String nome;
	private String documento;
	private Double rendimentoAnual;
	private TipoPessoa tipo = TipoPessoa.FISICA;
	private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Double getRendimentoAnual() {
		return rendimentoAnual;
	}
	public void setRendimentoAnual(Double rendimentoAnual) {
		this.rendimentoAnual = rendimentoAnual;
	}
	public TipoPessoa getTipo() {
		return tipo;
	}
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	
	
	
}
