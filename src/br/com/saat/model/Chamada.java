package br.com.saat.model;

public class Chamada {
	public int idChamada;
	public int idUsuario;
	public int idDiaTreino;
	public int nrQuadra;
	public int dtChamada;
	public Usuario usuario;
	public DiaTreino diaTreino;
	
	public int getIdChamada() {
		return idChamada;
	}
	public void setIdChamada(int idChamada) {
		this.idChamada = idChamada;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdDiaTreino() {
		return idDiaTreino;
	}
	public void setIdDiaTreino(int idDiaTreino) {
		this.idDiaTreino = idDiaTreino;
	}
	public int getNrQuadra() {
		return nrQuadra;
	}
	public void setNrQuadra(int nrQuadra) {
		this.nrQuadra = nrQuadra;
	}
	public int getDtChamada() {
		return dtChamada;
	}
	public void setDtChamada(int dtChamada) {
		this.dtChamada = dtChamada;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public DiaTreino getDiaTreino() {
		return diaTreino;
	}
	public void setDiaTreino(DiaTreino diaTreino) {
		this.diaTreino = diaTreino;
	}
	
}
