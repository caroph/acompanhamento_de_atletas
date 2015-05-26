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
	public List<CategoriaAvaliacao> buscarCategorias(int tipoConsulta, int idCategoria) throws SQLException {
		// tipoConsulta -> 0 = Geral / 1 = Sem dados de referência cadastrado / 2 = Buscar categoria específica
		List<CategoriaAvaliacao> lista = new ArrayList<CategoriaAvaliacao>();
		
		if (tipoConsulta == 0) {
			
			stmtScript = con.prepareStatement("SELECT idCategoriaAvaliacao, idTipoCat, nmCategoria, "
					+ "idadeMinima, idadeMaxima, sexo "
					+ "FROM categoriaavaliacao "
					+ "WHERE flCadastroAtivo = 1 ");
			
		} else if (tipoConsulta == 1) {
			stmtScript = con.prepareStatement("SELECT c.idCategoriaAvaliacao, idTipoCat, nmCategoria, "
					+ "idadeMinima, idadeMaxima, sexo "
					+ "FROM categoriaavaliacao c "
					+ "LEFT JOIN categoriaatividade ca "
					+ "ON c.idCategoriaAvaliacao = ca.idCategoriaAvaliacao "
					+ "AND ca.flCadastroAtivo = 1 "
					+ "WHERE c.flCadastroAtivo = 1 AND ca.idCategoriaAtividade IS NULL ");

		} else {
			stmtScript = con.prepareStatement("SELECT idCategoriaAvaliacao, idTipoCat, nmCategoria, "
					+ "idadeMinima, idadeMaxima, sexo "
					+ "FROM categoriaavaliacao c "
					+ "WHERE flCadastroAtivo = 1 AND idCategoriaAvaliacao = ? ");
			
			stmtScript.setInt(1, idCategoria);

		}
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			categoria.setIdCategoriaAvaliacao(rs.getInt(1));
			categoria.setIdTipoCat(rs.getInt(2));
			categoria.setNmCategoria(rs.getString(3));
			categoria.setIdadeMinima(rs.getInt(4));
			categoria.setIdadeMaxima(rs.getInt(5));
			categoria.setSexo(rs.getInt(6));
			lista.add(categoria);
		}
		return lista;
	}

	public boolean desativar(CategoriaAvaliacao categoria) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE categoriaavaliacao "
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
		
		stmtScript = con.prepareStatement("INSERT INTO categoriaavaliacao "
				+ "(idTipoCat, nmCategoria, idadeMinima, idadeMaxima, sexo) "
				+ " VALUES (?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, categoria.getIdTipoCat());
		stmtScript.setString(2, categoria.getNmCategoria());
		stmtScript.setInt(3, categoria.getIdadeMinima());
		stmtScript.setInt(4, categoria.getIdadeMaxima());
		stmtScript.setInt(5, categoria.getSexo());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;
	}

	public CategoriaAvaliacao buscarCategoria(CategoriaAvaliacao categoriaBase) throws SQLException {
		CategoriaAvaliacao categoria = new CategoriaAvaliacao();
		
		stmtScript = con.prepareStatement("SELECT idCategoriaAvaliacao, idTipoCat, nmCategoria, "
				+ "idadeMinima, idadeMaxima, sexo "
				+ "FROM categoriaavaliacao "
				+ "WHERE flCadastroAtivo = 1 AND idCategoriaAvaliacao = ? ");
		
		stmtScript.setInt(1, categoriaBase.getIdCategoriaAvaliacao());
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			categoria.setIdCategoriaAvaliacao(rs.getInt(1));
			categoria.setIdTipoCat(rs.getInt(2));
			categoria.setNmCategoria(rs.getString(3));
			categoria.setIdadeMinima(rs.getInt(4));
			categoria.setIdadeMaxima(rs.getInt(5));
			categoria.setSexo(rs.getInt(6));
		}
		return categoria;
	}
}
