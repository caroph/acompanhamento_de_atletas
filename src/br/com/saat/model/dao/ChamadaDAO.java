package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import br.com.saat.model.Chamada;
import br.com.saat.model.ConnectionFactory;

public class ChamadaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public ChamadaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public ChamadaDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public Chamada buscarChamadaPorData(Date data, int idDiaTreino){
		return null;
	}
}
