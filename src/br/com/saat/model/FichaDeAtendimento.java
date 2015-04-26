package br.com.saat.model;

import java.util.Date;

public class FichaDeAtendimento {
	private int idFichaDeAtendimento;
	private int idAtleta;
	private int idUsuario;
	private AvaliacaoAntropometrica avaliacaoAntropometrica;
	private Date dtAtendimento;
	private String HMA;
	private String acompanhamentoAnterior;
	private String duracaoAcompanhamentoAnterior;
	private String HMF;
	private boolean flObesidade;
	private boolean flDiabetes;
	private boolean flHas;
	private boolean flDoencaCardiaca;
	private boolean flColesterol;
	private boolean flGastrite;
	private boolean flAzia;
	private boolean flDorAbdominal;
	private String habitoIntestinal;
	private String examesRecentes;
	private String medicamentos;
	private String tpPraticaAtividadeFisica;
	private String frequenciaAtividadeFisica;
	private String intensidadeAtividadeFisica;
	private String intoleranciaAlergiaAlimentar;
	private String alimentosGosta;
	private String alimentosNaoGosta;
	private String apetite;
	private String hrFomeEAlimentos;
	private String localDeRefeicaoEQuemCozinha;
	private String oleoPorMes;
	private String acucarPorMes;
	private String fsAmilacidos;
	private String fsFritura;
	private String fsFrutas;
	private String fsVerdSaladaLeg;
	private String fsCarnes;
	private String fsRefrigerante;
	private String fsBolachaChocBolo;
	private String fsLeiteIogurte;
	private String fsLeguminosas;
	private String fsBebidaAlcoolica;
	private String consumoLiquidos;
	private String aguaPorDia;
	private String outrosLiquidos;
	private String suplementoVitaminicoAlimentar;
	private String suplementoVitaminicoAlimentarInformacoes;
	private String recordatorioAlimentar;
	private String condutaNutricional;
		
