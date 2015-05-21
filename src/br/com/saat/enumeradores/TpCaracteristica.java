package br.com.saat.enumeradores;

public enum TpCaracteristica {
	Inicio_ano (1, "Início ano"), 
	Inicio_temporada (2, "Início temporada"),
	Pre_interclubes (3, "Pré interclubes");
	
	private final int valor; 
	private final String nome;
	
	TpCaracteristica(int valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}
	
	public int getValor(){
		return valor;
	}
	
	public String getNome(){
		return nome;
	}
}
