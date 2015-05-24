package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import br.com.saat.model.AvaliacaoFisica;
import br.com.saat.model.ConnectionFactory;

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
}
