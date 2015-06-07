package br.com.saat.enumeradores;

public enum ResultadoTorneio {
	Primeira_Rodada (1, "1ª rodada"), 
	Segunda_Rodada (2, "2ª rodada"),
	Oitavas (3, "Oitavas de finais"),
	Quartas (4, "Quartas de finais"),
	Semi (5, "Semi final"),
	Finalista (6, "Finalista"),
	Campeao (7, "CampeÃ£o");
	
	private final int valor; 
	private final String nome;
	
	ResultadoTorneio(int valor, String nome) {
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
