package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AtividadeAvaliacao;
import br.com.saat.model.ConnectionFactory;

public class AtividadeAvaliacaoDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public AtividadeAvaliacaoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public AtividadeAvaliacaoDAO(Connection con) throws Exception{
        this.con = con;        
    }
	public List<AtividadeAvaliacao> buscarAtividades(int tipoConsulta, int idCategoria) throws SQLException {
		// tipoConsulta: 0 = Geral/ 1 = LEFT JOIN Com base na categoria/ 
		List<AtividadeAvaliacao> lista = new ArrayList<AtividadeAvaliacao>();
		
		if (tipoConsulta == 0) {
			
			stmtScript = con.prepareStatement("SELECT idAtividadeAvaliacao, idUnidadeDeMedida, capacidade, teste "
					+ "FROM atividadeavaliacao "
					+ "WHERE flCadastroAtivo = 1");
			
		} else {
			
			stmtScript = con.prepareStatement("SELECT aa.idAtividadeAvaliacao, idUnidadeDeMedida, capacidade, teste "
					+ "FROM atividadeavaliacao aa "
					+ "LEFT JOIN categoriaatividade ca "
					+ "ON ca.idAtividadeAvaliacao = aa.idAtividadeAvaliacao "
					+ "AND ca.idCategoriaAvaliacao = ? "
					+ "AND ca.flCadastroAtivo = 1 "
					+ "WHERE aa.flCadastroAtivo = 1 "
					+ "AND idCategoriaAtividade IS NULL ");
			
			stmtScript.setInt(1, idCategoria);
			
		} 
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			AtividadeAvaliacao atividade = new AtividadeAvaliacao();
			atividade.setIdAtividadeAvaliacao(rs.getInt("idAtividadeAvaliacao"));
			atividade.setIdUnidadeDeMedida(rs.getInt("idUnidadeDeMedida"));
			atividade.setCapacidade(rs.getString("capacidade"));
			atividade.setTeste(rs.getString("teste"));
			lista.add(atividade);
		}
		return lista;
	}

	public boolean desativar(AtividadeAvaliacao atividade) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE atividadeavaliacao "
				+ "SET flCadastroAtivo = 0 "
				+ "WHERE idAtividadeAvaliacao = ? ");
		
		stmtScript.setInt(1, atividade.getIdAtividadeAvaliacao());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;	
	}

	public boolean inserir(AtividadeAvaliacao atividade) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("INSERT INTO atividadeavaliacao "
				+ "(idUnidadeDeMedida, capacidade, teste) "
				+ " VALUES (?, ?, ?)");
		
		stmtScript.setInt(1, atividade.getIdUnidadeDeMedida());
		stmtScript.setString(2, atividade.getCapacidade());
		stmtScript.setString(3, atividade.getTeste());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;
	}

}
