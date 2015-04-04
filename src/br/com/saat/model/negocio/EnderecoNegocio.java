package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.Endereco;
import br.com.saat.model.TpEndereco;
import br.com.saat.model.TpPessoa;
import br.com.saat.model.dao.EnderecoDAO;

public class EnderecoNegocio {
	
	public List<Object> validar(Endereco endereco){
		List<Object> lista = new ArrayList<Object>();
		
		if(endereco.getEndereco() == null || endereco.getEndereco().equals("")){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Endereço " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial'" : "Residencial'")  + "!");
		}else if(endereco.getNumero() == 0){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Numero' do endereço " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial" : "Residencial")  + "!");
//		}else if(endereco.getComplemento() == null || endereco.getComplemento() == ""){
//			lista.add(false);
//			lista.add("Informe corretamente o campo 'Complemento' do endereço " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial" : "Residencial")  + "!");
		}else if(endereco.getBairro() == null || endereco.getBairro() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Bairro' do endereço " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial" : "Residencial")  + "!");
		}else if(endereco.getEstado() == null || endereco.getEstado() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Estado' do endereço " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial" : "Residencial")  + "!");
		}else if(endereco.getCidade() == null || endereco.getCidade() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Cidade' do endereço " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial" : "Residencial")  + "!");
		}else if(endereco.getTelefone() == null || endereco.getTelefone() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Telefone " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial'" : "Residencial'")  + "!");
		}else if(endereco.getTpEndereco() == 0 || (endereco.getTpEndereco() != TpEndereco.Comercial.getValor() && endereco.getTpEndereco() != TpEndereco.Residencial.getValor())){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Endereco " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "(Comercial)'" : "(Residencial)'")  + "!");
		}else{
			lista.add(true);
		}
		
		return lista;
	}
	
	public boolean inserir(Endereco endereco, int idPessoa, int tpPessoa) throws Exception{
		if(idPessoa == 0 || tpPessoa == 0)
			return false;
		
		try {
			EnderecoDAO dao = new EnderecoDAO();
			dao.inserir(endereco, idPessoa, tpPessoa);	
			return true;
		}catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir o Endereço " + (endereco.getTpEndereco() == TpEndereco.Comercial.getValor()? "Comercial" : "Residencial"));
		}			
	}

	public boolean alterar(Atleta atleta) throws Exception {
		try {
			EnderecoDAO dao = new EnderecoDAO();
			if (dao.alterar(atleta.getEndereco(), atleta.getIdPessoa(), TpPessoa.Atleta.getValor())) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao alterar o endereço do atleta.");
		}
		return false;
	}
	
	
}
