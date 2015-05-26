package br.com.saat.enumeradores;

public enum Mes {
	Janeiro (1, "Janeiro"),
	Fevereiro (2, "Fevereiro"),
	Marco (3, "Março"),
	Abril (4, "Abril"),
	Maio (5, "Maio"),
	Junho (6, "Junho"),
	Julho (7, "Julho"),
	Agosto (8, "Agosto"),
	Setembro (9, "Setembro"),
	Outubro (10, "Outubro"),
	Novembro (11, "Novembro"),
	Dezembro (12, "Dezembro");	
	
	private int valor;
	private String nome;
	
	private Mes(int valor, String nome){
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
