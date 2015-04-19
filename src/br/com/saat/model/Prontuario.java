package br.com.saat.model;

import java.util.Date;

public class Prontuario {
	private int idProntuario;
	private Atleta atleta;
	private Usuario usuario;
	private Date dtAtendimento;
	private Date hrAtendimento;
	private String anotacao;
	
	public int getIdProntuario() {
		return idProntuario;
	}
	public void setIdProntuario(int idProntuario) {
		this.idProntuario = idProntuario;
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
	public Date getDtAtendimento() {
		return dtAtendimento;
	}
	public void setDtAtendimento(Date dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}
	public Date getHrAtendimento() {
		return hrAtendimento;
	}
	public void setHrAtendimento(Date hrAtendimento) {
		this.hrAtendimento = hrAtendimento;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

}
