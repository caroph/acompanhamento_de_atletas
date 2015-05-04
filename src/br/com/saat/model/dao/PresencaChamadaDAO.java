package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.PresencaChamada;

public class PresencaChamadaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public PresencaChamadaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public PresencaChamadaDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public boolean salvarPresencaChamada(int idChamada, int idAtleta,
			int estadoPresenca, String justificativa) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO presencachamada (idChamada, idAtleta, estadoPresenca, "
				+ "justificativa) VALUES (?, ?, ?, ?)");
		
		stmtScript.setInt(1, idChamada);
		stmtScript.setInt(2, idAtleta);
		stmtScript.setInt(3, estadoPresenca);
		stmtScript.setString(4, justificativa);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}
		return false;
	}

	public boolean salvarPresencaChamada(PresencaChamada presenca) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO presencachamada (idChamada, idAtleta, estadoPresenca, "
				+ "nrQuadra, justificativa) VALUES (?, ?, ?, ?, ?)");
		
		stmtScript.setInt(1, presenca.getIdChamada());
		stmtScript.setInt(2, presenca.getIdAtleta());
		stmtScript.setInt(3, presenca.getEstadoPresenca());
		stmtScript.setInt(4, presenca.getNrQuadra());
		stmtScript.setString(5, presenca.getJustificativa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}
		return false;
	}

	public List<PresencaChamada> buscarPresencasPorChamada(int idChamada) throws SQLException {
		List<PresencaChamada> lista = new ArrayList<PresencaChamada>();
		
		stmtScript = con.prepareStatement("SELECT pc.idPresencaChamada, pc.idChamada, pc.idAtleta, pc.estadoPresenca, "
				+ "pc.nrQuadra, a.nome FROM presencachamada pc JOIN atleta a ON pc.idAtleta = a.idAtleta "
				+ "WHERE pc.estadoPresenca = 1 AND pc.idChamada = " + idChamada);
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			PresencaChamada presenca = new PresencaChamada();
			presenca.setIdPresencaChamada(rs.getInt(1));
			presenca.setIdChamada(rs.getInt(2));
			presenca.setIdAtleta(rs.getInt(3));
			presenca.setEstadoPresenca(rs.getInt(4));
			presenca.setNrQuadra(rs.getInt(5));
			Atleta atleta = new Atleta();
			atleta.setIdPessoa(rs.getInt(3));
			atleta.setNome(rs.getString(6));
			presenca.setAtleta(atleta);
			lista.add(presenca);
		}
		return lista;
	}

	public boolean excluirPresencaChamada(int idChamada) throws SQLException {
		int rows = 0;		
		stmtScript = con.prepareStatement("DELETE FROM presencachamada WHERE idChamada = ?");
		stmtScript.setInt(1, idChamada);
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;
		}			
		return false;
	}
}
