package br.com.saat.enumeradores;

public enum GrauParentesco {
	Mae (1, "M�e"),
	Pai (2, "Pai"),
	Tio (3, "Tio(a)"),
	Irmao (4, "Irm�o(�)"),
	Avo (5, "Av�(�)"),
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
