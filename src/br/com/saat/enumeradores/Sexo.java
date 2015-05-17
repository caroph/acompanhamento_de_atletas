package br.com.saat.enumeradores;

public enum Sexo {
	Feminino (1, "Feminino"), 
	Masculino (2, "Masculino");
	
	
	private final int valor; 
	private final String nome;
	
	Sexo(int valor, String nome) {
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
