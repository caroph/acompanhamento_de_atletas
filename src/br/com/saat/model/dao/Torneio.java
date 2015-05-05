package br.com.saat.model.dao;

import java.util.Date;

import br.com.saat.enumeradores.CatTorneio;
import br.com.saat.enumeradores.GpTorneio;
import br.com.saat.enumeradores.Naipe;
import br.com.saat.enumeradores.TpTorneio;
import br.com.saat.model.Atleta;

public class Torneio {
	private int idTorneio;
	private String nome;
	private String local;
	private String estado;
	private String cidade;
	private Date dtInicial;
	private Date dtFinal;
	private int idNaipe;
	private int idCatTorneio;
	private int idTpTorneio;
	private int idGpTorneio;
	private String descricao;
	private int inscritosGeral;
	private int inscritosClube;
	private Atleta idDestaque;
	private String motivoDestaque;
	private String fotografo;
	private Date encaminhamentoMkt;
	private boolean flFinalizado;
	
	public int getIdTorneio() {
		return idTorneio;
	}
	public void setIdTorneio(int idTorneio) {
		this.idTorneio = idTorneio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Date getDtInicial() {
		return dtInicial;
	}
	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}
	public Date getDtFinal() {
		return dtFinal;
	}
	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}
	public int getIdNaipe() {
		return idNaipe;
	}
	public void setIdNaipe(int idNaipe) {
		this.idNaipe = idNaipe;
	}
	public int getIdCatTorneio() {
		return idCatTorneio;
	}
	public void setIdCatTorneio(int idCatTorneio) {
		this.idCatTorneio = idCatTorneio;
	}
	public int getIdTpTorneio() {
		return idTpTorneio;
	}
	public void setIdTpTorneio(int idTpTorneio) {
		this.idTpTorneio = idTpTorneio;
	}
	public int getIdGpTorneio() {
		return idGpTorneio;
	}
	public void setIdGpTorneio(int idGpTorneio) {
		this.idGpTorneio = idGpTorneio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getInscritosGeral() {
		return inscritosGeral;
	}
	public void setInscritosGeral(int inscritosGeral) {
		this.inscritosGeral = inscritosGeral;
	}
	public int getInscritosClube() {
		return inscritosClube;
	}
	public void setInscritosClube(int inscritosClube) {
		this.inscritosClube = inscritosClube;
	}
	public Atleta getIdDestaque() {
		return idDestaque;
	}
	public void setIdDestaque(Atleta idDestaque) {
		this.idDestaque = idDestaque;
	}
	public String getMotivoDestaque() {
		return motivoDestaque;
	}
	public void setMotivoDestaque(String motivoDestaque) {
		this.motivoDestaque = motivoDestaque;
	}
	public String getFotografo() {
		return fotografo;
	}
	public void setFotografo(String fotografo) {
		this.fotografo = fotografo;
	}
	public Date getEncaminhamentoMkt() {
		return encaminhamentoMkt;
	}
	public void setEncaminhamentoMkt(Date encaminhamentoMkt) {
		this.encaminhamentoMkt = encaminhamentoMkt;
	}
	public String getNomeNaipe(){
		String retorno = "";
		switch (this.idNaipe) {
		case 1:
			retorno = Naipe.Feminino.getNome();
			break;
		case 2:
			retorno = Naipe.Masculino.getNome();
			break;
		case 3:
			retorno = Naipe.Unisex.getNome();
			break;
		}
		return retorno;
	}
	
	public String getNomeCategoria(){
		String retorno = "";
		switch (this.idCatTorneio) {
		case 1:
			retorno = CatTorneio.Classes.getNome();
			break;
		case 2:
			retorno = CatTorneio.Infanto_Juvenil.getNome();
			break;
		case 3:
			retorno = CatTorneio.Intercambio.getNome();
			break;
		case 4:
			retorno = CatTorneio.Interno.getNome();
			break;
		}
		return retorno;
	}
	
	public String getNomeTipo(){
		String retorno = "";
		switch (this.idTpTorneio) {
		case 1:
			retorno = TpTorneio.CBT.getNome();
			break;
		case 2:
			retorno = TpTorneio.FPT.getNome();
			break;
		case 3:
			retorno = TpTorneio.ITF.getNome();
			break;
		}
		return retorno;
	}
	
	public String getNomeGrupo(){
		String retorno = "";
		switch (this.idGpTorneio) {
		case 1:
			retorno = GpTorneio.GA.getNome();
			break;
		case 2:
			retorno = GpTorneio.GI.getNome();
			break;
		case 3:
			retorno = GpTorneio.GII.getNome();
			break;
		case 4:
			retorno = GpTorneio.GIII.getNome();
			break;
		case 5:
			retorno = GpTorneio.GIV.getNome();
			break;
		case 6:
			retorno = GpTorneio.GV.getNome();
			break;
		}
		return retorno;
	}
	public boolean isFlFinalizado() {
		return flFinalizado;
	}
	public void setFlFinalizado(boolean flFinalizado) {
		this.flFinalizado = flFinalizado;
	}
}
