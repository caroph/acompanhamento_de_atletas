package br.com.saat.model;

import br.com.saat.enumeradores.TipoCat;

public class CategoriaAvaliacao {
	private int idCategoriaAvaliacao;
	private int idTipoCat;
	private String nmCategoria;
	private int idadeMinima;
	private int idadeMaxima;
	private String sexo;
	public int getIdCategoriaAvaliacao() {
		return idCategoriaAvaliacao;
	}
	public void setIdCategoriaAvaliacao(int idCategoriaAvaliacao) {
		this.idCategoriaAvaliacao = idCategoriaAvaliacao;
	}
	public int getIdTipoCat() {
		return idTipoCat;
	}
	public void setIdTipoCat(int idTipoCat) {
		this.idTipoCat = idTipoCat;
	}
	public String getNmCategoria() {
		return nmCategoria;
	}
	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	public int getIdadeMinima() {
		return idadeMinima;
	}
	public void setIdadeMinima(int idadeMinima) {
		this.idadeMinima = idadeMinima;
	}
	public int getIdadeMaxima() {
		return idadeMaxima;
	}
	public void setIdadeMaxima(int idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getNomeTipo(){
		String retorno = "";
		switch (this.idTipoCat) {
		case 1:
			retorno = TipoCat.Idade_Biologica.getNome();
			break;
		case 2:
			retorno = TipoCat.Idade_Cronologica.getNome();
			break;
		}
		return retorno;
	}
}
