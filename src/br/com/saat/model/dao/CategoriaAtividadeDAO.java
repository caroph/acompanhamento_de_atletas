package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.CategoriaAtividade;
import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.ConnectionFactory;

public class CategoriaAtividadeDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public CategoriaAtividadeDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public CategoriaAtividadeDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public boolean inserir(CategoriaAtividade catAtiv) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("INSERT INTO categoriaAtividade "
				+ "(idCategoriaAvaliacao, idAtividadeAvaliacao, melhorar, "
				+ "media, bom, excelente) "
				+ "VALUES (?, ?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, catAtiv.getCategoriaAvaliacao().getIdCategoriaAvaliacao());
		stmtScript.setInt(2, catAtiv.getAtividadeAvaliacao().getIdAtividadeAvaliacao());
		stmtScript.setFloat(3, catAtiv.getMelhorar());
		stmtScript.setFloat(4, catAtiv.getMedia());
		stmtScript.setFloat(5, catAtiv.getBom());
		stmtScript.setFloat(6, catAtiv.getExcelente());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;
	}

	public List<CategoriaAtividade> buscaCategoriaAtividade() throws SQLException {
		List<CategoriaAtividade> lista = new ArrayList<CategoriaAtividade>();
		
		stmtScript = con.prepareStatement("SELECT idCategoriaAtividade, c.idCategoriaAvaliacao, nmCategoria "
				+ "FROM categoriaAtividade ca "
				+ "INNER JOIN categoriaAvaliacao c "
				+ "ON ca.idCategoriaAvaliacao = c.idCategoriaAvaliacao "
				+ "WHERE ca.flCadastroAtivo = 1 ");
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			
			categoria.setIdCategoriaAvaliacao(rs.getInt("idCategoriaAvaliacao"));
			categoria.setNmCategoria(rs.getString("nmCategoria"));
			
			catAtiv.setIdCategoriaAtividade(rs.getInt("idCategoriaAtividade"));
			catAtiv.setCategoriaAvaliacao(categoria);
			
			lista.add(catAtiv);
		}
		return lista;
	}

	public boolean desativar(CategoriaAtividade catAtiv) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE categoriaAtividade "
				+ "SET flCadastroAtivo = 0 "
				+ "WHERE idCategoriaAtividade = ? ");
		
		stmtScript.setInt(1, catAtiv.getIdCategoriaAtividade());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;	
	}

//	public boolean inserir(CategoriaAvaliacao categoria) throws SQLException {
//		boolean retorno = false;
//		
//		stmtScript = con.prepareStatement("INSERT INTO categoriaAvaliacao "
//				+ "(idTipoCat, nmCategoria, idadeMinima, idadeMaxima, sexo) "
//				+ " VALUES (?, ?, ?, ?, ?)");
//		
//		stmtScript.setInt(1, categoria.getIdTipoCat());
//		stmtScript.setString(2, categoria.getNmCategoria());
//		stmtScript.setInt(3, categoria.getIdadeMinima());
//		stmtScript.setInt(4, categoria.getIdadeMaxima());
//		stmtScript.setString(5, categoria.getSexo());
//		
//		if(stmtScript.executeUpdate() > 0){
//			retorno = true;
//		}
//		return retorno;
//	}
}
