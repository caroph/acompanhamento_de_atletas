package br.com.saat.enumeradores;

public enum Turno {
	Manha (1, "Manhã"), 
	Tarde (2, "Tarde"),
	Noite (3, "Noite"),
	Integral (4, "Integral");
	
	
	private final int valor; 
	private final String nome;
	
	Turno(int valor, String nome) {
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