	public String getFsFritura() {
		return fsFritura;
	}
	public void setFsFritura(String fsFritura) {
		this.fsFritura = fsFritura;
	}
	public int getIdFichaDeAtendimento() {
		return idFichaDeAtendimento;
	}
	public void setIdFichaDeAtendimento(int idFichaDeAtendimento) {
		this.idFichaDeAtendimento = idFichaDeAtendimento;
	}
	public int getIdAtleta() {
		return idAtleta;
	}
	public void setIdAtleta(int idAtleta) {
		this.idAtleta = idAtleta;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public AvaliacaoAntropometrica getAvaliacaoAntropometrica() {
		return avaliacaoAntropometrica;
	}
	public void setAvaliacaoAntropometrica(AvaliacaoAntropometrica avaliacaoAntropometrica) {
		this.avaliacaoAntropometrica = avaliacaoAntropometrica;
	}
	public Date getDtAtendimento() {
		return dtAtendimento;
	}
	public void setDtAtendimento(Date dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}
	public String getHMA() {
		return HMA;
	}
	public void setHMA(String hMA) {
		HMA = hMA;
	}
	public String getAcompanhamentoAnterior() {
		return acompanhamentoAnterior;
	}
	public void setAcompanhamentoAnterior(String acompanhamentoAnterior) {
		this.acompanhamentoAnterior = acompanhamentoAnterior;
	}
	public String getDuracaoAcompanhamentoAnterior() {
		return duracaoAcompanhamentoAnterior;
	}
	public void setDuracaoAcompanhamentoAnterior(
			String duracaoAcompanhamentoAnterior) {
		this.duracaoAcompanhamentoAnterior = duracaoAcompanhamentoAnterior;
	}
	public String getHMF() {
		return HMF;
	}
	public void setHMF(String hMF) {
		HMF = hMF;
	}
	public boolean getFlObesidade() {
		return flObesidade;
	}
	public void setFlObesidade(boolean flObesidade) {
		this.flObesidade = flObesidade;
	}
	public boolean getFlDiabetes() {
		return flDiabetes;
	}
	public void setFlDiabetes(boolean flDiabetes) {
		this.flDiabetes = flDiabetes;
	}
	public boolean getFlHas() {
		return flHas;
	}
	public void setFlHas(boolean flHas) {
		this.flHas = flHas;
	}
	public boolean getFlDoencaCardiaca() {
		return flDoencaCardiaca;
	}
	public void setFlDoencaCardiaca(boolean flDoencaCardiaca) {
		this.flDoencaCardiaca = flDoencaCardiaca;
	}
	public boolean getFlColesterol() {
		return flColesterol;
	}
	public void setFlColesterol(boolean flColesterol) {
		this.flColesterol = flColesterol;
	}
	public boolean getFlGastrite() {
		return flGastrite;
	}
	public void setFlGastrite(boolean flGastrite) {
		this.flGastrite = flGastrite;
	}
	public boolean getFlAzia() {
		return flAzia;
	}
	public void setFlAzia(boolean flAzia) {
		this.flAzia = flAzia;
	}
	public boolean getFlDorAbdominal() {
		return flDorAbdominal;
	}
	public void setFlDorAbdominal(boolean flDorAbdominal) {
		this.flDorAbdominal = flDorAbdominal;
	}
	public String getHabitoIntestinal() {
		return habitoIntestinal;
	}
	public void setHabitoIntestinal(String habitoIntestinal) {
		this.habitoIntestinal = habitoIntestinal;
	}
	public String getExamesRecentes() {
		return examesRecentes;
	}
	public void setExamesRecentes(String examesRecentes) {
		this.examesRecentes = examesRecentes;
	}
	public String getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	public String getTpPraticaAtividadeFisica() {
		return tpPraticaAtividadeFisica;
	}
	public void setTpPraticaAtividadeFisica(String tpPraticaAtividadeFisica) {
		this.tpPraticaAtividadeFisica = tpPraticaAtividadeFisica;
	}
	public String getFrequenciaAtividadeFisica() {
		return frequenciaAtividadeFisica;
	}
	public void setFrequenciaAtividadeFisica(String frequenciaAtividadeFisica) {
		this.frequenciaAtividadeFisica = frequenciaAtividadeFisica;
	}
	public String getIntensidadeAtividadeFisica() {
		return intensidadeAtividadeFisica;
	}
	public void setIntensidadeAtividadeFisica(String intensidadeAtividadeFisica) {
		this.intensidadeAtividadeFisica = intensidadeAtividadeFisica;
	}
	public String getIntoleranciaAlergiaAlimentar() {
		return intoleranciaAlergiaAlimentar;
	}
	public void setIntoleranciaAlergiaAlimentar(String intoleranciaAlergiaAlimentar) {
		this.intoleranciaAlergiaAlimentar = intoleranciaAlergiaAlimentar;
	}
	public String getAlimentosGosta() {
		return alimentosGosta;
	}
	public void setAlimentosGosta(String alimentosGosta) {
		this.alimentosGosta = alimentosGosta;
	}
	public String getAlimentosNaoGosta() {
		return alimentosNaoGosta;
	}
	public void setAlimentosNaoGosta(String alimentosNaoGosta) {
		this.alimentosNaoGosta = alimentosNaoGosta;
	}
	public String getApetite() {
		return apetite;
	}
	public void setApetite(String apetite) {
		this.apetite = apetite;
	}
	public String getHrFomeEAlimentos() {
		return hrFomeEAlimentos;
	}
	public void setHrFomeEAlimentos(String hrFomeEAlimentos) {
		this.hrFomeEAlimentos = hrFomeEAlimentos;
	}
	public String getLocalDeRefeicaoEQuemCozinha() {
		return localDeRefeicaoEQuemCozinha;
	}
	public void setLocalDeRefeicaoEQuemCozinha(String localDeRefeicaoEQuemCozinha) {
		this.localDeRefeicaoEQuemCozinha = localDeRefeicaoEQuemCozinha;
	}
	public String getOleoPorMes() {
		return oleoPorMes;
	}
	public void setOleoPorMes(String oleoPorMes) {
		this.oleoPorMes = oleoPorMes;
	}
	public String getAcucarPorMes() {
		return acucarPorMes;
	}
	public void setAcucarPorMes(String acucarPorMes) {
		this.acucarPorMes = acucarPorMes;
	}
	public String getFsAmilacidos() {
		return fsAmilacidos;
	}
	public void setFsAmilacidos(String fsAmilacidos) {
		this.fsAmilacidos = fsAmilacidos;
	}
	public String getFsFrutas() {
		return fsFrutas;
	}
	public void setFsFrutas(String fsFrutas) {
		this.fsFrutas = fsFrutas;
	}
	public String getFsVerdSaladaLeg() {
		return fsVerdSaladaLeg;
	}
	public void setFsVerdSaladaLeg(String fsVerdSaladaLeg) {
		this.fsVerdSaladaLeg = fsVerdSaladaLeg;
	}
	public String getFsCarnes() {
		return fsCarnes;
	}
	public void setFsCarnes(String fsCarnes) {
		this.fsCarnes = fsCarnes;
	}
	public String getFsRefrigerante() {
		return fsRefrigerante;
	}
	public void setFsRefrigerante(String fsRefrigerante) {
		this.fsRefrigerante = fsRefrigerante;
	}
	public String getFsBolachaChocBolo() {
		return fsBolachaChocBolo;
	}
	public void setFsBolachaChocBolo(String fsBolachaChocBolo) {
		this.fsBolachaChocBolo = fsBolachaChocBolo;
	}
	public String getFsLeiteIogurte() {
		return fsLeiteIogurte;
	}
	public void setFsLeiteIogurte(String fsLeiteIogurte) {
		this.fsLeiteIogurte = fsLeiteIogurte;
	}
	public String getFsLeguminosas() {
		return fsLeguminosas;
	}
	public void setFsLeguminosas(String fsLeguminosas) {
		this.fsLeguminosas = fsLeguminosas;
	}
	public String getFsBebidaAlcoolica() {
		return fsBebidaAlcoolica;
	}
	public void setFsBebidaAlcoolica(String fsBebidaAlcoolica) {
		this.fsBebidaAlcoolica = fsBebidaAlcoolica;
	}
	public String getConsumoLiquidos() {
		return consumoLiquidos;
	}
	public void setConsumoLiquidos(String consumoLiquidos) {
		this.consumoLiquidos = consumoLiquidos;
	}
	public String getAguaPorDia() {
		return aguaPorDia;
	}
	public void setAguaPorDia(String aguaPorDia) {
		this.aguaPorDia = aguaPorDia;
	}
	public String getOutrosLiquidos() {
		return outrosLiquidos;
	}
	public void setOutrosLiquidos(String outrosLiquidos) {
		this.outrosLiquidos = outrosLiquidos;
	}
	public String getSuplementoVitaminicoAlimentar() {
		return suplementoVitaminicoAlimentar;
	}
	public void setSuplementoVitaminicoAlimentar(
			String suplementoVitaminicoAlimentar) {
		this.suplementoVitaminicoAlimentar = suplementoVitaminicoAlimentar;
	}
	public String getSuplementoVitaminicoAlimentarInformacoes() {
		return suplementoVitaminicoAlimentarInformacoes;
	}
	public void setSuplementoVitaminicoAlimentarInformacoes(
			String suplementoVitaminicoAlimentarInformacoes) {
		this.suplementoVitaminicoAlimentarInformacoes = suplementoVitaminicoAlimentarInformacoes;
	}
	public String getRecordatorioAlimentar() {
		return recordatorioAlimentar;
	}
	public void setRecordatorioAlimentar(String recordatorioAlimentar) {
		this.recordatorioAlimentar = recordatorioAlimentar;
	}
	public String getCondutaNutricional() {
		return condutaNutricional;
	}
	public void setCondutaNutricional(String condutaNutricional) {
		this.condutaNutricional = condutaNutricional;
	}	
}
