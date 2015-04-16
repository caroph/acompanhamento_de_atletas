package br.com.saat.model;

public class PresencaChamada {
	private int idPresencaChamada;
	private int idChamada;
	private int idAtleta;
	private int estadoPresenca;
	private String justificativa;
	
	public PresencaChamada(){}

	public PresencaChamada(int idPresencaChamada, int idChamada, int idAtleta,
			int estadoPresenca, String justificativa) {
		this.idPresencaChamada = idPresencaChamada;
		this.idChamada = idChamada;
		this.idAtleta = idAtleta;
		this.estadoPresenca = estadoPresenca;
		this.justificativa = justificativa;
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

	public int getEstadoPresenca() {
		return estadoPresenca;
	}

	public void setEstadoPresenca(int estadoPresenca) {
		this.estadoPresenca = estadoPresenca;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}	
}
