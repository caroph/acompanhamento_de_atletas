package br.com.saat.enumeradores;

public enum Gravidade {
	Baixa (1, "Baixa"), 
	Moderada (2, "Moderada"),
	Alta (3, "Alta");	
	
	private final int valor; 
	private final String nome;
	
	Gravidade(int valor, String nome) {
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
