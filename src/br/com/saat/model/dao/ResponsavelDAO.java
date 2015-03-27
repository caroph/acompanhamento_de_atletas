package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Endereco;
import br.com.saat.model.Responsavel;
import br.com.saat.model.TpPessoa;

public class ResponsavelDAO {

	private Connection con;
	private PreparedStatement stmtScript;
	
	public ResponsavelDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public ResponsavelDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public boolean inserir(Responsavel responsavel) throws SQLException{
		stmtScript = con.prepareStatement("INSERT INTO responsavel ("
				+ "nome, "
				+ "email, "
				+ "celular"
				+ ") "
				+ "VALUES (?, ?, ?)");
		stmtScript.setString(1, responsavel.getNome());
		stmtScript.setString(2, responsavel.getEmail());
		stmtScript.setString(3, responsavel.getCelular());
		
		if(stmtScript.executeUpdate() > 0){
			//recupera o id do usuário recem cadastrado
			responsavel.setIdPessoa(recuperaId(responsavel.getNome()));
			
			if(responsavel.getIdPessoa() != 0)
			{
				try {
					EnderecoDAO dao = new EnderecoDAO(this.con);
					for(Endereco endereco : responsavel.getEnderecos()){
						if(!dao.inserir(endereco, responsavel.getIdPessoa(),TpPessoa.Responsavel.getValor()))
							return false;
					}
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}					
			}else
				return false;
		}		
		return false;
	}

	private int recuperaId(String nome) throws SQLException{
		stmtScript = con.prepareStatement("SELECT idResponsavel FROM responsavel WHERE nome = ?");
		stmtScript.setString(1, nome);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			return rs.getInt("idResponsavel");
		}
		
		return 0;
	}
	
}
