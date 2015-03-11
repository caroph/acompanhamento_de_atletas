package br.com.saat.model;

public enum Perfis {
	Secretaria (1), 
	Nutricionista (2),
	Psicologa (3),
	Fisioterapeuta (4),
	Tecnico (5),
	PreparadorFisico (6);
	
	private final int valor; 
	Perfis(int valor){ 
		this.valor = valor; 
	}
	
	public int getValor(){
		return valor;
	}
}
