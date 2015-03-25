package br.com.saat.model;

import java.util.Date;

public class DiaTreino {
	public int idDiaTreino;
	public int tpEquipe;
	public String dsTpEquipe;
	public int diaSemana;
	public String dsDiaSemana;
	public Date hrInicio;
	public Date hrFim;
	
	public DiaTreino(){}
	
	public DiaTreino(int idDiaTreino){
		this.idDiaTreino = idDiaTreino;
	}
	
	public DiaTreino(int idDiaTreino, int tpEquipe, int diaSemana,
			Date hrInicio, Date hrFim) {
		super();
		this.idDiaTreino = idDiaTreino;
		this.tpEquipe = tpEquipe;
		this.diaSemana = diaSemana;
		this.hrInicio = hrInicio;
		this.hrFim = hrFim;
	}
	
	public int getIdDiaTreino() {
		return idDiaTreino;
	}
	public void setIdDiaTreino(int idDiaTreino) {
		this.idDiaTreino = idDiaTreino;
	}
	public int getTpEquipe() {
		return tpEquipe;
	}
	public void setTpEquipe(int tpEquipe) {
		this.tpEquipe = tpEquipe;
	}
	public int getDiaSemana() {
		return diaSemana;
	}
	public void setDiaDaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Date getHrInicio() {
		return hrInicio;
	}
	public void setHrInicio(Date hrInicio) {
		this.hrInicio = hrInicio;
	}
	public Date getHrFim() {
		return hrFim;
	}
	public void setHrFim(Date hrFim) {
		this.hrFim = hrFim;
	}

	public String getDsTpEquipe() {
		return dsTpEquipe;
	}

	public void setDsTpEquipe(String dsTpEquipe) {
		this.dsTpEquipe = dsTpEquipe;
	}

	public String getDsDiaSemana() {
		return dsDiaSemana;
	}

	public void setDsDiaSemana(String dsDiaSemana) {
		this.dsDiaSemana = dsDiaSemana;
	}
	
}
