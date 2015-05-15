package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Observacao;
import br.com.saat.model.Usuario;

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

	public List<Observacao> buscarObservacoesAtivas(int idUsuario) throws SQLException {
		List<Observacao> lista = new ArrayList<Observacao>();
		
		stmtScript = con.prepareStatement("SELECT o.idObservacao, o.idAtleta, a.nome, o.idUsuario, u.perfil, u.nome, "
				+ "o.dsObservacao, o.gravidade, o.dtValidade, o.flCadastroAtivo "
				+ "FROM observacao o "
				+ "JOIN visualizacaoobservacao v on o.idObservacao = v.idObservacao "
				+ "JOIN atleta a ON o.idAtleta = a.idAtleta "
				+ "JOIN usuario u ON o.idUsuario = u.idUsuario "
				+ "WHERE o.flCadastroAtivo = 1 AND o.idUsuario != ? AND dtVisualizacao IS NULL AND v.idUsuario = ?");
		stmtScript.setInt(1, idUsuario);
		stmtScript.setInt(2, idUsuario);
		
		ResultSet rs = stmtScript.executeQuery();
		while(rs.next()){
			Observacao o = new Observacao();
			o.setIdObservacao(rs.getInt(1));
			
			Atleta a = new Atleta();
			a.setIdPessoa(rs.getInt(2));
			a.setNome(rs.getString(3));
			o.setAtleta(a);
			
			Usuario u = new Usuario();
			u.setIdPessoa(rs.getInt(4));
			u.setPerfil(rs.getInt(5));
			u.setNome(rs.getString(6));
			o.setUsuario(u);
			
			o.setDsObservacao(rs.getString(7));
			o.setGravidade(rs.getInt(8));
			o.setDtValidade(rs.getDate(9));
			o.setFlCadastroAtivo(rs.getInt(10));
			
			lista.add(o);
		}
		return lista;
	}

	public List<Observacao> buscarMinhasObservacoes(int idUsuario) throws SQLException {
		List<Observacao> lista = new ArrayList<Observacao>();
		
		stmtScript = con.prepareStatement("SELECT o.idObservacao, o.idAtleta, a.nome, o.dsObservacao, o.gravidade, "
				+ "o.dtValidade, o.dtGeracao, o.flCadastroAtivo "
				+ "FROM observacao o "
				+ "JOIN atleta a ON o.idAtleta = a.idAtleta "
				+ "WHERE idUsuario = ?");
		stmtScript.setInt(1, idUsuario);
		
		ResultSet rs = stmtScript.executeQuery();
		while(rs.next()){
			Observacao o = new Observacao();
			o.setIdObservacao(rs.getInt(1));
			
			Atleta a = new Atleta();
			a.setIdPessoa(rs.getInt(2));
			a.setNome(rs.getString(3));
			o.setAtleta(a);
			
			o.setDsObservacao(rs.getString(4));
			o.setGravidade(rs.getInt(5));
			o.setDtValidade(rs.getDate(6));
			o.setDtGeracao(rs.getDate(7));
			o.setFlCadastroAtivo(rs.getInt(8));
			
			lista.add(o);
		}
		return lista;
	}

	public boolean desativarObservacao(int idObservacao) throws SQLException {
		stmtScript = con.prepareStatement("UPDATE observacao SET flCadastroAtivo = 0 WHERE idObservacao = ? ");
		stmtScript.setInt(1, idObservacao);
		
		int rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}
		return false;
	}
}
