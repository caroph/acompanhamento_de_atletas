package br.com.saat.model.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
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
				+ " idNaipe, idCatTorneio, idTpTorneio, idGpTorneio, descricao) "
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
		
		stmtScript = con.prepareStatement("SELECT * "
				+ "FROM atletaTorneio "
				+ "WHERE idAtleta = ? AND idTorneio = ?");
		
		stmtScript.setInt(1, Integer.parseInt(idAtleta));
		stmtScript.setInt(2, idNovoTorneio);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if (!rs.next()) {
			stmtScript = con.prepareStatement("INSERT INTO atletaTorneio "
					+ "(idAtleta, idTorneio) "
					+ "VALUES (?, ?)");
			
			stmtScript.setInt(1, Integer.parseInt(idAtleta));
			stmtScript.setInt(2, idNovoTorneio);
			
			if(stmtScript.executeUpdate() > 0){
				retorno = true;
			}
		} else {
			retorno = true;
		}
		
		return retorno;		
	}

	public List<Torneio> buscarTorneios() throws SQLException {
		List<Torneio> lista = new ArrayList<Torneio>();
		
		stmtScript = con.prepareStatement("SELECT idTorneio, nome, dtInicial, dtFinal, idCatTorneio "
				+ "FROM torneio "
				+ "WHERE flCadastroAtivo = 1 ");
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Torneio torneio = new Torneio();
			torneio.setIdTorneio(rs.getInt(1));
			torneio.setNome(rs.getString(2));
			torneio.setDtInicial(rs.getDate(3));
			torneio.setDtFinal(rs.getDate(4));
			torneio.setIdCatTorneio(rs.getInt(5));
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
		
		stmtScript = con.prepareStatement("SELECT idTorneio, nome, local, estado, cidade, "
				+ "dtInicial, dtFinal, idNaipe, idCatTorneio, idTpTorneio, idGpTorneio, "
				+ "descricao "
				+ "FROM torneio "
				+ "WHERE idTorneio = ? ");
		
		stmtScript.setInt(1, idTorneio);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			torneio.setIdTorneio(rs.getInt("idTorneio"));
			torneio.setNome(rs.getString("nome"));
			torneio.setLocal(rs.getString("local"));
			torneio.setEstado(rs.getString("estado"));
			torneio.setCidade(rs.getString("cidade"));
			torneio.setDtInicial(rs.getDate("dtInicial"));
			torneio.setDtFinal(rs.getDate("dtFinal"));
			torneio.setIdNaipe(rs.getInt("idNaipe"));
			torneio.setIdCatTorneio(rs.getInt("idCatTorneio"));
			torneio.setIdTpTorneio(rs.getInt("idTpTorneio"));
			torneio.setIdGpTorneio(rs.getInt("idGpTorneio"));
			torneio.setDescricao(rs.getString("descricao"));
		}
		return torneio;
	}

	public List<Atleta> buscaAtletasPart(int idTorneio) throws SQLException {
		List<Atleta> lista = new ArrayList<Atleta>();
		
		stmtScript = con.prepareStatement("SELECT at.idAtleta, a.nome "
				+ "FROM atletatorneio at "
				+ "		INNER JOIN atleta a "
				+ "			ON at.idAtleta = a.idAtleta "
				+ "WHERE at.idTorneio = ? "
				+ "ORDER BY a.nome ");
		
		stmtScript.setInt(1, idTorneio);
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Atleta atleta = new Atleta();
			atleta.setIdPessoa(rs.getInt(1));
			atleta.setNome(rs.getString(2));
			lista.add(atleta);
		}
		return lista;
	}

	public boolean editar(Torneio torneio) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE torneio "
				+ "SET nome = ?, local = ?, estado = ?, cidade = ?, "
				+ "dtInicial = ?, dtFinal = ?, idNaipe = ?, idCatTorneio = ?, "
				+ "idTpTorneio = ?, idGpTorneio = ?, descricao = ? "
				+ "WHERE idTorneio = ?");
			
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
		stmtScript.setInt(12, torneio.getIdTorneio());
		
		if (stmtScript.executeUpdate() > 0){
			retorno= true;
		}
		
		return retorno;
	}

}
