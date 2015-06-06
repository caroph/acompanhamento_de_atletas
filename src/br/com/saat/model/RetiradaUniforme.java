package br.com.saat.model;

import java.util.Date;

public class RetiradaUniforme {
	public int idRetiradaUniforme;
	public Usuario usuario;
	public Atleta atleta;
	public Date dataRetirada;
	
	public RetiradaUniforme(){}
	
	public int getIdRetiradaUniforme() {
		return idRetiradaUniforme;
	}
	public void setIdRetiradaUniforme(int idRetiradaUniforme) {
		this.idRetiradaUniforme = idRetiradaUniforme;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}	
}
