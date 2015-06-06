package br.com.saat.enumeradores;

public enum Refeicao {
	Desjejum (1, "Desjejum"), 
	Lanche_Manha (2, "Lanche da manhã"),
	Pre_Treino_Manha (3, "Pré-treino manhã"), 
	Pos_Treino_Manha (4, "Pós-treino manhã"), 
	Pos_Fisico_Manha (5, "Pós-físico manhã"), 
	Almoco (6, "AlmoÃ§o"), 
	Lanche_Tarde (7, "Lanche da tarde"), 
	Pre_Treino_Tarde (8, "Pré-treino tarde"), 
	Pos_Treino_Tarde (9, "Pós-treino tarde"),
	Pos_Fisico_Tarde (10, "Pós-físico tarde"), 
	Janta (11, "Janta"), 
	Ceia (12, "Ceia"), 
	Pre_Treino_Noite (13, "Pré-treino noite"), 
	Pos_Treino_Noite (14, "Pós-treino noite"),
	Pos_Fisico_Noite (15, "Pós-físico noite");
	
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
