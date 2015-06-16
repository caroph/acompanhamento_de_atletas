package br.com.saat.model;

import java.util.Date;

public class OperacaoEstoqueUniforme {
	public int idOperacaoEstoqueUniforme;
	public int tpOperacao;
	public Date dtOperacao;
	public int quantidade;
	public Usuario usuario;
	public Uniforme uniforme;
	
	public OperacaoEstoqueUniforme(){}

	public int getIdOperacaoEstoqueUniforme() {
		return idOperacaoEstoqueUniforme;
	}

	public void setIdOperacaoEstoqueUniforme(int idOperacaoEstoqueUniforme) {
		this.idOperacaoEstoqueUniforme = idOperacaoEstoqueUniforme;
	}

	public int getTpOperacao() {
		return tpOperacao;
	}

	public void setTpOperacao(int tpOperacao) {
		this.tpOperacao = tpOperacao;
	}

	public Date getDtOperacao() {
		return dtOperacao;
	}

	public void setDtOperacao(Date dtOperacao) {
		this.dtOperacao = dtOperacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Uniforme getUniforme() {
		return uniforme;
	}

	public void setUniforme(Uniforme uniforme) {
		this.uniforme = uniforme;
	}		
}
