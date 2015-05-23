package br.com.saat.model;

public class AvaliacaoDesempenho {
	public int idAvaliacaoDesempenho;
	public Atleta atleta;
	public Usuario usuario;
	public int mes;
	public int ano;
	public boolean torneios;
	public boolean treinos;
	public boolean avaliacoes;
	public int rankFPT;
	public int rankCBT;
	public int rankITF;
	public boolean bonificado;
	public String observacoes;
	
	public AvaliacaoDesempenho(){}

	public int getIdAvaliacaoDesempenho() {
		return idAvaliacaoDesempenho;
	}

	public void setIdAvaliacaoDesempenho(int idAvaliacaoDesempenho) {
		this.idAvaliacaoDesempenho = idAvaliacaoDesempenho;
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

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean getTorneios() {
		return torneios;
	}

	public void setTorneios(boolean torneios) {
		this.torneios = torneios;
	}

	public boolean getTreinos() {
		return treinos;
	}

	public void setTreinos(boolean treinos) {
		this.treinos = treinos;
	}

	public boolean getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(boolean avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public int getRankFPT() {
		return rankFPT;
	}

	public void setRankFPT(int rankFPT) {
		this.rankFPT = rankFPT;
	}

	public int getRankCBT() {
		return rankCBT;
	}

	public void setRankCBT(int rankCBT) {
		this.rankCBT = rankCBT;
	}

	public int getRankITF() {
		return rankITF;
	}

	public void setRankITF(int rankITF) {
		this.rankITF = rankITF;
	}

	public boolean getBonificado() {
		return bonificado;
	}

	public void setBonificado(boolean bonificado) {
		this.bonificado = bonificado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}	
}
