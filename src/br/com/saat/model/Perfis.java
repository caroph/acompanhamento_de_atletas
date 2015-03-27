package br.com.saat.model;

public enum Perfis {
	Secretaria (1, "Secretário(a)"), 
	Nutricionista (2, "Nutricionista"),
	Psicologa (3, "Psicólogo(a)"),
	Fisioterapeuta (4, "Fisioterapeuta"),
	Tecnico (5, "Técnico"),
	PreparadorFisico (6, "Preparador Físico");
	
	private final int valor; 
	private final String nome;
	
	Perfis(int valor, String nome) {
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
