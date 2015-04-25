package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.saat.model.AvaliacaoAntropometrica;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.negocio.AvaliacaoAntropometricaNegocio;

public class FichaDeAtendimentoDAO {

	private Connection con;
	private PreparedStatement stmtScript;
	
	public FichaDeAtendimentoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public FichaDeAtendimentoDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public FichaDeAtendimento buscarUltimaFicha(int idAtleta) throws Exception{
		stmtScript = con.prepareStatement("SELECT * FROM fichadeatendimento WHERE idAtleta = ? ORDER BY dtAtendimento DESC LIMIT 1");
		stmtScript.setInt(1, idAtleta);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			FichaDeAtendimento ficha = new FichaDeAtendimento();
			ficha.setIdFichaDeAtendimento(rs.getInt("idFichaDeAtendimento"));
			ficha.setIdAtleta(idAtleta);
			ficha.setIdUsuario(rs.getInt("idUsuario"));
			ficha.setDtAtendimento(rs.getDate("dtAtendimento"));
			ficha.setIdAtleta(rs.getInt("idAtleta"));
			ficha.setIdUsuario(rs.getInt("idUsuario"));
			ficha.setHMA(rs.getString("HMA"));
			ficha.setAcompanhamentoAnterior(rs.getString("acompanhamentoAnterior"));
			ficha.setDuracaoAcompanhamentoAnterior(rs.getString("duracaoAcompanhamentoAnterior"));
			ficha.setHMF(rs.getString("HMF"));
			ficha.setFlObesidade(rs.getBoolean("flObesidade"));
			ficha.setFlDiabetes(rs.getBoolean("flDiabetes"));
			ficha.setFlHas(rs.getBoolean("flHas"));
			ficha.setFlDoencaCardiaca(rs.getBoolean("flDoencaCardiaca"));
			ficha.setFlColesterol(rs.getBoolean("flColesterol"));
			ficha.setFlGastrite(rs.getBoolean("flGastrite"));
			ficha.setFlAzia(rs.getBoolean("flAzia"));
			ficha.setFlDorAbdominal(rs.getBoolean("flDorAbdominal"));
			ficha.setHabitoIntestinal(rs.getString("habitoIntestinal"));
			ficha.setExamesRecentes(rs.getString("examesRecentes"));
			ficha.setMedicamentos(rs.getString("medicamentos"));
			ficha.setTpPraticaAtividadeFisica(rs.getString("tpPraticaAtividadeFisica"));
			ficha.setFrequenciaAtividadeFisica(rs.getString("frequenciaAtividadeFisica"));
			ficha.setIntensidadeAtividadeFisica(rs.getString("intensidadeAtividadeFisica"));
			ficha.setIntoleranciaAlergiaAlimentar(rs.getString("intoleranciaAlergiaAlimentar"));
			ficha.setAlimentosGosta(rs.getString("alimentosGosta"));
			ficha.setAlimentosNaoGosta(rs.getString("alimentosNaoGosta"));
			ficha.setApetite(rs.getString("apetite"));
			ficha.setHrFomeEAlimentos(rs.getString("hrFomeEAlimentos"));
			ficha.setLocalDeRefeicaoEQuemCozinha(rs.getString("localDeRefeicaoEQuemCozinha"));
			ficha.setOleoPorMes(rs.getString("oleoPorMes"));
			ficha.setAcucarPorMes(rs.getString("acucarPorMes"));
			ficha.setFsAmilacidos(rs.getString("fsAmilacidos"));
			ficha.setFsFrutas(rs.getString("fsFrutas"));
			ficha.setFsVerdSaladaLeg(rs.getString("fsVerdSaladaLeg"));
			ficha.setFsCarnes(rs.getString("fsCarnes"));
			ficha.setFsRefrigerante(rs.getString("fsRefrigerante"));
			ficha.setFsBolachaChocBolo(rs.getString("fsBolachaChocBolo"));
			ficha.setFsLeiteIogurte(rs.getString("fsLeiteIogurte"));
			ficha.setFsLeguminosas(rs.getString("fsLeguminosas"));
			ficha.setFsBebidaAlcoolica(rs.getString("fsBebidaAlcoolica"));
			ficha.setConsumoLiquidos(rs.getString("consumoLiquidos"));
			ficha.setAguaPorDia(rs.getString("aguaPorDia"));
			ficha.setOutrosLiquidos(rs.getString("outrosLiquidos"));
			ficha.setSuplementoVitaminicoAlimentar(rs.getString("suplementoVitaminicoAlimentar"));
			ficha.setSuplementoVitaminicoAlimentarInformacoes(rs.getString("suplementoVitaminicoAlimentarInformacoes"));
			ficha.setRecordatorioAlimentar(rs.getString("recordatorioAlimentar"));
			ficha.setCondutaNutricional(rs.getString("condutaNutricional"));
			
			//busca a Avaliação Antropométrica relacionada a Ficha
			try{
				AvaliacaoAntropometrica avaliacao = null;
				AvaliacaoAntropometricaNegocio avaliacaoNegocio =  new AvaliacaoAntropometricaNegocio();
				avaliacao = avaliacaoNegocio.buscarAvaliacao(ficha.getIdFichaDeAtendimento());
				ficha.setAvaliacaoAntropometrica(avaliacao);
				
			}catch(Exception ex){
				throw ex;
			}
			
			return ficha;
		}else
			return null;
	}

}
