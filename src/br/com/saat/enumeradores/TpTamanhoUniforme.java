package br.com.saat.enumeradores;

public enum TpTamanhoUniforme {
	//10, 12, 14, 16, PP, P, M, G, GG
	N10 (1, "10"), 
	N12 (2, "12"),
	N14 (3, "14"),
	N16 (4, "16"),
	PP (5, "PP"), 
	P (6, "P"),
	M (7, "M"),
	G (8, "G"),
	GG (9, "GG");
	
	private final int valor; 
	private final String nome;
	
	TpTamanhoUniforme(int valor, String nome) {
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
