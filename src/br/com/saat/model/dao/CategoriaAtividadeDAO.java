package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.saat.model.CategoriaAtividade;
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
	
//	public List<CategoriaAvaliacao> buscarCategorias() throws SQLException {
//		List<CategoriaAvaliacao> lista = new ArrayList<CategoriaAvaliacao>();
//		
//		stmtScript = con.prepareStatement("SELECT idCategoriaAvaliacao, idTipoCat, nmCategoria, "
//				+ "idadeMinima, idadeMaxima, sexo "
//				+ "FROM categoriaAvaliacao "
//				+ "WHERE flCadastroAtivo = 1");
//		
//		ResultSet rs = stmtScript.executeQuery();
//		
//		while(rs.next()){
//			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
//			categoria.setIdCategoriaAvaliacao(rs.getInt(1));
//			categoria.setIdTipoCat(rs.getInt(2));
//			categoria.setNmCategoria(rs.getString(3));
//			categoria.setIdadeMinima(rs.getInt(4));
//			categoria.setIdadeMaxima(rs.getInt(5));
//			categoria.setSexo(rs.getString(6));
//			lista.add(categoria);
//		}
//		return lista;
//	}
//
//	public boolean desativar(CategoriaAvaliacao categoria) throws SQLException {
//		boolean retorno = false;
//		
//		stmtScript = con.prepareStatement("UPDATE categoriaAvaliacao "
//				+ "SET flCadastroAtivo = 0 "
//				+ "WHERE idCategoriaAvaliacao = ? ");
//		
//		stmtScript.setInt(1, categoria.getIdCategoriaAvaliacao());
//		
//		if(stmtScript.executeUpdate() > 0){
//			retorno = true;
//		}
//		return retorno;	
//	}
//
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
