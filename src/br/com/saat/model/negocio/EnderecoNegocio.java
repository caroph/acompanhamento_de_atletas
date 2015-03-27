package br.com.saat.model.negocio;

import br.com.saat.model.Endereco;
import br.com.saat.model.TpEndereco;
import br.com.saat.model.dao.EnderecoDAO;

public class EnderecoNegocio {
	
	public boolean validar(Endereco endereco){
		if(endereco.getEndereco() != null &&
				endereco.getEndereco() != "" &&
				endereco.getNumero() != null &&
				endereco.getNumero() != "" &&
				endereco.getComplemento() != null &&
				endereco.getComplemento() != "" &&
				endereco.getBairro() != null &&
				endereco.getBairro() != "" &&
				endereco.getEstado() != null &&
				endereco.getEstado() != null &&
				endereco.getCidade() != null &&
				endereco.getCidade() != null &&
				endereco.getTelefone() != null &&
				endereco.getTelefone() != null &&
				endereco.getTpEndereco() != 0 &&
				(endereco.getTpEndereco() == TpEndereco.Comercial.getValor() || 
				endereco.getTpEndereco() == TpEndereco.Residencial.getValor())
				){
			return true;			
		}	
		return false;
	}
	
	public boolean inserir(Endereco endereco, int idPessoa, int tpPessoa)
	{
		if(idPessoa == 0 || tpPessoa == 0)
			return false;
		
		if(this.validar(endereco)){
			try {
				EnderecoDAO dao = new EnderecoDAO();
				dao.inserir(endereco, idPessoa, tpPessoa);	
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}			
		}
		return false;
	}
	
	
}
