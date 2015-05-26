package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AtividadeAvaliacao;
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
		
		stmtScript = con.prepareStatement("INSERT INTO categoriaatividade "
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
		
		stmtScript = con.prepareStatement("SELECT distinct c.idCategoriaAvaliacao, nmCategoria "
				+ "FROM categoriaatividade ca "
				+ "INNER JOIN categoriaavaliacao c "
				+ "ON ca.idCategoriaAvaliacao = c.idCategoriaAvaliacao "
				+ "WHERE ca.flCadastroAtivo = 1 ");
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			CategoriaAvaliacao categoria = new CategoriaAvaliacao();
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			
			categoria.setIdCategoriaAvaliacao(rs.getInt("idCategoriaAvaliacao"));
			categoria.setNmCategoria(rs.getString("nmCategoria"));
			
			catAtiv.setCategoriaAvaliacao(categoria);
			
			lista.add(catAtiv);
		}
		return lista;
	}

	public boolean desativar(CategoriaAtividade catAtiv) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE categoriaatividade "
				+ "SET flCadastroAtivo = 0 "
				+ "WHERE idCategoriaAvaliacao = ? AND flCadastroAtivo = 1");
		
		stmtScript.setInt(1, catAtiv.getCategoriaAvaliacao().getIdCategoriaAvaliacao());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;	
	}

	public List<CategoriaAtividade> buscarAtividades(
			CategoriaAvaliacao categoriaBase) throws SQLException {
		List<CategoriaAtividade> lista = new ArrayList<CategoriaAtividade>();
		
		stmtScript = con.prepareStatement("SELECT capacidade, teste, idUnidadeDeMedida, melhorar, media, bom, excelente "
				+ "FROM categoriaatividade ca "
				+ "INNER JOIN atividadeavaliacao aa "
				+ "ON ca.idAtividadeAvaliacao = aa.idAtividadeAvaliacao "
				+ "WHERE ca.idCategoriaAvaliacao = ? AND ca.flCadastroAtivo = 1 "
				+ "ORDER BY capacidade, teste ");
		
		stmtScript.setInt(1, categoriaBase.getIdCategoriaAvaliacao());
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			AtividadeAvaliacao atividade = new AtividadeAvaliacao();
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			
			atividade.setCapacidade(rs.getString("capacidade"));
			atividade.setTeste(rs.getString("teste"));
			atividade.setIdUnidadeDeMedida(rs.getInt("idUnidadeDeMedida"));
			
			catAtiv.setAtividadeAvaliacao(atividade);
			catAtiv.setMelhorar(rs.getFloat("melhorar"));
			catAtiv.setMedia(rs.getFloat("media"));
			catAtiv.setBom(rs.getFloat("bom"));
			catAtiv.setExcelente(rs.getFloat("excelente"));
			
			lista.add(catAtiv);
		}
		return lista;
	}

	public boolean editar(CategoriaAtividade catAtiv) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE categoriaatividade "
				+ "SET melhorar = ?, media = ?, bom = ?, excelente = ? "
				+ "WHERE idCategoriaAvaliacao = ? AND idAtividadeAvaliacao = ? "
				+ "AND flCadastroAtivo = 1");
		
		stmtScript.setFloat(1, catAtiv.getMelhorar());
		stmtScript.setFloat(2, catAtiv.getMedia());
		stmtScript.setFloat(3, catAtiv.getBom());
		stmtScript.setFloat(4, catAtiv.getExcelente());
		stmtScript.setInt(5, catAtiv.getCategoriaAvaliacao().getIdCategoriaAvaliacao());
		stmtScript.setInt(6, catAtiv.getAtividadeAvaliacao().getIdAtividadeAvaliacao());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;
	}

	public boolean reciclarCatAtiv(String idCategoria, String idAtividades) throws SQLException {
		boolean retorno = false;
		String condicao = "";
		
		if (!"".equals(idAtividades)) {
			condicao = "AND idAtividadeAvaliacao NOT IN (" + idAtividades + ")";
		} 
		
		stmtScript = con.prepareStatement("UPDATE categoriaatividade "
				+ "SET flCadastroAtivo = 0 "
				+ "WHERE idCategoriaAvaliacao = ? "
				+ condicao);
		
		stmtScript.setInt(1, Integer.parseInt(idCategoria));
		
		if(stmtScript.executeUpdate() >= 0){
			retorno = true;
		}
		return retorno;
	}

	public List<CategoriaAtividade> buscarAtividadesCat(int idCategoria) throws SQLException {
	//2 = INNER JOIN Com base na categoria
		List<CategoriaAtividade> lista = new ArrayList<CategoriaAtividade>();
		
		stmtScript = con.prepareStatement("SELECT aa.idAtividadeAvaliacao, idUnidadeDeMedida, capacidade, teste, "
				+ "melhorar, media, bom, excelente "
				+ "FROM atividadeavaliacao aa "
				+ "INNER JOIN categoriaatividade ca "
				+ "ON ca.idAtividadeAvaliacao = aa.idAtividadeAvaliacao "
				+ "AND ca.idCategoriaAvaliacao = ? "
				+ "AND ca.flCadastroAtivo = 1 "
				+ "WHERE aa.flCadastroAtivo = 1 ");
		
		stmtScript.setInt(1, idCategoria);
			
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			AtividadeAvaliacao atividade = new AtividadeAvaliacao();
			CategoriaAtividade catAtiv = new CategoriaAtividade();
			
			atividade.setIdAtividadeAvaliacao(rs.getInt("idAtividadeAvaliacao"));
			atividade.setIdUnidadeDeMedida(rs.getInt("idUnidadeDeMedida"));
			atividade.setCapacidade(rs.getString("capacidade"));
			atividade.setTeste(rs.getString("teste"));
			
			catAtiv.setAtividadeAvaliacao(atividade);
			catAtiv.setMelhorar(rs.getFloat("melhorar"));
			catAtiv.setMedia(rs.getFloat("media"));
			catAtiv.setBom(rs.getFloat("bom"));
			catAtiv.setExcelente(rs.getFloat("excelente"));
			
			lista.add(catAtiv);
		}
		return lista;
	}

}
