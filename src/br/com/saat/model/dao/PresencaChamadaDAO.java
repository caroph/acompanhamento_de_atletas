package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.saat.model.ConnectionFactory;

public class PresencaChamadaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public PresencaChamadaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public PresencaChamadaDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public void salvarPresencaChamada(int idChamada, int idAtleta,
			int estadoPresenca) {
		// TODO Auto-generated method stub
		
	}
}
