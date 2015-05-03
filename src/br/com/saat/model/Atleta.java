package br.com.saat.model;

import java.util.Date;
import java.util.List;

import br.com.saat.enumeradores.Equipes;
import br.com.saat.enumeradores.GrauParentesco;
import br.com.saat.enumeradores.Turno;

public class Atleta extends Pessoa {
	private int idTpEquipe;
	private String nrMatricula;
	private String nrCadFPT;
	private String nrCadCBT;
	private Date dtNascimento;
	private String RG;
	private String CPF;
	private String escola;
	private String serie;
	private int idTurno;
	private boolean acompPsicologico;
	private String nmMedicoResponsavel;
	private String telMedicoResponsavel;
	private String convenio;
	private String medicacaoAutorizada;
	private boolean flAlergias;
	private String dsAlergias;
	private boolean flMedicacao;
	private String dsMedicacao;
	private String nmContatoEmergencia;
	private String telContatoEmergencia;
	private int idGrauParentesco;
	private Date dtValidade;
	private Endereco endereco;
	private int flCadastroAtivo;
	private List<DiaTreino> listaDiasTreinos;
	private List<Responsavel> listaResponsaveis;
	private String dtNascimentoDisplay;
	private List<Documento> listaDocumentos;
	private boolean selecionado;
	private String colocacao;
	private String observacao;
	
	public Atleta(){}
	
	public Atleta(int idPessoa, String nome, String email,
			int idTpEquipe, String nrMatricula, String nrCadFPT,
			String nrCadCBT, Date dtNascimento, String RG, String CPF,
			String escola, String serie, int idTurno,
			boolean acompPsicologico, String nmMedicoResponsavel,
			String telMedicoResponsavel, String convenio,
			String medicacaoAutorizada, boolean flAlergias, String dsAlergias,
			boolean flMedicacao, String dsMedicacao,
			String nmContatoEmergencia, String telContatoEmergencia,
			int idGrauParentesco, Date dtValidade) {
		super(idPessoa, nome, email);
		this.idTpEquipe = idTpEquipe;
		this.nrMatricula = nrMatricula;
		this.nrCadFPT = nrCadFPT;
		this.nrCadCBT = nrCadCBT;
		this.dtNascimento = dtNascimento;
		this.RG = RG;
		this.CPF = CPF;
		this.escola = escola;
		this.serie = serie;
		this.idTurno = idTurno;
		this.acompPsicologico = acompPsicologico;
		this.nmMedicoResponsavel = nmMedicoResponsavel;
		this.telMedicoResponsavel = telMedicoResponsavel;
		this.convenio = convenio;
		this.medicacaoAutorizada = medicacaoAutorizada;
		this.flAlergias = flAlergias;
		this.dsAlergias = dsAlergias;
		this.flMedicacao = flMedicacao;
		this.dsMedicacao = dsMedicacao;
		this.nmContatoEmergencia = nmContatoEmergencia;
		this.telContatoEmergencia = telContatoEmergencia;
		this.idGrauParentesco = idGrauParentesco;
		this.dtValidade = dtValidade;
	}
	
	public int getIdTpEquipe() {
		return idTpEquipe;
	}
	public void setIdTpEquipe(int idTpEquipe) {
		this.idTpEquipe = idTpEquipe;
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
	public int getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
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
	public String getTelMedicoResponsavel() {
		return telMedicoResponsavel;
	}
	public void setTelMedicoResponsal(String telMedicoResponsavel) {
		this.telMedicoResponsavel = telMedicoResponsavel;
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
	public int getIdGrauParentesco() {
		return idGrauParentesco;
	}
	public void setIdGrauParentesco(
			int idGrauParentesco) {
		this.idGrauParentesco = idGrauParentesco;
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
	
	public String getNomeGrauParentesco(){
		String retorno = "";
		switch (this.idGrauParentesco) {
		case 1:
			retorno = GrauParentesco.Mae.getNome();
			break;
		case 2:
			retorno = GrauParentesco.Pai.getNome();
			break;
		case 3:
			retorno = GrauParentesco.Tio.getNome();
			break;
		case 4:
			retorno = GrauParentesco.Irmao.getNome();
			break;
		case 5:
			retorno = GrauParentesco.Avo.getNome();
			break;
		case 6:
			retorno = GrauParentesco.Outros.getNome();
			break;
		}
		return retorno;
	}
	
	public String getNomeTurno(){
		String retorno = "";
		switch (this.idTurno) {
		case 1:
			retorno = Turno.Manha.getNome();
			break;
		case 2:
			retorno = Turno.Tarde.getNome();
			break;
		case 3:
			retorno = Turno.Noite.getNome();
			break;
		case 4:
			retorno = Turno.Integral.getNome();
			break;
		}
		return retorno;
	}

	public List<DiaTreino> getListaDiasTreinos() {
		return listaDiasTreinos;
	}

	public void setListaDiasTreinos(List<DiaTreino> listaDiasTreinos) {
		this.listaDiasTreinos = listaDiasTreinos;
	}

	public List<Responsavel> getListaResponsaveis() {
		return listaResponsaveis;
	}

	public void setListaResponsaveis(List<Responsavel> listaResponsaveis) {
		this.listaResponsaveis = listaResponsaveis;
	}

	public int getFlCadastroAtivo() {
		return flCadastroAtivo;
	}

	public void setFlCadastroAtivo(int flCadastroAtivo) {
		this.flCadastroAtivo = flCadastroAtivo;
	}

	public String getDtNascimentoDisplay() {
		return dtNascimentoDisplay;
	}

	public void setDtNascimentoDisplay(String dtNascimentoDisplay) {
		this.dtNascimentoDisplay = dtNascimentoDisplay;
	}

	public void setTelMedicoResponsavel(String telMedicoResponsavel) {
		this.telMedicoResponsavel = telMedicoResponsavel;
	}

	public List<Documento> getListaDocumentos() {
		return listaDocumentos;
	}

	public void setListaDocumentos(List<Documento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}

	public String getStrIdade() {
		String strIdade = "";
		
		if(this.dtNascimento != null){
			Date dataNasc = this.dtNascimento;
			Date dataAtual = new Date(System.currentTimeMillis());

			int idadeAnos = dataAtual.getYear() - dataNasc.getYear();
			int idadeMeses = 0;
			if(dataAtual.getMonth() > dataNasc.getMonth()){
				idadeMeses = dataAtual.getMonth() - dataNasc.getMonth();
			}
			if(dataAtual.getMonth() < dataNasc.getMonth()){
				idadeAnos--;
				idadeMeses = (12 - dataNasc.getMonth()) + dataAtual.getMonth();
			}else{
				if(dataAtual.getDate() < dataNasc.getDate()){
					idadeAnos--;
					idadeMeses = 11;
				}						
			}
			
			strIdade = idadeAnos>0? (idadeAnos==1? "1 Ano" : idadeAnos + " Anos"):"";
			strIdade += idadeAnos>0&&idadeMeses>0? " e ":"";
			strIdade += idadeMeses>0? (idadeMeses==1? "1 Mês" : idadeMeses + " Meses") : "";
			
			return strIdade;
		}else
			return "Data de nascimento inválida";
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public String getColocacao() {
		return colocacao;
	}

	public void setColocacao(String colocacao) {
		this.colocacao = colocacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
	
}
