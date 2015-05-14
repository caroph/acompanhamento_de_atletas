package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Observacao;

public class ObservacaoDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public ObservacaoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public ObservacaoDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public int salvarObservacao(Observacao observacao) throws SQLException{
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO observacao (idAtleta, idUsuario, dsObservacao, gravidade, "
				+ "dtValidade) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		stmtScript.setInt(1, observacao.getAtleta().getIdPessoa());
		stmtScript.setInt(2, observacao.getUsuario().getIdPessoa());
		stmtScript.setString(3, observacao.getDsObservacao());
		stmtScript.setInt(4, observacao.getGravidade());
		stmtScript.setDate(5, new java.sql.Date(observacao.getDtValidade().getTime()));
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			ResultSet generatedKeys = stmtScript.getGeneratedKeys();
			 if (generatedKeys.next()) {
				 observacao.setIdObservacao(generatedKeys.getInt(1));
			 }			
		}			
		return observacao.getIdObservacao();
	}

	public boolean salvarVisualizacaoObservacao(int idObservacao, int idUsuario) throws SQLException {
		stmtScript = con.prepareStatement("INSERT INTO visualizacaoobservacao (idObservacao, idUsuario) "
				+ "VALUES (?, ?)");
		stmtScript.setInt(1, idObservacao);
		stmtScript.setInt(2, idUsuario);
		
		int rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}
		return false;
	}
}
