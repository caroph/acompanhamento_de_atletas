package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.ConnectionFactory;

public class CategoriaAvaliacaoDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public CategoriaAvaliacaoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public CategoriaAvaliacaoDAO(Connection con) throws Exception{
        this.con = con;        
    }
	public List<CategoriaAvaliacao> buscarCategorias() throws SQLException {
		List<CategoriaAvaliacao> lista = new ArrayList<CategoriaAvaliacao>();
		
		stmtScript = con.prepareStatement("SELECT idCategoriaAvaliacao, idTipoCat, nmCategoria, "
				+ "idadeMinima, idadeMaxima, sexo "
				+ "FROM categoriaAvaliacao "
				+ "WHERE flCadastroAtivo = 1");
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			categoria.setIdCategoriaAvaliacao(rs.getInt(1));
			categoria.setIdTipoCat(rs.getInt(2));
			categoria.setNmCategoria(rs.getString(3));
			categoria.setIdadeMinima(rs.getFloat(4));
			categoria.setIdadeMaxima(rs.getFloat(5));
			categoria.setSexo(rs.getString(6));
			lista.add(categoria);
		}
		return lista;
	}

	public boolean desativar(CategoriaAvaliacao categoria) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE categoriaAvaliacao "
				+ "SET flCadastroAtivo = 0 "
				+ "WHERE idCategoriaAvaliacao = ? ");
		
		stmtScript.setInt(1, categoria.getIdCategoriaAvaliacao());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;	
	}

	public boolean inserir(CategoriaAvaliacao categoria) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("INSERT INTO categoriaAvaliacao "
				+ "(idTipoCat, nmCategoria, idadeMinima, idadeMaxima, sexo) "
				+ " VALUES (?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, categoria.getIdTipoCat());
		stmtScript.setString(2, categoria.getNmCategoria());
		stmtScript.setFloat(3, categoria.getIdadeMinima());
		stmtScript.setFloat(4, categoria.getIdadeMaxima());
		stmtScript.setString(5, categoria.getSexo());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;
	}
}
