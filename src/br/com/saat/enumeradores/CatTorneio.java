package br.com.saat.enumeradores;

public enum CatTorneio {
	Classes (1, "Classes"), 
	Infanto_Juvenil (2, "Infanto Juvenil"),
	Intercambio (3, "Intercambio"),
	Interno (4, "Interno");
	
	
	private final int valor; 
	private final String nome;
	
	CatTorneio(int valor, String nome) {
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
