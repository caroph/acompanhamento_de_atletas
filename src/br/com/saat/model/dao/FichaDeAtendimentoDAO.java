package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import br.com.saat.model.AvaliacaoAntropometrica;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.negocio.AvaliacaoAntropometricaNegocio;

import com.mysql.jdbc.Statement;

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
			ficha.setDtAtendimento(rs.getTimestamp("dtAtendimento"));
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
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
				, Statement.RETURN_GENERATED_KEYS);
		
		
		// `idAtleta`, `idUsuario`, `dtAtendimento`, `HMA`, `acompanhamentoAnterior`, `duracaoAcompanhamentoAnterior`, `HMF`, 
		stmtScript.setInt(1, ficha.getIdAtleta());
		stmtScript.setInt(2, ficha.getIdUsuario());
		stmtScript.setTimestamp(3, new Timestamp(ficha.getDtAtendimento() != null ? ficha.getDtAtendimento().getTime() : System.currentTimeMillis()));
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

	public HashMap<Integer, java.util.Date> buscarHistoricoAtendimento(int idAtleta) throws Exception{

		HashMap<Integer, java.util.Date> listaAtendimentos = new HashMap<Integer, java.util.Date>();
		stmtScript = con.prepareStatement("SELECT idFichaDeAtendimento, dtAtendimento FROM fichadeatendimento WHERE idAtleta = ? ORDER BY dtAtendimento DESC");
		stmtScript.setInt(1, idAtleta);
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next())
			listaAtendimentos.put(rs.getInt("idFichaDeAtendimento"), rs.getTimestamp("dtAtendimento"));
		
		return listaAtendimentos;
	}

	public FichaDeAtendimento buscarPorId(int idFichaDeAtendimento) throws Exception {
		stmtScript = con.prepareStatement("SELECT * FROM fichadeatendimento WHERE idFichaDeAtendimento = ?");
		stmtScript.setInt(1, idFichaDeAtendimento);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			FichaDeAtendimento ficha = new FichaDeAtendimento();
			ficha.setIdFichaDeAtendimento(idFichaDeAtendimento);
			ficha.setIdAtleta(rs.getInt("idAtleta"));
			ficha.setIdUsuario(rs.getInt("idUsuario"));
			ficha.setDtAtendimento(rs.getTimestamp("dtAtendimento"));
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
		}else{
			throw new Exception("idFichaDeAtendimento inválido!");
		}
	}

	public boolean alterar(FichaDeAtendimento ficha) throws Exception {
		stmtScript = con.prepareStatement(
				"UPDATE fichadeatendimento SET "
				+ "idAtleta = ?, "
				+ "idUsuario = ?, "
				+ "HMA = ?, "
				+ "acompanhamentoAnterior = ?, "
				+ "duracaoAcompanhamentoAnterior = ?, "
				+ "HMF = ?, "
				+ "flObesidade = ?, "
				+ "flDiabetes = ?, "
				+ "flHas = ?, "
				+ "flDoencaCardiaca = ?, "
				+ "flColesterol = ?, "
				+ "flGastrite = ?, "
				+ "flAzia = ?, "
				+ "flDorAbdominal = ?, "
				+ "habitoIntestinal = ?, "
				+ "examesRecentes = ?, "
				+ "medicamentos = ?, "
				+ "tpPraticaAtividadeFisica = ?, "
				+ "frequenciaAtividadeFisica = ?, "
				+ "intensidadeAtividadeFisica = ?, "
				+ "intoleranciaAlergiaAlimentar = ?, "
				+ "alimentosGosta = ?, "
				+ "alimentosNaoGosta = ?, "
				+ "apetite = ?, "
				+ "hrFomeEAlimentos = ?, "
				+ "localDeRefeicaoEQuemCozinha = ?, "
				+ "oleoPorMes = ?, "
				+ "acucarPorMes = ?, "
				+ "fsAmilacidos = ?, "
				+ "fsFritura = ?, "
				+ "fsFrutas = ?, "
				+ "fsVerdSaladaLeg = ?, "
				+ "fsCarnes = ?, "
				+ "fsRefrigerante = ?, "
				+ "fsBolachaChocBolo = ?, "
				+ "fsLeiteIogurte = ?,"
				+ "fsLeguminosas = ?, "
				+ "fsBebidaAlcoolica = ?, "
				+ "consumoLiquidos = ?, "
				+ "aguaPorDia = ?, "
				+ "outrosLiquidos = ?, "
				+ "suplementoVitaminicoAlimentar = ?, "
				+ "suplementoVitaminicoAlimentarInformacoes = ?, "
				+ "recordatorioAlimentar = ?, "
				+ "condutaNutricional = ? "
				+ "WHERE idFichaDeAtendimento = ?"			
				);
		
		
		// `idAtleta`, `idUsuario`, `dtAtendimento`, `HMA`, `acompanhamentoAnterior`, `duracaoAcompanhamentoAnterior`, `HMF`, 
		stmtScript.setInt(1, ficha.getIdAtleta());
		stmtScript.setInt(2, ficha.getIdUsuario());
		stmtScript.setString(3, ficha.getHMA());
		stmtScript.setString(4, ficha.getAcompanhamentoAnterior());
		stmtScript.setString(5, ficha.getDuracaoAcompanhamentoAnterior());
		stmtScript.setString(6, ficha.getHMF());
		// `flObesidade`, `flDiabetes`, `flHas`, `flDoencaCardiaca`, `flColesterol`, `flGastrite`, `flAzia`, `flDorAbdominal`, 
		stmtScript.setBoolean(7, ficha.getFlObesidade());
		stmtScript.setBoolean(8, ficha.getFlDiabetes());
		stmtScript.setBoolean(9, ficha.getFlHas());
		stmtScript.setBoolean(10, ficha.getFlDoencaCardiaca());
		stmtScript.setBoolean(11, ficha.getFlColesterol());
		stmtScript.setBoolean(12, ficha.getFlGastrite());
		stmtScript.setBoolean(13, ficha.getFlAzia());
		stmtScript.setBoolean(14, ficha.getFlDorAbdominal());
		//`habitoIntestinal`, `examesRecentes`, `medicamentos`, `tpPraticaAtividadeFisica`,
		stmtScript.setString(15, ficha.getHabitoIntestinal());
		stmtScript.setString(16, ficha.getExamesRecentes());
		stmtScript.setString(17, ficha.getMedicamentos());
		stmtScript.setString(18, ficha.getTpPraticaAtividadeFisica());
		//`frequenciaAtividadeFisica`, `intensidadeAtividadeFisica`,`intoleranciaAlergiaAlimentar`, `alimentosGosta`, 
		stmtScript.setString(19, ficha.getFrequenciaAtividadeFisica());
		stmtScript.setString(20, ficha.getIntensidadeAtividadeFisica());
		stmtScript.setString(21, ficha.getIntoleranciaAlergiaAlimentar());
		stmtScript.setString(22, ficha.getAlimentosGosta());
		//`alimentosNaoGosta`,`apetite`, `hrFomeEAlimentos`, `localDeRefeicaoEQuemCozinha`,
		stmtScript.setString(23, ficha.getAlimentosNaoGosta());
		stmtScript.setString(24, ficha.getApetite());
		stmtScript.setString(25, ficha.getHrFomeEAlimentos());
		stmtScript.setString(26, ficha.getLocalDeRefeicaoEQuemCozinha());
		//`oleoPorMes`, `acucarPorMes`, `fsAmilacidos`, `fsFritura`, `fsFrutas`, `fsVerdSaladaLeg`,
		stmtScript.setString(27, ficha.getOleoPorMes());
		stmtScript.setString(28, ficha.getAcucarPorMes());
		stmtScript.setString(29, ficha.getFsAmilacidos());
		stmtScript.setString(30, ficha.getFsFritura());
		stmtScript.setString(31, ficha.getFsFrutas());
		stmtScript.setString(32, ficha.getFsVerdSaladaLeg());
		//`fsCarnes`, `fsRefrigerante`, `fsBolachaChocBolo`, `fsLeiteIogurte`, `fsLeguminosas`, `fsBebidaAlcoolica`,
		stmtScript.setString(33, ficha.getFsCarnes());
		stmtScript.setString(34, ficha.getFsRefrigerante());
		stmtScript.setString(35, ficha.getFsBolachaChocBolo());
		stmtScript.setString(36, ficha.getFsLeiteIogurte());
		stmtScript.setString(37, ficha.getFsLeguminosas());
		stmtScript.setString(38, ficha.getFsBebidaAlcoolica());
		//`consumoLiquidos`, `guaPorDia`, `outrosLiquidos`, `suplementoVitaminicoAlimentar`, `suplementoVitaminicoAlimentarInformacoes`, 
		//`recordatorioAlimentar`, `condutaNutricional` 
		stmtScript.setString(39, ficha.getConsumoLiquidos());
		stmtScript.setString(40, ficha.getAguaPorDia());
		stmtScript.setString(41, ficha.getOutrosLiquidos());
		stmtScript.setString(42, ficha.getSuplementoVitaminicoAlimentar());
		stmtScript.setString(43, ficha.getSuplementoVitaminicoAlimentarInformacoes());
		stmtScript.setString(44, ficha.getRecordatorioAlimentar());
		stmtScript.setString(45, ficha.getCondutaNutricional());
		stmtScript.setInt(46, ficha.getIdFichaDeAtendimento());
	
		if(stmtScript.executeUpdate() > 0)
			return true;
		else
			return false;
	}

	public ArrayList<ArrayList<String>> buscarUltimosAtendimentos(int idPessoa) throws Exception {
		stmtScript = con.prepareStatement("SELECT "
				+ "		f.idAtleta AS idAtleta, "
				+ "		MAX(f.dtAtendimento) AS dtUltimoAtendimento, "
				+ "		a.nome AS nmAtleta "
				+ "FROM fichadeatendimento f "
				+ "		JOIN atleta a ON "
				+ " 	 	f.idAtleta = a.idAtleta "
				+ "WHERE"
				+ "		f.idUsuario = ? "
				+ "GROUP BY "
				+ "		f.idAtleta "
				+ "ORDER BY "
				+ "		f.dtAtendimento DESC " 
				+ "LIMIT 10");
		
		stmtScript.setInt(1, idPessoa);
		
		ResultSet rs = stmtScript.executeQuery();
		
		ArrayList<ArrayList<String>> listaUltimosAtendimentos = new ArrayList<ArrayList<String>>();
		while(rs.next()){
			ArrayList<String> atendimento = new ArrayList<String>();
			//MANIPULA ATENDIMENTO
			//atendimento.add(String.valueOf(rs.getInt("idAtleta")));
			atendimento.add(rs.getString("idAtleta"));
			atendimento.add(rs.getString("nmAtleta"));
			atendimento.add(rs.getString("dtUltimoAtendimento"));
			
			listaUltimosAtendimentos.add(atendimento);
		}
		
		return listaUltimosAtendimentos;
	}

}
