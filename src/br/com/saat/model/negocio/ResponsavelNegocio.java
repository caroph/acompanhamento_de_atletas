package br.com.saat.model.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Responsavel;
import br.com.saat.model.dao.ResponsavelDAO;

public class ResponsavelNegocio {
	
	public List<Object> validar(Responsavel responsavel)
	{
		List<Object> lista = new ArrayList<Object>();
		
		if(responsavel.getNome() == "" || responsavel.getNome() == null){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Nome' !");	
		}else if (responsavel.getEmail() == null || responsavel.getEmail() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Email' !");
		}else if(responsavel.getCelular() == null || responsavel.getCelular() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Responsavel' !");
		}else{
			lista.add(true);
		}
		
		return lista;
	}
	
	
	public boolean inserir(Responsavel responsavel) throws Exception{
		
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			if(dao.inserir(responsavel))
				return true;
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao inserir o Responsável");
		}
		return false;
	}
	
}
