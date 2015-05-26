package br.com.saat.model;

import java.util.Date;
import java.util.List;

import br.com.saat.enumeradores.TpCaracteristica;

public class AvaliacaoFisica {

	private int idAvaliacaoFisica;
	private Atleta atleta;
	private int idUsuResp;
	private int idTpCaracteristica;
	private Date dtAvaliacao;
	private String dtAvaliacaoDisplay;
	private String observacaoGeral;
	private List<AvaliacaoResultado> avaliacaoResultado;
	
	public int getIdAvaliacaoFisica() {
		return idAvaliacaoFisica;
	}
	public void setIdAvaliacaoFisica(int idAvaliacaoFisica) {
		this.idAvaliacaoFisica = idAvaliacaoFisica;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public int getIdUsuResp() {
		return idUsuResp;
	}
	public void setIdUsuResp(int idUsuResp) {
		this.idUsuResp = idUsuResp;
	}
	public int getIdTpCaracteristica() {
		return idTpCaracteristica;
	}
	public void setIdTpCaracteristica(int idTpCaracteristica) {
		this.idTpCaracteristica = idTpCaracteristica;
	}
	public Date getDtAvaliacao() {
		return dtAvaliacao;
	}
	public void setDtAvaliacao(Date dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}
	public String getObservacaoGeral() {
		return observacaoGeral;
	}
	public void setObservacaoGeral(String observacaoGeral) {
		this.observacaoGeral = observacaoGeral;
	}
	public List<AvaliacaoResultado> getAvaliacaoResultado() {
		return avaliacaoResultado;
	}
	public void setAvaliacaoResultado(List<AvaliacaoResultado> avaliacaoResultado) {
		this.avaliacaoResultado = avaliacaoResultado;
	}
	public String getDtAvaliacaoDisplay() {
		return dtAvaliacaoDisplay;
	}
	public void setDtAvaliacaoDisplay(String dtAvaliacaoDisplay) {
		this.dtAvaliacaoDisplay = dtAvaliacaoDisplay;
	}
	public String getNomeCaracteristica(){
		String retorno = "";
		switch (this.idTpCaracteristica) {
		case 1:
			retorno = TpCaracteristica.Inicio_ano.getNome();
			break;
		case 2:
			retorno = TpCaracteristica.Inicio_temporada.getNome();
			break;
		case 3:
			retorno = TpCaracteristica.Pre_interclubes.getNome();
			break;
		}
		return retorno;
	}

}
