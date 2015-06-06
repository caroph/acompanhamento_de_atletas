package br.com.saat.enumeradores;

public enum Refeicao {
	Desjejum (1, "Desjejum"), 
	Lanche_Manha (2, "Lanche da manh�"),
	Pre_Treino_Manha (3, "Pr�-treino manh�"), 
	Pos_Treino_Manha (4, "P�s-treino manh�"), 
	Pos_Fisico_Manha (5, "P�s-f�sico manh�"), 
	Almoco (6, "Almoço"), 
	Lanche_Tarde (7, "Lanche da tarde"), 
	Pre_Treino_Tarde (8, "Pr�-treino tarde"), 
	Pos_Treino_Tarde (9, "P�s-treino tarde"),
	Pos_Fisico_Tarde (10, "P�s-f�sico tarde"), 
	Janta (11, "Janta"), 
	Ceia (12, "Ceia"), 
	Pre_Treino_Noite (13, "Pr�-treino noite"), 
	Pos_Treino_Noite (14, "P�s-treino noite"),
	Pos_Fisico_Noite (15, "P�s-f�sico noite");
	
	private final int valor; 
	private final String nome;
	
	Refeicao(int valor, String nome) {
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
