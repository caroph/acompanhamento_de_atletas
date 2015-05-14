package br.com.saat.model;

import br.com.saat.enumeradores.TipoCat;
import br.com.saat.enumeradores.UnidadeDeMedida;

public class CategoriaAvaliacao {
	private int idCategoriaAvaliacao;
	private int idTipoCat;
	private String nmCategoria;
	private float idadeMinima;
	private float idadeMaxima;
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
	public float getIdadeMinima() {
		return idadeMinima;
	}
	public void setIdadeMinima(float idadeMinima) {
		this.idadeMinima = idadeMinima;
	}
	public float getIdadeMaxima() {
		return idadeMaxima;
	}
	public void setIdadeMaxima(float idadeMaxima) {
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
