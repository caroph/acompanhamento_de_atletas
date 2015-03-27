package br.com.saat.model;

public enum Equipes {
	Equipe (1, "Equipe"),
	PreEquipe (2, "Pré-Equipe");
	
	private final int valor;
	private final String nome;
	
	private Equipes(int valor, String nome) {
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
