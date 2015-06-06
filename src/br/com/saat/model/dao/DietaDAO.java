package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Dieta;

public class DietaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public DietaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public DietaDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public boolean inserir(Dieta dieta) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO dieta (idAtleta, idUsuario, idRefeicao, flCompeticao, dtValidadeInicio, dtValidadeFim, descricao)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, dieta.getAtleta().getIdPessoa());
		stmtScript.setInt(2, dieta.getUsuario().getIdPessoa());
		stmtScript.setInt(3, dieta.getRefeicao());
		stmtScript.setBoolean(4, dieta.isCompeticao());
		
		if (dieta.getDtValidadeInicio() == null) {
			stmtScript.setNull(5, 0);
		} else {
			stmtScript.setDate(5, new java.sql.Date(dieta.getDtValidadeInicio().getTime()));
		}
		
		if (dieta.getDtValidadeFim() == null) {
			stmtScript.setNull(6, 0);
		} else {
			stmtScript.setDate(6, new java.sql.Date(dieta.getDtValidadeFim().getTime()));
		}
		
		stmtScript.setString(7, dieta.getDescricao());
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		
		return retorno;
	}

	public List<Dieta> buscaDietas(Atleta atleta) throws SQLException {
		List<Dieta> lista = new ArrayList<Dieta>();
		
		stmtScript = con.prepareStatement("SELECT idDieta, idRefeicao, flCompeticao, dtValidadeInicio, dtValidadeFim, descricao "
		+ "FROM dieta d "
		+ "WHERE d.idAtleta = ? AND d.flCadastroAtivo = 1 "
		+ "ORDER BY idRefeicao DESC, dtGeracao DESC ");
		
		stmtScript.setInt(1, atleta.getIdPessoa());
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Dieta dieta = new Dieta();
			
			dieta.setIdDieta(rs.getInt("idDieta"));
			dieta.setRefeicao(rs.getInt("idRefeicao"));
			dieta.setCompeticao(rs.getBoolean("flCompeticao"));
			dieta.setDtValidadeInicio(rs.getDate("dtValidadeInicio"));
			dieta.setDtValidadeFim(rs.getDate("dtValidadeFim"));
			dieta.setDescricao(rs.getString("descricao"));
			
			lista.add(dieta);
		}
		return lista;
	}

	public Dieta buscaDieta(Dieta dieta) throws SQLException {
		
		stmtScript = con.prepareStatement("SELECT idDieta, idRefeicao, flCompeticao, dtValidadeInicio, dtValidadeFim, descricao "
		+ "FROM dieta d "
		+ "WHERE d.idDieta = ? ");
		
		stmtScript.setInt(1, dieta.getIdDieta());
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			dieta.setRefeicao(rs.getInt("idRefeicao"));
			dieta.setCompeticao(rs.getBoolean("flCompeticao"));
			dieta.setDtValidadeInicio(rs.getDate("dtValidadeInicio"));
			dieta.setDtValidadeFim(rs.getDate("dtValidadeFim"));
			dieta.setDescricao(rs.getString("descricao"));
		}
		return dieta;
	}

	public boolean excluir(Dieta dieta) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE dieta SET flCadastroAtivo = 0 WHERE idDieta = ?");
		stmtScript.setInt(1, dieta.getIdDieta());		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		return retorno;
	}

	public boolean alterar(Dieta dieta) throws SQLException {
		boolean retorno = false;
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE dieta "
				+ "SET idRefeicao = ?, "
				+ "flCompeticao = ?, "
				+ "dtValidadeInicio = ?, "
				+ "dtValidadeFim = ?, "
				+ "descricao = ? "
				+ "WHERE idDieta = ? ");
		
		stmtScript.setInt(1, dieta.getRefeicao());
		stmtScript.setBoolean(2, dieta.isCompeticao());
		stmtScript.setDate(3, new java.sql.Date(dieta.getDtValidadeInicio().getTime()));
		stmtScript.setDate(4, new java.sql.Date(dieta.getDtValidadeFim().getTime()));
		stmtScript.setString(5, dieta.getDescricao());
		stmtScript.setInt(6, dieta.getIdDieta());
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			retorno = true;
		}	
		
		return retorno;
	}
}
