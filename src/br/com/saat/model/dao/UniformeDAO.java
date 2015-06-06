package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.ConnectionFactory;
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

	public boolean salvarUniforme(Uniforme uniforme, String optEstoque) throws Exception {
		int rows = 0;
		
		Integer quantidade = BuscarQtdTipoUniforme(uniforme.getTpUniforme(), uniforme.getTamanhoUniforme());
		if(quantidade == null){	
			if("I".equals(optEstoque)){
				stmtScript = con.prepareStatement("INSERT INTO uniforme (tpuniforme, tamanhouniforme, quantidadeestoque) "
						+ "VALUES(?,?,?)");
				stmtScript.setInt(1, uniforme.getTpUniforme());
				stmtScript.setInt(2, uniforme.getTamanhoUniforme());
				stmtScript.setInt(3, uniforme.getQuantidadeUniforme());
			} else{
				throw new Exception("Falha na operação. Não existem "+ uniforme.getNomeTpUniforme() +"s suficientes disponíveis em estoque");
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
		}
		
		rows = stmtScript.executeUpdate();
		
		if(rows>0){
			return true;		
		}
		return false;
	}

	private Integer BuscarQtdTipoUniforme(int tpUniforme, int tamanho) throws SQLException {
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
}
