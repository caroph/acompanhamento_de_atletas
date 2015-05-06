package br.com.saat.model;

public class PresencaChamada {
	private int idPresencaChamada;
	private int idChamada;
	private int idAtleta;
	private int estadoPresencaT;
	private String justificativaT;
	private int nrQuadra;
	private int estadoPresencaF;
	private String justificativaF;
	private Atleta atleta;
	private Chamada chamada;
	
	public PresencaChamada(){}

	public PresencaChamada(int idPresencaChamada, int idChamada, int idAtleta,
			int estadoPresencaT, String justificativaT, int estadoPresencaF, String justificativaF) {
		this.idPresencaChamada = idPresencaChamada;
		this.idChamada = idChamada;
		this.idAtleta = idAtleta;
		this.estadoPresencaT = estadoPresencaT;
		this.justificativaT = justificativaT;
		this.estadoPresencaF = estadoPresencaF;
		this.justificativaF = justificativaF;
	}

	public int getIdPresencaChamada() {
		return idPresencaChamada;
	}

	public void setIdPresencaChamada(int idPresencaChamada) {
		this.idPresencaChamada = idPresencaChamada;
	}

	public int getIdChamada() {
		return idChamada;
	}

	public void setIdChamada(int idChamada) {
		this.idChamada = idChamada;
	}

	public int getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(int idAtleta) {
		this.idAtleta = idAtleta;
	}

	public int getNrQuadra() {
		return nrQuadra;
	}

	public void setNrQuadra(int nrQuadra) {
		this.nrQuadra = nrQuadra;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Chamada getChamada() {
		return chamada;
	}

	public void setChamada(Chamada chamada) {
		this.chamada = chamada;
	}

	public int getEstadoPresencaT() {
		return estadoPresencaT;
	}

	public void setEstadoPresencaT(int estadoPresencaT) {
		this.estadoPresencaT = estadoPresencaT;
	}

	public String getJustificativaT() {
		return justificativaT;
	}

	public void setJustificativaT(String justificativaT) {
		this.justificativaT = justificativaT;
	}

	public int getEstadoPresencaF() {
		return estadoPresencaF;
	}

	public void setEstadoPresencaF(int estadoPresencaF) {
		this.estadoPresencaF = estadoPresencaF;
	}

	public String getJustificativaF() {
		return justificativaF;
	}

	public void setJustificativaF(String justificativaF) {
		this.justificativaF = justificativaF;
	}
}
