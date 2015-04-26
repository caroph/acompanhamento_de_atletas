package br.com.saat.enumeradores;

public enum Naipe {
	Feminino (1, "Feminino"), 
	Masculino (2, "Masculino"),
	Unisex (3, "Unisex");
	
	
	private final int valor; 
	private final String nome;
	
	Naipe(int valor, String nome) {
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
