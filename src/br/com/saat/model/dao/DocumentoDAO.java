package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		stmtScript.setDate(4, documento.getValidade() != null ? new java.sql.Date(documento.getValidade().getTime()) : null);
		
		if(stmtScript.executeUpdate() > 0){
			return true;
		}		
		return false;
	}
	
	public ArrayList<Documento> buscarTodosAtleta(int idPessoa) throws Exception{
		ArrayList<Documento> lista = new ArrayList<Documento>();
		stmtScript = con.prepareStatement("SELECT * FROM documento WHERE idAtleta = ? AND (validadeDocumento >= NOW() OR validadeDocumento IS NULL)");
		
		stmtScript.setInt(1, idPessoa);
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Documento documento = new Documento();
			documento.setTpDocumento(rs.getInt("tpDocumento"));
			documento.setSrc(rs.getString("srcDocumento"));
			documento.setValidade(rs.getDate("validadeDocumento"));
			
			lista.add(documento);
		}
		
		return lista;
	}

	public int exists(Documento documento) throws Exception {
		stmtScript = con.prepareStatement("SELECT idDocumento FROM documento WHERE idAtleta = ? AND TpDocumento = ? AND(validadeDocumento >= NOW() OR validadeDocumento IS NULL) LIMIT 1");
		stmtScript.setInt(1, documento.getIdPessoa());
		stmtScript.setInt(2, documento.getTpDocumento());
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			return rs.getInt("idDocumento");
		}
		
		return 0;
	}

	public boolean alterar(Documento documento) throws Exception {
		stmtScript = con.prepareStatement("UPDATE documento SET "
				+ "idAtleta = ?, "
				+ "tpDocumento = ?, "
				+ "srcDocumento = ?, "
				+ "validadeDocumento = ? WHERE idDocumento = ?");
		
		stmtScript.setInt(1, documento.getIdPessoa());
		stmtScript.setInt(2, documento.getTpDocumento());
		stmtScript.setString(3, documento.getSrc());
		stmtScript.setDate(4, documento.getValidade() != null ? new java.sql.Date(documento.getValidade().getTime()) : null);
		stmtScript.setInt(5, documento.getIdDocumento());
		
		if(stmtScript.executeUpdate() > 0){
			return true;
		}		
		return false;
	}
}
