package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AvaliacaoFisica;
import br.com.saat.model.ConnectionFactory;

import com.mysql.jdbc.Statement;

public class AvaliacaoFisicaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public AvaliacaoFisicaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public AvaliacaoFisicaDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public int inserir(AvaliacaoFisica avalFis) throws SQLException {
		int idAvaliacaoFisica = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO avaliacaoFisica "
				+ "(idAtleta, idUsuResp, idTpCaracteristica, dtAvaliacao, observacaoGeral) "
				+ "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		stmtScript.setInt(1, avalFis.getAtleta().getIdPessoa());
		stmtScript.setInt(2, avalFis.getIdUsuResp());
		stmtScript.setInt(3, avalFis.getIdTpCaracteristica());
		stmtScript.setDate(4, new java.sql.Date(avalFis.getDtAvaliacao().getTime()));
		stmtScript.setString(5, avalFis.getObservacaoGeral());
		
		stmtScript.executeUpdate();
		ResultSet rs = stmtScript.getGeneratedKeys();
		
		if(rs.next()){
			idAvaliacaoFisica = rs.getInt(1);
		}
				
		return idAvaliacaoFisica;
	}

	public List<AvaliacaoFisica> buscaHistorico(int idAtleta) throws SQLException {
		List<AvaliacaoFisica> listaAvaliacaoFis = new ArrayList<AvaliacaoFisica>();
		
		stmtScript = con.prepareStatement("SELECT idAvaliacaoFisica, idTpCaracteristica, dtAvaliacao, observacaoGeral "
				+ "FROM avaliacaofisica "
				+ "WHERE idAtleta = ? "
				+ "ORDER BY dtAvaliacao");
		
		stmtScript.setInt(1, idAtleta);

		ResultSet rs = stmtScript.executeQuery();
		
		while (rs.next()) {
			AvaliacaoFisica avaliacaoFis = new AvaliacaoFisica();
			
			avaliacaoFis.setIdAvaliacaoFisica(rs.getInt(1));
			avaliacaoFis.setIdTpCaracteristica(rs.getInt(2));
			avaliacaoFis.setDtAvaliacao(rs.getDate(3));
			avaliacaoFis.setObservacaoGeral(rs.getString(4));
			
			listaAvaliacaoFis.add(avaliacaoFis);
		}
		
		return listaAvaliacaoFis;
	}
	
	public boolean excluir(int idAvaliacaoFisica) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("DELETE FROM avaliacaoFisica WHERE idAvaliacaoFisica = ?");
		
		stmtScript.setInt(1, idAvaliacaoFisica);
		
		if (stmtScript.executeUpdate() >= 0) {
			retorno = true;
		}
		
		return retorno;
	}
}
