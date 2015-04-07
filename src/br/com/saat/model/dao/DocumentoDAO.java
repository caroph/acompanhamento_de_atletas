package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Documento;

public class DocumentoDAO {

	private Connection con;
	private PreparedStatement stmtScript;
	
	public DocumentoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public DocumentoDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public boolean inserir(Documento documento) throws SQLException{
		
		stmtScript = con.prepareStatement("INSERT INTO documento("
				+ "idAtleta, "
				+ "tpDocumento, "
				+ "srcDocumento, "
				+ "validadeDocumento) "
				+ "VALUES (?, ?, ?, ?)");
		
		stmtScript.setInt(1, documento.getIdPessoa());
		stmtScript.setInt(2, documento.getTpDocumento());
		stmtScript.setString(3, documento.getSrc());
		stmtScript.setDate(4, (Date) documento.getValidade());
		
		if(stmtScript.executeUpdate() > 0){
			return true;
		}		
		return false;
	}
}
