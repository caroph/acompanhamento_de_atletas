package br.com.saat.enumeradores;

public enum Perfis {
	Secretaria (1, "Secret�rio(a)"), 
	Nutricionista (2, "Nutricionista"),
	Psicologa (3, "Psic�logo(a)"),
	Fisioterapeuta (4, "Fisioterapeuta"),
	Tecnico (5, "T�cnico"),
	PreparadorFisico (6, "Preparador F�sico");
	
	private final int valor; 
	private final String nome;
	
	Perfis(int valor, String nome) {
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
