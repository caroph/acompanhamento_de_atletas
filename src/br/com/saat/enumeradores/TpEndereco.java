package br.com.saat.enumeradores;

public enum TpEndereco {
	Residencial (1),
	Comercial (2);
	
	private final int valor; 
	TpEndereco(int valor){ 
		this.valor = valor; 
	}
	
	public int getValor(){
		return valor;
	}
}
