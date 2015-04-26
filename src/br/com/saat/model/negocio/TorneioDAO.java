package br.com.saat.model.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.dao.Torneio;

import com.mysql.jdbc.Statement;

public class TorneioDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public TorneioDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public TorneioDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public int inserir(Torneio torneio) throws SQLException {
		int idNovoTorneio = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO torneio "
				+ "(nome, local, estado, cidade, dtInicial, dtFinal, "
				+ " idNaipe, idCatTorneio, idTpTorneio, idGpTorneio, dscTorneio) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		stmtScript.setString(1, torneio.getNome());
		stmtScript.setString(2, torneio.getLocal());
		stmtScript.setString(3, torneio.getEstado());
		stmtScript.setString(4, torneio.getCidade());
		stmtScript.setDate(5, new java.sql.Date(torneio.getDtInicial().getTime()));
		stmtScript.setDate(6, new java.sql.Date(torneio.getDtFinal().getTime()));
		stmtScript.setInt(7, torneio.getIdNaipe());
		stmtScript.setInt(8, torneio.getIdCatTorneio());
		stmtScript.setInt(9, torneio.getIdTpTorneio());
		stmtScript.setInt(10, torneio.getIdGpTorneio());
		stmtScript.setString(11, torneio.getDescricao());
		
		stmtScript.executeUpdate();
		ResultSet rs = stmtScript.getGeneratedKeys();
		
		if(rs.next()){
			idNovoTorneio = rs.getInt(1);
		}
		return idNovoTorneio;
	}

	public boolean inserirAtletasPart(String idAtleta, int idNovoTorneio) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("INSERT INTO atletaTorneio "
				+ "(idAtleta, idTorneio) "
				+ "VALUES (?, ?)");
		
		stmtScript.setInt(1, Integer.parseInt(idAtleta));
		stmtScript.setInt(2, idNovoTorneio);
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;		
	}

}
