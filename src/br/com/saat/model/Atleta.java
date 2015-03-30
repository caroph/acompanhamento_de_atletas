package br.com.saat.model;

import java.util.Date;

public class Atleta extends Pessoa {
	private int tpEquipe;
	private String nrMatricula;
	private String nrCadFPT;
	private String nrCadCBT;
	private Date dtNascimento;
	private String RG;
	private String CPF;
	private String escola;
	private String serie;
	private String turno;
	private boolean acompPsicologico;
	private String nmMedicoResponsavel;
	private String telMedicoResponsal;
	private String convenio;
	private String medicacaoAutorizada;
	private boolean flAlergias;
	private String dsAlergias;
	private boolean flMedicacao;
	private String dsMedicacao;
	private String nmContatoEmergencia;
	private String telContatoEmergencia;
	private String grauParentescoContatoEmergencia;
	private Date dtValidade;
	private Endereco endereco;
	
	public Atleta(){}
	
	public Atleta(int idPessoa, String nome, String email,
			int tpEquipe, String nrMatricula, String nrCadFPT,
			String nrCadCBT, Date dtNascimento, String RG, String CPF,
			String escola, String serie, String turno,
			boolean acompPsicologico, String nmMedicoResponsavel,
			String telMedicoResponsal, String convenio,
			String medicacaoAutorizada, boolean flAlergias, String dsAlergias,
			boolean flMedicacao, String dsMedicacao,
			String nmContatoEmergencia, String telContatoEmergencia,
			String grauParentescoContatoEmergencia, Date dtValidade) {
		super(idPessoa, nome, email);
		this.tpEquipe = tpEquipe;
		this.nrMatricula = nrMatricula;
		this.nrCadFPT = nrCadFPT;
		this.nrCadCBT = nrCadCBT;
		this.dtNascimento = dtNascimento;
		this.RG = RG;
		this.CPF = CPF;
		this.escola = escola;
		this.serie = serie;
		this.turno = turno;
		this.acompPsicologico = acompPsicologico;
		this.nmMedicoResponsavel = nmMedicoResponsavel;
		this.telMedicoResponsal = telMedicoResponsal;
		this.convenio = convenio;
		this.medicacaoAutorizada = medicacaoAutorizada;
		this.flAlergias = flAlergias;
		this.dsAlergias = dsAlergias;
		this.flMedicacao = flMedicacao;
		this.dsMedicacao = dsMedicacao;
		this.nmContatoEmergencia = nmContatoEmergencia;
		this.telContatoEmergencia = telContatoEmergencia;
		this.grauParentescoContatoEmergencia = grauParentescoContatoEmergencia;
		this.dtValidade = dtValidade;
	}
	public int getTpEquipe() {
		return tpEquipe;
	}
	public void setTpEquipe(int tpEquipe) {
		this.tpEquipe = tpEquipe;
	}
	public String getNrMatricula() {
		return nrMatricula;
	}
	public void setNrMatricula(String nrMatricula) {
		this.nrMatricula = nrMatricula;
	}
	public String getNrCadFPT() {
		return nrCadFPT;
	}
	public void setNrCadFPT(String nrCadFPT) {
		this.nrCadFPT = nrCadFPT;
	}
	public String getNrCadCBT() {
		return nrCadCBT;
	}
	public void setNrCadCBT(String nrCadCBT) {
		this.nrCadCBT = nrCadCBT;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String RG) {
		this.RG = RG;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean isAcompPsicologico() {
		return acompPsicologico;
	}
	public void setAcompPsicologico(boolean acompPsicologico) {
		this.acompPsicologico = acompPsicologico;
	}
	public String getNmMedicoResponsavel() {
		return nmMedicoResponsavel;
	}
	public void setNmMedicoResponsavel(String nmMedicoResponsavel) {
		this.nmMedicoResponsavel = nmMedicoResponsavel;
	}
	public String getTelMedicoResponsal() {
		return telMedicoResponsal;
	}
	public void setTelMedicoResponsal(String telMedicoResponsal) {
		this.telMedicoResponsal = telMedicoResponsal;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public String getMedicacaoAutorizada() {
		return medicacaoAutorizada;
	}
	public void setMedicacaoAutorizada(String medicacaoAutorizada) {
		this.medicacaoAutorizada = medicacaoAutorizada;
	}
	public boolean isFlAlergias() {
		return flAlergias;
	}
	public void setFlAlergias(boolean flAlergias) {
		this.flAlergias = flAlergias;
	}
	public String getDsAlergias() {
		return dsAlergias;
	}
	public void setDsAlergias(String dsAlergias) {
		this.dsAlergias = dsAlergias;
	}
	public boolean isFlMedicacao() {
		return flMedicacao;
	}
	public void setFlMedicacao(boolean flMedicacao) {
		this.flMedicacao = flMedicacao;
	}
	public String getDsMedicacao() {
		return dsMedicacao;
	}
	public void setDsMedicacao(String dsMedicacao) {
		this.dsMedicacao = dsMedicacao;
	}
	public String getNmContatoEmergencia() {
		return nmContatoEmergencia;
	}
	public void setNmContatoEmergencia(String nmContatoEmergencia) {
		this.nmContatoEmergencia = nmContatoEmergencia;
	}
	public String getTelContatoEmergencia() {
		return telContatoEmergencia;
	}
	public void setTelContatoEmergencia(String telContatoEmergencia) {
		this.telContatoEmergencia = telContatoEmergencia;
	}
	public String getGrauParentescoContatoEmergencia() {
		return grauParentescoContatoEmergencia;
	}
	public void setGrauParentescoContatoEmergencia(
			String grauParentescoContatoEmergencia) {
		this.grauParentescoContatoEmergencia = grauParentescoContatoEmergencia;
	}
	public Date getDtValidade() {
		return dtValidade;
	}
	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
