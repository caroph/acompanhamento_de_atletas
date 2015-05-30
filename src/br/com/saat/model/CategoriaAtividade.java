package br.com.saat.model;

public class CategoriaAtividade {
	private int idCategoriaAtividade;
	private CategoriaAvaliacao CategoriaAvaliacao;
	private AtividadeAvaliacao AtividadeAvaliacao;
	private float melhorar;
	private float media;
	private float bom;
	private float excelente;
	
	public int getIdCategoriaAtividade() {
		return idCategoriaAtividade;
	}
	public void setIdCategoriaAtividade(int idCategoriaAtividade) {
		this.idCategoriaAtividade = idCategoriaAtividade;
	}
	public CategoriaAvaliacao getCategoriaAvaliacao() {
		return CategoriaAvaliacao;
	}
	public void setCategoriaAvaliacao(CategoriaAvaliacao CategoriaAvaliacao) {
		this.CategoriaAvaliacao = CategoriaAvaliacao;
	}
	public AtividadeAvaliacao getAtividadeAvaliacao() {
		return AtividadeAvaliacao;
	}
	public void setAtividadeAvaliacao(AtividadeAvaliacao AtividadeAvaliacao) {
		this.AtividadeAvaliacao = AtividadeAvaliacao;
	}
	public float getMelhorar() {
		return melhorar;
	}
	public void setMelhorar(float melhorar) {
		this.melhorar = melhorar;
	}
	public float getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public float getBom() {
		return bom;
	}
	public void setBom(float bom) {
		this.bom = bom;
	}
	public float getExcelente() {
		return excelente;
	}
	public void setExcelente(float excelente) {
		this.excelente = excelente;
	}
	
}
