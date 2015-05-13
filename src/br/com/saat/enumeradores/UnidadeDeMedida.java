package br.com.saat.enumeradores;

public enum UnidadeDeMedida {
	Minutos (1, "Minutos"), 
	Segundos (2, "Segundos"),
	Metros (3, "Metros"),
	Repeticoes (4, "Repetições");
	
	
	private final int valor; 
	private final String nome;
	
	UnidadeDeMedida(int valor, String nome) {
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
