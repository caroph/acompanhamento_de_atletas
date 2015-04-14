package br.com.saat.model;

import java.util.Date;

public class DiaTreino {
	public int idDiaTreino;
	public int idTpEquipe;
	public int idDiaSemana;
	public Date hrInicio;
	public Date hrFim;
	public String hrInicioDisplay;
	public String hrFimDisplay;
	public boolean selecionado;
	
	public DiaTreino(){
		this.selecionado = false;
	}
	
	public DiaTreino(int idDiaTreino){
		this.idDiaTreino = idDiaTreino;
		this.selecionado = false;
	}
	
	public DiaTreino(int idDiaTreino, int idTpEquipe, int idDiaSemana,
			Date hrInicio, Date hrFim) {
		super();
		this.idDiaTreino = idDiaTreino;
		this.idTpEquipe = idTpEquipe;
		this.idDiaSemana = idDiaSemana;
		this.hrInicio = hrInicio;
		this.hrFim = hrFim;
		this.selecionado = false;
	}
	
	public int getIdDiaTreino() {
		return idDiaTreino;
	}
	public void setIdDiaTreino(int idDiaTreino) {
		this.idDiaTreino = idDiaTreino;
	}
	public int getIdTpEquipe() {
		return idTpEquipe;
	}
	public void setIdTpEquipe(int idTpEquipe) {
		this.idTpEquipe = idTpEquipe;
	}
	public int getIdDiaSemana() {
		return idDiaSemana;
	}
	public void setIdDiaDaSemana(int idDiaSemana) {
		this.idDiaSemana = idDiaSemana;
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
	
	public String getNomeEquipe(){
		String retorno = "";
		switch(this.idTpEquipe){
			case 1:
				retorno = Equipes.Equipe.getNome();
				break;
			case 2:
				retorno = Equipes.PreEquipe.getNome();
				break;
		}
		return retorno;
	}
	
	public String getNomeDiaSemana(){
		String retorno = "";
		switch (this.idDiaSemana) {
		case 1:
			retorno = DiasSemana.Domingo.getNome();
			break;
		case 2:
			retorno = DiasSemana.Segunda.getNome();
			break;
		case 3:
			retorno = DiasSemana.Terca.getNome();
			break;
		case 4:
			retorno = DiasSemana.Quarta.getNome();
			break;
		case 5:
			retorno = DiasSemana.Quinta.getNome();
			break;
		case 6:
			retorno = DiasSemana.Sexta.getNome();
			break;
		case 7:
			retorno = DiasSemana.Sabado.getNome();
			break;
		}
		return retorno;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public String getHrInicioDisplay() {
		return hrInicioDisplay;
	}

	public void setHrInicioDisplay(String hrInicioDisplay) {
		this.hrInicioDisplay = hrInicioDisplay;
	}

	public String getHrFimDisplay() {
		return hrFimDisplay;
	}

	public void setHrFimDisplay(String hrFimDisplay) {
		this.hrFimDisplay = hrFimDisplay;
	}
		
}
