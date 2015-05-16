package br.com.saat.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.saat.enumeradores.Gravidade;

public class Observacao {
	public int idObservacao;
	public Atleta atleta;
	public Usuario usuario;
	public String dsObservacao;
	public int gravidade;
	public Date dtValidade;
	public Date dtGeracao;
	public int flCadastroAtivo;
	public Date dtVisualizacao;
	
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
	public int getFlCadastroAtivo() {
		return flCadastroAtivo;
	}
	public void setFlCadastroAtivo(int flCadastroAtivo) {
		this.flCadastroAtivo = flCadastroAtivo;
	}

	public String getNomeGravidade(){
		switch(this.gravidade){
			case 1: return Gravidade.Baixa.getNome();
			case 2: return Gravidade.Moderada.getNome();
			case 3: return Gravidade.Alta.getNome();
			default: return "";
		}
	}
	
	public String getDisplayDataValidade(){
		try{
			DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY"); 
			String dt = formatter.format(this.dtValidade);
			return dt;
		}catch(Exception e){
			return "";
		}
	}
	
	public String getDisplayDataGeracao(){
		try{
			DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY"); 
			String dt = formatter.format(this.dtGeracao);
			return dt;
		}catch(Exception e){
			return "";
	}
	}

	public Date getDtVisualizacao() {
		return dtVisualizacao;
	}

	public void setDtVisualizacao(Date dtVisualizacao) {
		this.dtVisualizacao = dtVisualizacao;
	}	
}
