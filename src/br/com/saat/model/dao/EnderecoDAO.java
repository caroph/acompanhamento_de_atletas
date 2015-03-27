package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
					+ "numero"
					+ "complemento"
					+ "bairro"
					+ "estado"
					+ "cidade"
					+ "telefone"
					+ "tpEndereco"
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		else if(tpPessoa == TpPessoa.Atleta.getValor())
			stmtScript = con.prepareStatement("INSERT INTO endereco ("
					+ "idAtleta,"
					+ "endereco,"
					+ "numero"
					+ "complemento"
					+ "bairro"
					+ "estado"
					+ "cidade"
					+ "telefone"
					+ "tpEndereco"
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		else
			return false;
		
		stmtScript.setInt(1,idPessoa);
		stmtScript.setString(2, endereco.getEndereco());
		stmtScript.setString(3, endereco.getNumero());
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
	
}
