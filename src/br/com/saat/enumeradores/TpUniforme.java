package br.com.saat.enumeradores;

public enum TpUniforme {
	Blusinha (1, "Blusinha"), 
	Camiseta (2, "Camiseta"),
	Saia (3, "Saia"),
	Bermuda (4, "Bermuda"),
	Jaqueta (5, "Jaqueta"),
	Calca (6, "Calça");	
	
	private final int valor; 
	private final String nome;
	
	TpUniforme(int valor, String nome) {
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
