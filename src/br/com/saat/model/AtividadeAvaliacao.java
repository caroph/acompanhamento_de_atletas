package br.com.saat.model;

import br.com.saat.enumeradores.UnidadeDeMedida;

public class AtividadeAvaliacao {
	private int idAtividadeAvaliacao;
	private int idUnidadeDeMedida;
	private String capacidade;
	private String teste;
	
	public int getIdAtividadeAvaliacao() {
		return idAtividadeAvaliacao;
	}
	public void setIdAtividadeAvaliacao(int idAtividadeAvaliacao) {
		this.idAtividadeAvaliacao = idAtividadeAvaliacao;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public String getTeste() {
		return teste;
	}
	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	public int getIdUnidadeDeMedida() {
		return idUnidadeDeMedida;
	}
	public void setIdUnidadeDeMedida(int idUnidadeDeMedida) {
		this.idUnidadeDeMedida = idUnidadeDeMedida;
	}
	
	public String getNomeUnidade(){
		String retorno = "";
		switch (this.idUnidadeDeMedida) {
		case 1:
			retorno = UnidadeDeMedida.Minutos.getNome();
			break;
		case 2:
			retorno = UnidadeDeMedida.Segundos.getNome();
			break;
		case 3:
			retorno = UnidadeDeMedida.Metros.getNome();
			break;
		case 4:
			retorno = UnidadeDeMedida.Repeticoes.getNome();
			break;
		}
		return retorno;
	}
}
