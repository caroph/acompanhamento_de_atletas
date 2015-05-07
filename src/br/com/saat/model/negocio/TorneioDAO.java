package br.com.saat.model.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Usuario;
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

	public int inserir(Torneio torneio, Usuario usuario) throws SQLException {
		int idNovoTorneio = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO torneio "
				+ "(nome, local, estado, cidade, dtInicial, dtFinal, "
				+ " idNaipe, idCatTorneio, idTpTorneio, idGpTorneio, "
				+ " descricao, idUsuCriacao) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS);
		
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
		stmtScript.setInt(12, usuario.getIdPessoa());
		
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
		
		stmtScript = con.prepareStatement("SELECT idTorneio, nome, dtInicial, dtFinal, idCatTorneio, flFinalizado "
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
			torneio.setFlFinalizado(rs.getBoolean(6));
			lista.add(torneio);
		}
		return lista;
	}

	public boolean desativar(Torneio torneio, Usuario usuario) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE torneio "
				+ "SET flCadastroAtivo = 0, "
				+ "idUsuEdicao = ? "
				+ "WHERE idTorneio = ? ");
		
		stmtScript.setInt(1, usuario.getIdPessoa());
		stmtScript.setInt(2, torneio.getIdTorneio());
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		return retorno;	
	}

	public Torneio buscaTorneio(int idTorneio) throws SQLException {
		Torneio torneio = new Torneio();
		
		stmtScript = con.prepareStatement("SELECT idTorneio, t.nome, local, estado, cidade, "
				+ "dtInicial, dtFinal, idNaipe, idCatTorneio, idTpTorneio, idGpTorneio, "
				+ "descricao, inscritosGeral, inscritosClube, idDestaque, a.nome as nomeAtleta, "
				+ "motivoDestaque, fotografo, encaminhamentoMkt  "
				+ "FROM torneio t "
				+ "		LEFT JOIN atleta a "
				+ "			ON t.idDestaque = a.idAtleta "
				+ "WHERE idTorneio = ? "
				+ "	AND t.flCadastroAtivo = 1 ");
		
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
			torneio.setInscritosGeral(rs.getInt("inscritosGeral"));
			torneio.setInscritosClube(rs.getInt("inscritosClube"));
			torneio.setMotivoDestaque(rs.getString("motivoDestaque"));
			torneio.setFotografo(rs.getString("fotografo"));
			torneio.setEncaminhamentoMkt(rs.getDate("encaminhamentoMkt"));
			
			Atleta atleta = new Atleta();
			atleta.setIdPessoa(rs.getInt("idDestaque"));
			atleta.setNome(rs.getString("nomeAtleta"));
			
			torneio.setIdDestaque(atleta);
		}
		return torneio;
	}

	public List<Atleta> buscaAtletasPart(int idTorneio) throws SQLException {
		List<Atleta> lista = new ArrayList<Atleta>();
		
		stmtScript = con.prepareStatement("SELECT at.idAtleta, a.nome, art.colocacao, art.observacao "
				+ "FROM atletatorneio at "
				+ "		INNER JOIN atleta a "
				+ "			ON at.idAtleta = a.idAtleta "
				+ "		LEFT JOIN atletaResultadoTorneio art "
				+ "			ON a.idAtleta = art.idAtleta "
				+ "				AND at.idTorneio = art.idTorneio "
				+ "WHERE at.idTorneio = ? "
				+ "ORDER BY a.nome ");
		
		stmtScript.setInt(1, idTorneio);
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Atleta atleta = new Atleta();
			atleta.setIdPessoa(rs.getInt(1));
			atleta.setNome(rs.getString(2));
			atleta.setColocacao(rs.getString(3));
			atleta.setObservacao(rs.getString(4));
			lista.add(atleta);
		}
		return lista;
	}

	public boolean editar(Torneio torneio, Usuario usuario) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE torneio "
				+ "SET nome = ?, local = ?, estado = ?, cidade = ?, "
				+ "dtInicial = ?, dtFinal = ?, idNaipe = ?, idCatTorneio = ?, "
				+ "idTpTorneio = ?, idGpTorneio = ?, descricao = ?, "
				+ "idUsuEdicao = ? "
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
		stmtScript.setInt(12, usuario.getIdPessoa());
		stmtScript.setInt(13, torneio.getIdTorneio());
		
		if (stmtScript.executeUpdate() > 0){
			retorno= true;
		}
		
		return retorno;
	}

	public boolean finalizar(Torneio torneio, Usuario usuario) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("UPDATE torneio "
				+ "SET inscritosGeral = ?, inscritosClube = ?, idDestaque = ?, "
				+ "motivoDestaque = ?, fotografo = ?, encaminhamentoMkt = ?,"
				+ "idUsuEdicao = ?, flFinalizado = 1 "
				+ "WHERE idTorneio = ?");
			
		stmtScript.setInt(1, torneio.getInscritosGeral());
		stmtScript.setInt(2, torneio.getInscritosClube());
		stmtScript.setInt(3, torneio.getIdDestaque().getIdPessoa());
		stmtScript.setString(4, torneio.getMotivoDestaque());
		stmtScript.setString(5, torneio.getFotografo());
		stmtScript.setDate(6, new java.sql.Date(torneio.getEncaminhamentoMkt().getTime()));
		stmtScript.setInt(7, usuario.getIdPessoa());
		stmtScript.setInt(8, torneio.getIdTorneio());
		
		if (stmtScript.executeUpdate() > 0){
			retorno= true;
		}
		
		return retorno;
	}

	public boolean inserirResulAtletasPart(Atleta atleta, int idTorneio) throws SQLException {
		boolean retorno = false;
		
		stmtScript = con.prepareStatement("SELECT * "
				+ "FROM atletaResultadoTorneio "
				+ "WHERE idAtleta = ? AND idTorneio = ?");
		
		stmtScript.setInt(1, atleta.getIdPessoa());
		stmtScript.setInt(2, idTorneio);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if (!rs.next()) {
			stmtScript = con.prepareStatement("INSERT INTO atletaResultadoTorneio "
					+ "(idAtleta, idTorneio, colocacao, observacao) "
					+ "VALUES (?, ?, ?, ?)");
			
			stmtScript.setInt(1, atleta.getIdPessoa());
			stmtScript.setInt(2, idTorneio);
			stmtScript.setString(3, atleta.getColocacao());
			stmtScript.setString(4, atleta.getObservacao());
			
		} else {
			
			int idAtletaResTorneio = rs.getInt("idAtletaResTorneio");
			
			stmtScript = con.prepareStatement("UPDATE atletaResultadoTorneio "
					+ "SET colocacao = ?, observacao = ? "
					+ "WHERE idAtletaResTorneio = ? ");
			
			stmtScript.setString(1, atleta.getColocacao());
			stmtScript.setString(2, atleta.getObservacao());
			stmtScript.setInt(3, idAtletaResTorneio);
		}
		
		if(stmtScript.executeUpdate() > 0){
			retorno = true;
		}
		
		return retorno;		
	}

	public boolean reciclarAtletasPart(String idAtletas, int idNovoTorneio) throws SQLException {
		boolean retorno = false;
		String condicao = "";
		
		if (!"".equals(idAtletas)) {
			condicao = "AND idAtleta NOT IN (" + idAtletas + ")";
		} 
		
		stmtScript = con.prepareStatement("DELETE "
				+ "FROM atletaTorneio "
				+ "WHERE idTorneio = ? "
				+ condicao);
		
		stmtScript.setInt(1, idNovoTorneio);
		
		if(stmtScript.executeUpdate() >= 0){
			retorno = true;
		}
		return retorno;	
	}

}
