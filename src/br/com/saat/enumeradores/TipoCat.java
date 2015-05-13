package br.com.saat.enumeradores;

public enum TipoCat {
	Idade_Biologica (1, "Idade biológica"), 
	Idade_Cronologica (2, "Idade cronológica");
	
	
	private final int valor; 
	private final String nome;
	
	TipoCat(int valor, String nome) {
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
