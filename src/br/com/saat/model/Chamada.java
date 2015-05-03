package br.com.saat.model;

import java.util.Date;

public class Chamada {
	public int idChamada;
	public int idUsuario;
	public int idDiaTreino;	
	public Date dtChamada;
	public Usuario usuario;
	public DiaTreino diaTreino;
	
	public Chamada(int idPessoa, int idDiaTreino, int nrQuadra, Date dtChamada) {
		this.idUsuario = idPessoa;
		this.idDiaTreino = idDiaTreino;
		this.dtChamada = dtChamada;
	}
	public Chamada() { }
	
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
	public Date getDtChamada() {
		return dtChamada;
	}
	public void setDtChamada(Date dtChamada) {
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
