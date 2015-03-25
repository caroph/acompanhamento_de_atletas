package br.com.saat.model;

public enum DiasSemana {
	Domingo (1, "Domingo"),
	Segunda (2, "Segunda-Feira"),
	Terca (3, "Terça-Feira"),
	Quarta (4, "Quarta-Feira"),
	Quinta (5, "Quinta-Feira"),
	Sexta (6, "Sexta-Feira"),
	Sabado (7, "Sábado");
	
	private int valor;
	private String nome;
	
	private DiasSemana(int valor, String nome){
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
