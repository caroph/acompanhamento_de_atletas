package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Endereco;
import br.com.saat.model.TpPessoa;

public class EnderecoDAO {

	private Connection con;
	private PreparedStatement stmtScript;
	
	public EnderecoDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public EnderecoDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	
	public boolean inserir(Endereco endereco, int idPessoa, int tpPessoa) throws SQLException{
		if(tpPessoa == TpPessoa.Responsavel.getValor())
			stmtScript = con.prepareStatement("INSERT INTO endereco ("
					+ "idResponsavel,"
					+ "endereco,"
					+ "numero,"
					+ "complemento,"
					+ "bairro,"
					+ "estado,"
					+ "cidade,"
					+ "telefone,"
					+ "idTpEndereco"
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		else if(tpPessoa == TpPessoa.Atleta.getValor())
			stmtScript = con.prepareStatement("INSERT INTO endereco ("
					+ "idAtleta,"
					+ "endereco,"
					+ "numero,"
					+ "complemento,"
					+ "bairro,"
					+ "estado,"
					+ "cidade,"
					+ "telefone,"
					+ "idTpEndereco"
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		else
			return false;
		
		stmtScript.setInt(1,idPessoa);
		stmtScript.setString(2, endereco.getEndereco());
		stmtScript.setInt(3, endereco.getNumero());
		stmtScript.setString(4, endereco.getComplemento());
		stmtScript.setString(5, endereco.getBairro());
		stmtScript.setString(6, endereco.getEstado());
		stmtScript.setString(7, endereco.getCidade());
		stmtScript.setString(8, endereco.getTelefone());
		stmtScript.setInt(9, endereco.getTpEndereco());
		
		if(stmtScript.executeUpdate() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean alterar(Endereco endereco, int idPessoa, int tpPessoa) throws SQLException{	
		if(tpPessoa == TpPessoa.Responsavel.getValor())
			stmtScript = con.prepareStatement("UPDATE endereco SET "
					+ "idResponsavel = ?,"
					+ "endereco = ?,"
					+ "numero = ?,"
					+ "complemento = ?,"
					+ "bairro = ?,"
					+ "estado = ?,"
					+ "cidade = ?,"
					+ "telefone = ?,"
					+ "idTpEndereco = ? "
					+ "WHERE idEndereco = ?");
		else if(tpPessoa == TpPessoa.Atleta.getValor())
			stmtScript = con.prepareStatement("INSERT INTO endereco ("
					+ "idAtleta,"
					+ "endereco,"
					+ "numero,"
					+ "complemento,"
					+ "bairro,"
					+ "estado,"
					+ "cidade,"
					+ "telefone,"
					+ "idTpEndereco"
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		else
			return false;
		
		stmtScript.setInt(1,idPessoa);
		stmtScript.setString(2, endereco.getEndereco());
		stmtScript.setInt(3, endereco.getNumero());
		stmtScript.setString(4, endereco.getComplemento());
		stmtScript.setString(5, endereco.getBairro());
		stmtScript.setString(6, endereco.getEstado());
		stmtScript.setString(7, endereco.getCidade());
		stmtScript.setString(8, endereco.getTelefone());
		stmtScript.setInt(9, endereco.getTpEndereco());
		
		if(stmtScript.executeUpdate() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	public ArrayList<Endereco>buscarEnderecos(int idPessoa, int tpPessoa) throws SQLException{
		ArrayList<Endereco> lista = new ArrayList<Endereco>();
		if(tpPessoa == TpPessoa.Responsavel.getValor())
			stmtScript = con.prepareStatement("SELECT * FROM endereco WHERE idResponsavel = ?");
		else if(tpPessoa == TpPessoa.Atleta.getValor())
			stmtScript = con.prepareStatement("SELECT * FROM endereco WHERE idAtleta = ?");
		else
			return null;
		
		stmtScript.setInt(1, idPessoa);
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Endereco endereco = new Endereco(
					rs.getString("endereco"), 
					rs.getInt("numero"),
					rs.getString("complemento"), 
					rs.getString("bairro"), 
					rs.getString("estado"), 
					rs.getString("cidade"), 
					rs.getInt("idTpEndereco"), 
					rs.getString("telefone"));
			endereco.setIdEndereco(rs.getInt("idEndereco"));
			lista.add(endereco);
		}			
		
		return lista;
	}
	
}
 