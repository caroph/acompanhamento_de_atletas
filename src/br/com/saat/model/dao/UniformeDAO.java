package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.ItemRetirada;
import br.com.saat.model.OperacaoEstoqueUniforme;
import br.com.saat.model.RetiradaUniforme;
import br.com.saat.model.Uniforme;

public class UniformeDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public UniformeDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public UniformeDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public int salvarUniforme(Uniforme uniforme, String optEstoque) throws Exception {
		int idUniforme = 0;
		
		Integer quantidade = buscarQtdTipoUniforme(uniforme.getTpUniforme(), uniforme.getTamanhoUniforme());
		if(quantidade == null){	
			if("I".equals(optEstoque)){
				stmtScript = con.prepareStatement("INSERT INTO uniforme (tpuniforme, tamanhouniforme, quantidadeestoque) "
						+ "VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
				stmtScript.setInt(1, uniforme.getTpUniforme());
				stmtScript.setInt(2, uniforme.getTamanhoUniforme());
				stmtScript.setInt(3, uniforme.getQuantidadeUniforme());
			} else{
				throw new Exception("Falha na operação. Não existem "+ uniforme.getNomeTpUniforme() +"s suficientes disponíveis em estoque");
			}
			stmtScript.executeUpdate();
			ResultSet rs = stmtScript.getGeneratedKeys();
			
			if(rs.next()){
				idUniforme = rs.getInt(1);
			}
			
		}else{		
			if("I".equals(optEstoque)){
				stmtScript = con.prepareStatement("UPDATE uniforme SET quantidadeestoque = ? "
						+ "WHERE tpuniforme = ? AND tamanhouniforme = ?");
				stmtScript.setInt(1, uniforme.getQuantidadeUniforme() + quantidade);
				stmtScript.setInt(2, uniforme.getTpUniforme());
				stmtScript.setInt(3, uniforme.getTamanhoUniforme());
			}else{
				if(quantidade < uniforme.getQuantidadeUniforme()){
					throw new Exception("Falha na operação. Não existem "+ uniforme.getNomeTpUniforme() +"s suficientes disponíveis em estoque");
				}else{
					stmtScript = con.prepareStatement("UPDATE uniforme SET quantidadeestoque = ? "
							+ "WHERE tpuniforme = ? AND tamanhouniforme = ?");
					stmtScript.setInt(1, quantidade - uniforme.getQuantidadeUniforme());
					stmtScript.setInt(2, uniforme.getTpUniforme());
					stmtScript.setInt(3, uniforme.getTamanhoUniforme());
				}
			}	
			int row = stmtScript.executeUpdate();
			if(row > 0){
				idUniforme = buscarIdUniforme(uniforme);
			}
		}		
		
		return idUniforme;
	}

	private Integer buscarQtdTipoUniforme(int tpUniforme, int tamanho) throws SQLException {
		stmtScript = con.prepareStatement("SELECT quantidadeestoque FROM uniforme "
				+ "WHERE tpuniforme = ? AND tamanhouniforme = ?");
		stmtScript.setInt(1, tpUniforme);
		stmtScript.setInt(2, tamanho);
		ResultSet rs = stmtScript.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return null;
	}

	public List<Uniforme> buscarEstoque() throws SQLException {
		List<Uniforme> lista = new ArrayList<Uniforme>();
		
		stmtScript = con.prepareStatement("SELECT idUniforme, tpUniforme, tamanhoUniforme, quantidadeEstoque "
				+ "FROM uniforme");
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Uniforme uniforme = new Uniforme();
			uniforme.setIdUniforme(rs.getInt(1));
			uniforme.setTpUniforme(rs.getInt(2));
			uniforme.setTamanhoUniforme(rs.getInt(3));
			uniforme.setQuantidadeUniforme(rs.getInt(4));
			
			lista.add(uniforme);
		}
		return lista;
	}

	public boolean buscarEstoquePorUniforme(Uniforme uniforme) throws Exception {
		Integer quantidade = buscarQtdTipoUniforme(uniforme.getTpUniforme(), uniforme.getTamanhoUniforme());
		
		if(quantidade == null || quantidade < uniforme.getQuantidadeUniforme()){
			throw new Exception("Não existem "+ uniforme.getNomeTpUniforme() +"s " + " com  o tamanho "+ uniforme.getNomeTamanhoUniforme() + " suficientes disponíveis em estoque");
		}
		return true;
	}
	
	public int buscarIdUniforme(Uniforme uniforme) throws SQLException{
		stmtScript = con.prepareStatement("SELECT idUniforme FROM uniforme "
				+ "WHERE tpuniforme = ? AND tamanhouniforme = ?");
		stmtScript.setInt(1, uniforme.getTpUniforme());
		stmtScript.setInt(2, uniforme.getTamanhoUniforme());
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}

	public int buscarRetirada(RetiradaUniforme retirada) throws SQLException {
		stmtScript = con.prepareStatement("SELECT idRetiradaUniforme FROM retiradauniforme "
				+ "WHERE idUsuario = ? AND idAtleta = ? AND dtRetirada = ?");
		stmtScript.setInt(1, retirada.getUsuario().getIdPessoa());
		stmtScript.setInt(2, retirada.getAtleta().getIdPessoa());
		stmtScript.setDate(3, new java.sql.Date(retirada.getDataRetirada().getTime()));
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}

	public int salvarRetiradaUniforme(RetiradaUniforme retirada) throws SQLException {
		stmtScript = con.prepareStatement("INSERT INTO retiradauniforme (idUsuario, idAtleta, dtRetirada) "
				+ "VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
		stmtScript.setInt(1, retirada.getUsuario().getIdPessoa());
		stmtScript.setInt(2, retirada.getAtleta().getIdPessoa());
		stmtScript.setDate(3, new java.sql.Date(retirada.getDataRetirada().getTime()));
		
		stmtScript.executeUpdate();
		ResultSet rs = stmtScript.getGeneratedKeys();
		
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}

	public boolean salvarItemUniforme(ItemRetirada item) throws SQLException {
		int rows = 0;
		stmtScript = con.prepareStatement("INSERT INTO itemretirada (idRetiradaUniforme, idUniforme, quantidade) "
				+ "VALUES(?,?,?)");
		stmtScript.setInt(1, item.getRetirada().getIdRetiradaUniforme());
		stmtScript.setInt(2, item.getUniforme().getIdUniforme());
		stmtScript.setInt(3, item.getQuantidade());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}
		return false;
	}

	public boolean salvarOperacaoEstoque(OperacaoEstoqueUniforme op) throws SQLException {
		int rows = 0;
		stmtScript = con.prepareStatement("INSERT INTO operacaoestoqueuniforme (idUsuario, tpOperacao, "
				+ "dtOperacao, idUniforme, quantidade) "
				+ "VALUES(?,?,?,?,?)");
		stmtScript.setInt(1, op.getUsuario().getIdPessoa());
		stmtScript.setInt(2, op.getTpOperacao());
		stmtScript.setDate(3, new java.sql.Date(op.getDtOperacao().getTime()));
		stmtScript.setInt(4, op.getUniforme().getIdUniforme());
		stmtScript.setInt(5, op.getQuantidade());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}
		return false;
	}
}
