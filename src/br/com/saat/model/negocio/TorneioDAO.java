package br.com.saat.model.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Torneio> buscarTorneios() throws SQLException {
		List<Torneio> lista = new ArrayList<Torneio>();
		
		stmtScript = con.prepareStatement("SELECT idTorneio, nome, dtInicial, dtFinal "
				+ "FROM torneio "
				+ "WHERE flCadastroAtivo = 1 ");
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Torneio torneio = new Torneio();
			torneio.setIdTorneio(rs.getInt(1));
			torneio.setNome(rs.getString(2));
			torneio.setDtInicial(rs.getDate(3));
			torneio.setDtFinal(rs.getDate(4));
			lista.add(torneio);
		}
		
		return lista;
	}

	public boolean desativar(Torneio torneio) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE torneio "
				+ "SET flCadastroAtivo = 0 "
				+ "WHERE idTorneio = ? ");
		
		stmtScript.setInt(1, torneio.getIdTorneio());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;	
	}

	public Torneio buscaTorneio(int idTorneio) throws SQLException {
		Torneio torneio = new Torneio();
		
		stmtScript = con.prepareStatement("SELECT idTorneio, nome, local, estado, cidade "
				+ "dtInicial, dtFinal, idNaipe, idCatTorneio, idTpTorneio, idGpTorneio, "
				+ "dscTorneio "
				+ "FROM torneio "
				+ "WHERE idTorneio = ? ");
		
		stmtScript.setInt(1, torneio.getIdTorneio());
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			torneio.setIdTorneio(rs.getInt(1));
			torneio.setNome(rs.getString(2));
			torneio.setLocal(rs.getString(3));
			torneio.setEstado(rs.getString(4));
			torneio.setCidade(rs.getString(5));
			torneio.setDtInicial(rs.getDate(6));
			torneio.setDtFinal(rs.getDate(7));
			torneio.setIdNaipe(rs.getInt(8));
			torneio.setIdCatTorneio(rs.getInt(9));
			torneio.setIdTpTorneio(rs.getInt(10));
			torneio.setIdGpTorneio(rs.getInt(11));
			torneio.setDescricao(rs.getString(12));
		}
		return torneio;
	}

}
