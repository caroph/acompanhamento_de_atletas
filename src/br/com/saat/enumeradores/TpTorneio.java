package br.com.saat.enumeradores;

public enum TpTorneio {
	CBT (1, "CBT"), 
	FPT (2, "FPT"),
	ITF (3, "ITF");
	
	
	private final int valor; 
	private final String nome;
	
	TpTorneio(int valor, String nome) {
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
