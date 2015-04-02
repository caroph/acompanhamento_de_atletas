package br.com.saat.model;

public enum GrauParentesco {
	Mae (1, "Mãe"),
	Pai (2, "Pai"),
	Tio (3, "Tio(a)"),
	Irmao (4, "Irmão(ã)"),
	Avo (5, "Avô(ó)"),
	Outros (6, "Outros");
	
	private int valor;
	private String nome;
	
	private GrauParentesco(int valor, String nome){
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
