package br.com.saat.model;

import java.util.Date;

import br.com.saat.enumeradores.Refeicao;

public class Dieta {
	private int idDieta;
	private Atleta atleta;
	private Usuario usuario;
	private int refeicao;
	private boolean competicao;
	private Date dtValidadeInicio;
	private Date dtValidadeFim;
	private String descricao;
	private String dtValidadeInicioDisplay;
	private String dtValidadeFimDisplay;
	
	public int getIdDieta() {
		return idDieta;
	}
	public void setIdDieta(int idDieta) {
		this.idDieta = idDieta;
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
	public int getRefeicao() {
		return refeicao;
	}
	public void setRefeicao(int refeicao) {
		this.refeicao = refeicao;
	}
	public boolean isCompeticao() {
		return competicao;
	}
	public void setCompeticao(boolean competicao) {
		this.competicao = competicao;
	}
	public Date getDtValidadeInicio() {
		return dtValidadeInicio;
	}
	public void setDtValidadeInicio(Date dtValidadeInicio) {
		this.dtValidadeInicio = dtValidadeInicio;
	}
	public Date getDtValidadeFim() {
		return dtValidadeFim;
	}
	public void setDtValidadeFim(Date dtValidadeFim) {
		this.dtValidadeFim = dtValidadeFim;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDtValidadeInicioDisplay() {
		return dtValidadeInicioDisplay;
	}
	public void setDtValidadeInicioDisplay(String dtValidadeInicioDisplay) {
		this.dtValidadeInicioDisplay = dtValidadeInicioDisplay;
	}
	public String getDtValidadeFimDisplay() {
		return dtValidadeFimDisplay;
	}
	public void setDtValidadeFimDisplay(String dtValidadeFimDisplay) {
		this.dtValidadeFimDisplay = dtValidadeFimDisplay;
	}

	public String getNomeRefeicao(){
		String retorno = "";
		switch (this.refeicao) {
		case 1:
			retorno = Refeicao.Desjejum.getNome();
			break;
		case 2:
			retorno = Refeicao.Lanche_Manha.getNome();
			break;
		case 3:
			retorno = Refeicao.Pre_Treino_Manha.getNome();
			break;
		case 4:
			retorno = Refeicao.Pos_Treino_Manha.getNome();
			break;
		case 5:
			retorno = Refeicao.Pos_Fisico_Manha.getNome();
			break;
		case 6:
			retorno = Refeicao.Almoco.getNome();
			break;
		case 7:
			retorno = Refeicao.Lanche_Tarde.getNome();
			break;
		case 8:
			retorno = Refeicao.Pre_Treino_Tarde.getNome();
			break;
		case 9:
			retorno = Refeicao.Pos_Treino_Tarde.getNome();
			break;
		case 10:
			retorno = Refeicao.Pos_Fisico_Tarde.getNome();
			break;
		case 11:
			retorno = Refeicao.Janta.getNome();
			break;
		case 12:
			retorno = Refeicao.Ceia.getNome();
			break;
		case 13:
			retorno = Refeicao.Pre_Treino_Noite.getNome();
			break;
		case 14:
			retorno = Refeicao.Pos_Treino_Noite.getNome();
			break;
		case 15:
			retorno = Refeicao.Pos_Fisico_Noite.getNome();
			break;
		}
		return retorno;
	}
}
