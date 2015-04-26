package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.Date;
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
			ficha.setFsFritura(rs.getString("fsFritura"));
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

	public int inserir(FichaDeAtendimento ficha) throws Exception{
		stmtScript = con.prepareStatement(
				"INSERT INTO fichadeatendimento ("
				+ "idAtleta, "
				+ "idUsuario, "
				+ "dtAtendimento, "
				+ "HMA, "
				+ "acompanhamentoAnterior, "
				+ "duracaoAcompanhamentoAnterior, "
				+ "HMF, "
				+ "flObesidade, "
				+ "flDiabetes, "
				+ "flHas, "
				+ "flDoencaCardiaca, "
				+ "flColesterol, "
				+ "flGastrite, "
				+ "flAzia, "
				+ "flDorAbdominal, "
				+ "habitoIntestinal, "
				+ "examesRecentes, "
				+ "medicamentos, "
				+ "tpPraticaAtividadeFisica, "
				+ "frequenciaAtividadeFisica, "
				+ "intensidadeAtividadeFisica, "
				+ "intoleranciaAlergiaAlimentar, "
				+ "alimentosGosta, "
				+ "alimentosNaoGosta, "
				+ "apetite, "
				+ "hrFomeEAlimentos, "
				+ "localDeRefeicaoEQuemCozinha, "
				+ "oleoPorMes, "
				+ "acucarPorMes, "
				+ "fsAmilacidos, "
				+ "fsFritura, "
				+ "fsFrutas, "
				+ "fsVerdSaladaLeg, "
				+ "fsCarnes, "
				+ "fsRefrigerante, "
				+ "fsBolachaChocBolo, "
				+ "fsLeiteIogurte,"
				+ "fsLeguminosas, "
				+ "fsBebidaAlcoolica, "
				+ "consumoLiquidos, "
				+ "aguaPorDia, "
				+ "outrosLiquidos, "
				+ "suplementoVitaminicoAlimentar, "
				+ "suplementoVitaminicoAlimentarInformacoes, "
				+ "recordatorioAlimentar, "
				+ "condutaNutricional) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		
		// `idAtleta`, `idUsuario`, `dtAtendimento`, `HMA`, `acompanhamentoAnterior`, `duracaoAcompanhamentoAnterior`, `HMF`, 
		stmtScript.setInt(1, ficha.getIdAtleta());
		stmtScript.setInt(2, ficha.getIdUsuario());
		stmtScript.setDate(3, new java.sql.Date(ficha.getDtAtendimento().getTime()));
		stmtScript.setString(4, ficha.getHMA());
		stmtScript.setString(5, ficha.getAcompanhamentoAnterior());
		stmtScript.setString(6, ficha.getDuracaoAcompanhamentoAnterior());
		stmtScript.setString(7, ficha.getHMF());
		// `flObesidade`, `flDiabetes`, `flHas`, `flDoencaCardiaca`, `flColesterol`, `flGastrite`, `flAzia`, `flDorAbdominal`, 
		stmtScript.setBoolean(8, ficha.getFlObesidade());
		stmtScript.setBoolean(9, ficha.getFlDiabetes());
		stmtScript.setBoolean(10, ficha.getFlHas());
		stmtScript.setBoolean(11, ficha.getFlDoencaCardiaca());
		stmtScript.setBoolean(12, ficha.getFlColesterol());
		stmtScript.setBoolean(13, ficha.getFlGastrite());
		stmtScript.setBoolean(14, ficha.getFlAzia());
		stmtScript.setBoolean(15, ficha.getFlDorAbdominal());
		//`habitoIntestinal`, `examesRecentes`, `medicamentos`, `tpPraticaAtividadeFisica`,
		stmtScript.setString(16, ficha.getHabitoIntestinal());
		stmtScript.setString(17, ficha.getExamesRecentes());
		stmtScript.setString(18, ficha.getMedicamentos());
		stmtScript.setString(19, ficha.getTpPraticaAtividadeFisica());
		//`frequenciaAtividadeFisica`, `intensidadeAtividadeFisica`,`intoleranciaAlergiaAlimentar`, `alimentosGosta`, 
		stmtScript.setString(20, ficha.getFrequenciaAtividadeFisica());
		stmtScript.setString(21, ficha.getIntensidadeAtividadeFisica());
		stmtScript.setString(22, ficha.getIntoleranciaAlergiaAlimentar());
		stmtScript.setString(23, ficha.getAlimentosGosta());
		//`alimentosNaoGosta`, `apetite`, `hrFomeEAlimentos`, `localDeRefeicaoEQuemCozinha`,
		stmtScript.setString(24, ficha.getAlimentosNaoGosta());
		stmtScript.setString(25, ficha.getApetite());
		stmtScript.setString(26, ficha.getHrFomeEAlimentos());
		stmtScript.setString(27, ficha.getLocalDeRefeicaoEQuemCozinha());
		//`oleoPorMes`, `acucarPorMes`, `fsAmilacidos`, `fsFritura`, `fsFrutas`, `fsVerdSaladaLeg`,
		stmtScript.setString(28, ficha.getOleoPorMes());
		stmtScript.setString(29, ficha.getAcucarPorMes());
		stmtScript.setString(30, ficha.getFsAmilacidos());
		stmtScript.setString(31, ficha.getFsFritura());
		stmtScript.setString(32, ficha.getFsFrutas());
		stmtScript.setString(33, ficha.getFsVerdSaladaLeg());
		//`fsCarnes`, `fsRefrigerante`, `fsBolachaChocBolo`, `fsLeiteIogurte`, `fsLeguminosas`, `fsBebidaAlcoolica`,
		stmtScript.setString(34, ficha.getFsCarnes());
		stmtScript.setString(35, ficha.getFsRefrigerante());
		stmtScript.setString(36, ficha.getFsBolachaChocBolo());
		stmtScript.setString(37, ficha.getFsLeiteIogurte());
		stmtScript.setString(38, ficha.getFsLeguminosas());
		stmtScript.setString(39, ficha.getFsBebidaAlcoolica());
		//`consumoLiquidos`, `aguaPorDia`, `outrosLiquidos`, `suplementoVitaminicoAlimentar`, `suplementoVitaminicoAlimentarInformacoes`, 
		//`recordatorioAlimentar`, `condutaNutricional` 
		stmtScript.setString(40, ficha.getConsumoLiquidos());
		stmtScript.setString(41, ficha.getAguaPorDia());
		stmtScript.setString(42, ficha.getOutrosLiquidos());
		stmtScript.setString(43, ficha.getSuplementoVitaminicoAlimentar());
		stmtScript.setString(44, ficha.getSuplementoVitaminicoAlimentarInformacoes());
		stmtScript.setString(45, ficha.getRecordatorioAlimentar());
		stmtScript.setString(46, ficha.getCondutaNutricional());
		
		stmtScript.executeUpdate();
		ResultSet rs = stmtScript.getGeneratedKeys();
		
		if(rs.next())
			return rs.getInt(1);
		else 
			return 0;
	}

}
