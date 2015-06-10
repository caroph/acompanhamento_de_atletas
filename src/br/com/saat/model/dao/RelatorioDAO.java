package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.saat.model.ConnectionFactory;

public class RelatorioDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public RelatorioDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public RelatorioDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public void verificarResultadoRelatorioRetiradaAtleta(int idAtleta) throws Exception {
		stmtScript = con.prepareStatement("SELECT i.quantidade AS QUANTIDADE, tu.dsTpUniforme AS UNIFORME, "
				+ "tt.dsTpTamanhoUniforme AS TAMANHO, r.dtRetirada AS DATA_RETIRADA, a.nome AS ATLETA "
				+ "FROM itemretirada i "
				+ "JOIN uniforme u on i.idUniforme = u.idUniforme "
				+ "JOIN retiradauniforme r on i.idRetiradaUniforme = r.idRetiradaUniforme "
				+ "JOIN atleta a on r.idAtleta = a.idAtleta "
				+ "JOIN tpuniforme tu on u.tpUniforme = tu.idTpUniforme "
				+ "JOIN tptamanhouniforme tt on u.tamanhoUniforme = tt.idTpTamanhoUniforme "
				+ "WHERE r.idAtleta = ? "
				+ "ORDER BY UNIFORME, TAMANHO, DATA_RETIRADA");
		stmtScript.setInt(1, idAtleta);
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}
	
	public void verificarResultadoRelatorioRetiradaPeca(int tpUniforme) throws Exception {
		stmtScript = con.prepareStatement("SELECT i.quantidade AS QUANTIDADE, tu.dsTpUniforme AS UNIFORME, "
				+ "tt.dsTpTamanhoUniforme AS TAMANHO, r.dtRetirada AS DATA_RETIRADA, a.nome AS ATLETA "
				+ "FROM itemretirada i "
				+ "JOIN uniforme u on i.idUniforme = u.idUniforme "
				+ "JOIN retiradauniforme r on i.idRetiradaUniforme = r.idRetiradaUniforme "
				+ "JOIN atleta a on r.idAtleta = a.idAtleta "
				+ "JOIN tpuniforme tu on u.tpUniforme = tu.idTpUniforme "
				+ "JOIN tptamanhouniforme tt on u.tamanhoUniforme = tt.idTpTamanhoUniforme "
				+ "WHERE u.tpUniforme = ? "
				+ "ORDER BY ATLETA, DATA_RETIRADA");
		stmtScript.setInt(1, tpUniforme);
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioResultadoTorneio(int idTorneio) throws Exception {
		stmtScript = con.prepareStatement("SELECT t.nome, local, estado, cidade, dtInicial, dtFinal, "
				+ "dscNaipe, dscCatTorneio, dscTpTorneio, dscGpTorneio, "
				+ "descricao, inscritosGeral, inscritosClube, a.nome as atletaDestaque, motivoDestaque, "
				+ "fotografo, encaminhamentoMkt, u.nome as usuCriacao "
				+ "FROM torneio t "
				+ "LEFT JOIN naipe n ON t.idNaipe = n.idNaipe "
				+ "LEFT JOIN cattorneio c ON t.idCatTorneio = c.idCatTorneio "
				+ "LEFT JOIN tptorneio tp ON t.idTpTorneio = tp.idTpTorneio "
				+ "LEFT JOIN gptorneio g ON t.idGpTorneio = g.idGpTorneio "
				+ "LEFT JOIN atleta a ON t.idDestaque = a.idAtleta "
				+ "LEFT JOIN usuario u ON t.idUsuCriacao = u.idUsuario "
				+ "WHERE idTorneio = ?");
		stmtScript.setInt(1, idTorneio);
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioFrequenciaTorneioAtleta(Date inicio, Date fim) throws Exception {
		stmtScript = con.prepareStatement("SELECT a.nome as atleta, t.nome as torneio, cidade, estado, colocacao, "
				+ "dtInicial, dtFinal, dscGpTorneio, dscCatTorneio, dscTpTorneio "
				+ "FROM atletatorneio at "
				+ "LEFT JOIN atleta a ON at.idAtleta = a.idAtleta "
				+ "LEFT JOIN torneio t ON at.idTorneio = t.idTorneio "
				+ "LEFT JOIN atletaresultadotorneio art ON a.idAtleta = art.idAtleta AND t.idTorneio = art.idTorneio "
				+ "LEFT JOIN tptorneio tt ON t.idTpTorneio = tt.idTpTorneio "
				+ "LEFT JOIN gptorneio g ON t.idGpTorneio = g.idGpTorneio "
				+ "LEFT JOIN cattorneio c ON t.idCatTorneio = c.idCatTorneio "
				+ "WHERE dtInicial >= ? AND dtFinal <= ? "
				+ "ORDER BY a.nome, dtInicial, dtFinal");
		stmtScript.setDate(1, new java.sql.Date(inicio.getTime()));
		stmtScript.setDate(2, new java.sql.Date(fim.getTime()));
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioFrequenciaTorneioTipo(Date inicio, Date fim) throws Exception {
		stmtScript = con.prepareStatement("SELECT a.nome as atleta, t.nome as torneio, colocacao, dtInicial, "
				+ "dtFinal, dscTpTorneio "
				+ "FROM atletatorneio at "
				+ "LEFT JOIN atleta a ON at.idAtleta = a.idAtleta "
				+ "LEFT JOIN torneio t ON at.idTorneio = t.idTorneio "
				+ "LEFT JOIN tptorneio tt ON t.idTpTorneio = tt.idTpTorneio "
				+ "LEFT JOIN atletaresultadotorneio art ON a.idAtleta = art.idAtleta AND t.idTorneio = art.idTorneio "
				+ "WHERE dtInicial >= ? AND dtFinal <= ? "
				+ "ORDER BY dscTpTorneio, a.nome, dtInicial, dtFinal");
		stmtScript.setDate(1, new java.sql.Date(inicio.getTime()));
		stmtScript.setDate(2, new java.sql.Date(fim.getTime()));
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioFrequenciaTorneio(Date inicio, Date fim) throws Exception {
		stmtScript = con.prepareStatement("SELECT t.idTorneio as idTorneio, a.nome as atleta, t.nome as torneio, "
				+ "colocacao, dtInicial, dtFinal "
				+ "FROM atletatorneio at "
				+ "LEFT JOIN atleta a ON at.idAtleta = a.idAtleta "
				+ "LEFT JOIN torneio t ON at.idTorneio = t.idTorneio "
				+ "LEFT JOIN atletaresultadotorneio art ON a.idAtleta = art.idAtleta AND t.idTorneio = art.idTorneio "
				+ "WHERE dtInicial >= ? AND dtFinal <= ?");
		stmtScript.setDate(1, new java.sql.Date(inicio.getTime()));
		stmtScript.setDate(2, new java.sql.Date(fim.getTime()));
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioPresencaTreinos(Date inicio, Date fim) throws Exception {
		stmtScript = con.prepareStatement("SELECT c.dtChamada AS DATA_CHAMADA, a.nome AS NOME_ATLETA, "
				+ "tp2.dsTpPresenca AS PRESENCA_TECNICO,  pc.justificativaT "
				+ "AS JUST_TECNICO, tp.dsTpPresenca AS PRESENCA_FISICO, pc.justificativaF AS JUST_FISICO, "
				+ "CONCAT(te.dsTpEquipe, ' - ', ds.dsDiaSemana, ' - ', d.hrInicio, ' às ', d.hrFim) "
				+ "AS DIA_TREINO, d.idDiaTreino AS ID_DIA_TREINO "
				+ "FROM atleta a "
				+ "JOIN presencachamada pc ON a.idAtleta = pc.idAtleta "
				+ "JOIN chamada c ON pc.idChamada = c.idChamada "
				+ "JOIN tppresenca tp ON pc.estadoPresencaF = tp.idTpPresenca "
				+ "JOIN tppresenca tp2 ON pc.estadoPresencaT = tp2.idTpPresenca "
				+ "JOIN diatreino d on c.idDiaTreino = d.idDiaTreino "
				+ "JOIN diasemana ds on d.idDiaSemana = ds.idDiaSemana "
				+ "JOIN tpequipe te on d.idTpEquipe = te.idTpEquipe "
				+ "WHERE dtChamada BETWEEN ? AND ? "
				+ "ORDER BY DATA_CHAMADA, ID_DIA_TREINO, NOME_ATLETA");
		stmtScript.setDate(1, new java.sql.Date(inicio.getTime()));
		stmtScript.setDate(2, new java.sql.Date(fim.getTime()));
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioPresencaMedica(Date inicio, Date fim) throws Exception {
		stmtScript = con.prepareStatement("SELECT a.nome AS ATLETA, p.dtAtendimento AS DATA_ATENDIMENTO, "
				+ "p.hrAtendimento AS HORA_ATENDIMENTO, UPPER(pe.dsPerfil) AS PERFIL, u.nome AS PROFISSIONAL "
				+ "FROM prontuario p "
				+ "JOIN usuario u ON p.idUsuario = u.idUsuario "
				+ "JOIN perfil pe ON u.perfil = pe.idPerfil "
				+ "JOIN atleta a ON p.idAtleta = a.idAtleta "
				+ "WHERE p.dtAtendimento BETWEEN ? AND ? "
				+ "UNION "
				+ "SELECT a.nome, DATE(f.dtAtendimento), "
				+ "CONCAT(HOUR(f.dtAtendimento), ':', MINUTE(f.dtAtendimento)), 'NUTRICIONISTA', u.nome "
				+ "FROM fichadeatendimento f "
				+ "JOIN atleta a ON f.idAtleta = a.idAtleta "
				+ "JOIN usuario u ON f.idUsuario = u.idUsuario "
				+ "WHERE f.dtAtendimento BETWEEN ? AND ? "
				+ "ORDER BY PERFIL, ATLETA, DATA_ATENDIMENTO, HORA_ATENDIMENTO");
		stmtScript.setDate(1, new java.sql.Date(inicio.getTime()));
		stmtScript.setDate(2, new java.sql.Date(fim.getTime()));
		stmtScript.setDate(3, new java.sql.Date(inicio.getTime()));
		stmtScript.setDate(4, new java.sql.Date(fim.getTime()));
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioBonificacaoGeral(int mes, int ano) throws Exception {
		stmtScript = con.prepareStatement("SELECT a.nome AS atleta, ad.avaliacoes, "
				+ "ad.torneios, ad.treinos, ad.rankCBT, ad.rankFPT, ad.rankITF, ad.bonificado, ad.observacoes "
				+ "FROM atleta a "
				+ "JOIN avaliacaodesempenho ad ON a.idAtleta = ad.idAtleta AND ad.mes = ? AND ad.ano = ? "
				+ "WHERE a.flCadastroAtivo = 1 "
				+ "ORDER BY a.nome");
		stmtScript.setInt(1, mes);
		stmtScript.setInt(2, ano);
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoRelatorioBonificacaoIndividual(int idAtleta) throws Exception {
		stmtScript = con.prepareStatement("SELECT a.nome, ad.avaliacoes, ad.torneios, ad.treinos, ad.rankCBT, "
				+ "ad.rankFPT, ad.rankITF, ad.bonificado, ad.observacoes, "
				+ "ad.mes, ad.ano "
				+ "FROM atleta a "
				+ "JOIN avaliacaodesempenho ad ON a.idAtleta = ad.idAtleta "
				+ "WHERE a.flCadastroAtivo = 1 AND a.idAtleta = ? "
				+ "ORDER BY ad.ano, ad.mes");
		stmtScript.setInt(1, idAtleta);
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}

	public void verificarResultadoHistoricoObservacoes(int idAtleta) throws Exception {
		stmtScript = con.prepareStatement("SELECT a.nome AS ATLETA, o.dtGeracao AS DT_INCLUSAO, o.dtValidade AS DT_VALIDADE,"
				+ " o.dsObservacao AS OBSERVACAO, "
				+ "g.dsGravidade AS GRAVIDADE, u.nome AS USUARIO, "
				+ "CASE "
				+ "WHEN o.compartilhamento = 1 THEN 'Todos' "
				+ "WHEN o.compartilhamento = 0 THEN 'Técnico' "
				+ "END AS COMPARTILHAMENTO "
				+ "FROM observacao o "
				+ "JOIN usuario u ON o.idUsuario = u.idUsuario "
				+ "JOIN gravidadeobservacao g ON o.gravidade = g.idGravidadeObservacao "
				+ "JOIN atleta a ON o.idAtleta = a.idAtleta "
				+ "WHERE o.idAtleta = ? "
				+ "ORDER BY DT_INCLUSAO DESC");
		stmtScript.setInt(1, idAtleta);
		ResultSet rs = stmtScript.executeQuery();
		
		if(!rs.next()){
			throw new Exception("A consulta não gerou resultados");
		}
	}
}
