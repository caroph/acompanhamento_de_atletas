package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		stmtScript = con.prepareStatement("SELECT idResponsavel FROM responsavel WHERE nome = ? AND flCadastroAtivo = 1");
		stmtScript.setString(1, nome);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			return rs.getInt("idResponsavel");
		}
		
		return 0;
	}
	
	public ArrayList<Responsavel> buscarTodos() throws SQLException{
		ArrayList<Responsavel> lista = new ArrayList<Responsavel>();
		
		stmtScript = con.prepareStatement("SELECT * FROM responsavel WHERE flCadastroAtivo = 1");
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Responsavel responsavel = new Responsavel();
			responsavel.setIdPessoa(rs.getInt("idResponsavel"));
			responsavel.setNome(rs.getString("nome"));
			responsavel.setEmail(rs.getString("email"));
			responsavel.setCelular(rs.getString("celular"));
			
			try {
				EnderecoDAO enderecoDAO = new EnderecoDAO(this.con);
				responsavel.setEnderecos(enderecoDAO.buscarEnderecos(responsavel.getIdPessoa(), TpPessoa.Responsavel.getValor()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			lista.add(responsavel);
		}
		
		return lista;
	}
	
	public Responsavel buscarPorId(int idResponsavel) throws SQLException{
		stmtScript = con.prepareStatement("SELECT * FROM responsavel WHERE idResponsavel = ?");
		stmtScript.setInt(1, idResponsavel);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			Responsavel responsavel = new Responsavel();
			responsavel.setIdPessoa(rs.getInt("idResponsavel"));
			responsavel.setNome(rs.getString("nome"));
			responsavel.setEmail(rs.getString("email"));
			responsavel.setCelular(rs.getString("celular"));
			
			try {
				EnderecoDAO enderecoDAO = new EnderecoDAO(this.con);
				responsavel.setEnderecos(enderecoDAO.buscarEnderecos(responsavel.getIdPessoa(), TpPessoa.Responsavel.getValor()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return responsavel;
		}
	
		return null;
	}
	
	public boolean desativar(int idPessoa) throws SQLException{
		stmtScript = con.prepareStatement("UPDATE responsavel SET flCadastroAtivo = 0 WHERE idResponsavel = ?");
		stmtScript.setInt(1, idPessoa);
		
		if(stmtScript.executeUpdate() > 0)
			return true;

		return false;
	}
	
}
