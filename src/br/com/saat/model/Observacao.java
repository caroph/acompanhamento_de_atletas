package br.com.saat.model;

import java.util.Date;

public class Observacao {
	public int idObservacao;
	public Atleta atleta;
	public Usuario usuario;
	public String dsObservacao;
	public int gravidade;
	public Date dtValidade;
	public Date dtGeracao;
	
	public Observacao(){}
	
	public Observacao(Atleta atleta, Usuario usuario,
			String dsObservacao, int gravidade, Date dtValidade) {
		super();
		this.atleta = atleta;
		this.usuario = usuario;
		this.dsObservacao = dsObservacao;
		this.gravidade = gravidade;
		this.dtValidade = dtValidade;
	}
	public int getIdObservacao() {
		return idObservacao;
	}
	public void setIdObservacao(int idObservacao) {
		this.idObservacao = idObservacao;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDsObservacao() {
		return dsObservacao;
	}
	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}
	public int getGravidade() {
		return gravidade;
	}
	public void setGravidade(int gravidade) {
		this.gravidade = gravidade;
	}
	public Date getDtValidade() {
		return dtValidade;
	}
	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}
	public Date getDtGeracao() {
		return dtGeracao;
	}
	public void setDtGeracao(Date dtGeracao) {
		this.dtGeracao = dtGeracao;
	}	
}
