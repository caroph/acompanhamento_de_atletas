package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AtividadeAvaliacao;
import br.com.saat.model.AvaliacaoFisica;
import br.com.saat.model.AvaliacaoResultado;
import br.com.saat.model.CategoriaAtividade;
import br.com.saat.model.ConnectionFactory;

public class AvaliacaoResultadoDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public AvaliacaoResultadoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public AvaliacaoResultadoDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public List<AvaliacaoResultado> buscarAtividades(int idAtleta) throws SQLException {
		List<AvaliacaoResultado> listaAvaResul = new ArrayList<AvaliacaoResultado>();
		
		stmtScript = con.prepareStatement("SELECT cativ.idCategoriaAtividade, capacidade, teste, idUnidadeDeMedida "
				+ "FROM atleta atle "
				+ "		INNER JOIN categoriaAvaliacao caval "
				+ "			ON atle.sexo = caval.sexo "
				+ "				AND TIMESTAMPDIFF(YEAR, atle.dtNascimento, NOW()) >= caval.idadeMinima "
				+ "				AND TIMESTAMPDIFF(YEAR, atle.dtNascimento, NOW()) <= caval.idadeMaxima "
				+ "				AND caval.idTipoCat = 2 "
				+ "		INNER JOIN categoriaAtividade cativ "
				+ "			ON caval.idCategoriaAvaliacao = cativ.idCategoriaAvaliacao "
				+ "				AND cativ.flCadastroAtivo = 1 "
				+ "		INNER JOIN atividadeAvaliacao ativ "
				+ "			ON cativ.idAtividadeAvaliacao = ativ.idAtividadeAvaliacao "
				+ "WHERE atle.idAtleta = ? "
				+ "ORDER BY capacidade, teste ");
		
		stmtScript.setInt(1, idAtleta);

		ResultSet rs = stmtScript.executeQuery();
		
		while (rs.next()) {
			AtividadeAvaliacao ativAva = new AtividadeAvaliacao();
			ativAva.setCapacidade(rs.getString("capacidade"));
			ativAva.setTeste(rs.getString("teste"));
			ativAva.setIdUnidadeDeMedida(rs.getInt("idUnidadeDeMedida"));
			
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			catAtiv.setIdCategoriaAtividade(rs.getInt("idCategoriaAtividade"));
			catAtiv.setAtividadeAvaliacao(ativAva);
			
			AvaliacaoResultado avaResult = new AvaliacaoResultado();
			avaResult.setCategoriaAtividade(catAtiv);
			
			listaAvaResul.add(avaResult);
		}
		
		return listaAvaResul;
	}

	public boolean inserir(AvaliacaoResultado resultado, AvaliacaoFisica avalFis) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("INSERT INTO avaliacaoFisicaResultado "
				+ "(idCategoriaAtividade, idAvaliacaoFisica, desempenho) "
				+ "VALUES (?, ?, ?)");
		
		stmtScript.setInt(1, resultado.getCategoriaAtividade().getIdCategoriaAtividade());
		stmtScript.setInt(2, avalFis.getIdAvaliacaoFisica());
		stmtScript.setFloat(3, resultado.getDesempenho());
		
		if (stmtScript.executeUpdate() > 0) {
			retorno = true;
		}
		
		return retorno;
	}

	public List<AvaliacaoResultado> buscarResultDesempenho(int idAvaliacaoFisica) throws SQLException {
		List<AvaliacaoResultado> resultDesempenho = new ArrayList<AvaliacaoResultado>();
		
		stmtScript = con.prepareStatement("SELECT capacidade, teste, desempenho, "
				+ "CASE "
				+ "WHEN desempenho < melhorar THEN 'Nenhuma referência atingida' "
				+ "WHEN desempenho >= melhorar AND desempenho < media THEN 'Melhorar' "
				+ "WHEN desempenho >= media AND  desempenho < bom THEN 'Média' "
				+ "WHEN desempenho >= bom AND desempenho < excelente THEN 'Bom' "
				+ "WHEN desempenho >= excelente THEN 'Excelente' "
				+ "END as resultado "
				+ "FROM avaliacaoFisicaResultado afr "
				+ "INNER JOIN categoriaAtividade ca "
				+ "ON ca.idCategoriaAtividade = afr.idCategoriaAtividade "
				+ "INNER JOIN atividadeAvaliacao atAv "
				+ "ON ca.idAtividadeAvaliacao = atAv.idAtividadeAvaliacao "
				+ "WHERE idAvaliacaoFisica = ? "
				+ "ORDER BY capacidade, teste ");
		
		stmtScript.setInt(1, idAvaliacaoFisica);
		
		ResultSet rs = stmtScript.executeQuery();
		
		while (rs.next()) {
			AtividadeAvaliacao atividade = new AtividadeAvaliacao();
			atividade.setCapacidade(rs.getString("capacidade"));
			atividade.setTeste(rs.getString("teste"));
			
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			catAtiv.setAtividadeAvaliacao(atividade);
			
			AvaliacaoResultado resultado = new AvaliacaoResultado();
			resultado.setCategoriaAtividade(catAtiv);
			resultado.setDesempenho(rs.getFloat("desempenho"));
			resultado.setResultado(rs.getString("resultado"));
			
			resultDesempenho.add(resultado);
		}
		return resultDesempenho;
	}

	public boolean excluir(int idAvaliacaoFisica) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("DELETE FROM avaliacaoFisicaResultado WHERE idAvaliacaoFisica = ?");
		
		stmtScript.setInt(1, idAvaliacaoFisica);
		
		if (stmtScript.executeUpdate() >= 0) {
			retorno = true;
		}
		
		return retorno;
	}
}