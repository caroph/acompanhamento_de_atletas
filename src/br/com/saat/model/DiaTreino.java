package br.com.saat.model;

import java.util.Date;

public class DiaTreino {
	public int idDiaDeTreino;
	public int tpEquipe;
	public String dsTpEquipe;
	public int diaDaSemana;
	public String dsDiaSemana;
	public Date hrInicio;
	public Date hrFim;
	
	public DiaTreino(){}
	
	public DiaTreino(int idDiaDeTreino, int tpEquipe, int diaDaSemana,
			Date hrInicio, Date hrFim) {
		super();
		this.idDiaDeTreino = idDiaDeTreino;
		this.tpEquipe = tpEquipe;
		this.diaDaSemana = diaDaSemana;
		this.hrInicio = hrInicio;
		this.hrFim = hrFim;
	}
	
	public int getIdDiaDeTreino() {
		return idDiaDeTreino;
	}
	public void setIdDiaDeTreino(int idDiaDeTreino) {
		this.idDiaDeTreino = idDiaDeTreino;
	}
	public int getTpEquipe() {
		return tpEquipe;
	}
	public void setTpEquipe(int tpEquipe) {
		this.tpEquipe = tpEquipe;
	}
	public int getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(int diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
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
