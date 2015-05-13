package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.saat.model.Chamada;
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
				+ "dtValidade)"
				+ "VALUES (?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, observacao.getAtleta().getIdPessoa());
		stmtScript.setInt(2, observacao.getUsuario().getIdPessoa());
		stmtScript.setString(3, observacao.getDsObservacao());
		stmtScript.setInt(4, observacao.getGravidade());
		stmtScript.setDate(5, new java.sql.Date(observacao.getDtValidade().getTime()));
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			observacao = buscarObservacaoPorDataAtletaUsuario(new Date(), observacao.getAtleta().getIdPessoa(), 
					observacao.getUsuario().getIdPessoa());
			return observacao.getIdObservacao();
		}	
		
		return 0;
	}

	private Observacao buscarObservacaoPorDataAtletaUsuario(Date date,
			int idPessoa, int idPessoa2) {
//		stmtScript = con.prepareStatement("SELECT idChamada, idUsuario, idDiaTreino, dtChamada "
//				+ "FROM chamada WHERE idDiaTreino = ? AND dtChamada = ?");
//		
//		stmtScript.setInt(1, idDiaTreino);
//		stmtScript.setDate(2, new java.sql.Date(data.getTime()));
//		
//		ResultSet rs = stmtScript.executeQuery();
//		
//		Chamada chamada = new Chamada();
//		if(rs.next()){		
//			chamada.setIdChamada(rs.getInt("idChamada"));
//			chamada.setIdUsuario(rs.getInt("idUsuario"));
//			chamada.setIdDiaTreino(rs.getInt("idDiaTreino"));
//			chamada.setDtChamada(rs.getDate("dtChamada"));
//		}
//		return chamada;
		return null;
	}
}
