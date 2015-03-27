package br.com.saat.model;

public enum TpPessoa {
	Atleta (1), 
	Responsavel (2),
	Usuario (3);
	
	private final int valor; 
	TpPessoa(int valor){ 
		this.valor = valor; 
	}
	
	public int getValor(){
		return valor;
	}
}
