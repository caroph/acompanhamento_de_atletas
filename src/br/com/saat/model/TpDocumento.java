package br.com.saat.model;

public enum TpDocumento {
	termoDeCompromisso (1),
	declaracaoMedica (2),
	autorizacaoDeViagem (3),
	autorizacaoDeImagem (4),
	copiaDoRG (5),
	copiaDoCPF (6),
	fotoDoAtleta (7);	
	
	private final int valor; 
	TpDocumento(int valor){ 
		this.valor = valor; 
	}
	
	public int getValor(){
		return valor;
	}
}
