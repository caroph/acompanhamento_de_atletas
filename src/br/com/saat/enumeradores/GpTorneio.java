package br.com.saat.enumeradores;

public enum GpTorneio {
	GA (1, "GA"), 
	GI (2, "GI"),
	GII (3, "GII"),
	GIII (4, "GIII"),
	GIV (3, "GIV"),
	GV (3, "GV");
	
	
	private final int valor; 
	private final String nome;
	
	GpTorneio(int valor, String nome) {
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
