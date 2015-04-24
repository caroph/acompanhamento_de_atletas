package br.com.saat.model.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.com.saat.model.Documento;
import br.com.saat.model.dao.DocumentoDAO;

public class DocumentoNegocio {

	public List<Object> validar(Documento documento){
		List<Object> listaValidacao = new ArrayList<Object>();
		
		if(documento.getTpDocumento() > 7 || documento.getTpDocumento() < 0){
			listaValidacao.add(false);
			listaValidacao.add("Tipo de documento inválido!");
		}else if(documento.getIdPessoa() <= 0){
			listaValidacao.add(false);
			listaValidacao.add("IdPessoa inválido!");
		}else if(documento.getValidade()!= null && new Date().after(documento.getValidade())){
			listaValidacao.add(false);
			listaValidacao.add("A Data de validade deve ser maior que a data atual!");
		}else{
			listaValidacao.add(true);
		}
		
		return listaValidacao;
	}

	public boolean inserir(Documento documento) throws Exception {
		List<Object> listaValidacao = validar(documento);
		try{
			if((boolean)listaValidacao.get(0)){
				DocumentoDAO dao = new DocumentoDAO();
				if(dao.inserir(documento)){
					return true;
				}
			}
		}catch(SQLException ex){
			throw ex;
		}catch(Exception ex){
			throw new Exception("Erro ao gravar documento no banco de dados!");
		}
		if((String) listaValidacao.get(1) != null || !"".equals((String) listaValidacao.get(1))){
			throw new Exception((String) listaValidacao.get(1));
		}
		return false;
	}
	
	public ArrayList<Documento> buscarTodosAtleta(int idPessoa) throws Exception{
		
		try{
			DocumentoDAO dao = new DocumentoDAO();
			return dao.buscarTodosAtleta(idPessoa);			
		}catch(Exception ex){
			throw ex;
		}
	}
	
	public int exists(Documento documento) throws Exception{
		try{
			DocumentoDAO dao = new DocumentoDAO();
			return dao.exists(documento);
		}catch(Exception ex){
			throw ex;
		}
	}

	public boolean alterar(Documento documento) throws Exception {
		List<Object> listaValidacao = validar(documento);
		try{
			if((boolean)listaValidacao.get(0)){
				DocumentoDAO dao = new DocumentoDAO();
				if(dao.alterar(documento)){
					return true;
				}
			}
		}catch(SQLException ex){
			throw ex;
		}catch(Exception ex){
			throw new Exception("Erro ao gravar documento no banco de dados!");
		}
		if((String) listaValidacao.get(1) != null || !"".equals((String) listaValidacao.get(1))){
			throw new Exception((String) listaValidacao.get(1));
		}
		return false;
	}

	public ArrayList<HashMap<Integer,String>> buscarPendencias() throws Exception {
		ArrayList<HashMap<Integer,String>> listaPendencias = null;
		
		try{
			DocumentoDAO dao = new DocumentoDAO();
			listaPendencias = dao.buscarPendencias();
			
			boolean listaVazia = true;
			
			for (HashMap<Integer, String> item : listaPendencias) {
				if(item.size() == 0 && listaVazia){
					listaVazia = true;
				}else{
					listaVazia = false;
				}
			}

			if(listaVazia){
				listaPendencias = null;
			}
		}catch(SQLException ex){
			throw ex;
		}catch(Exception ex){
			throw new Exception("Erro ao consultar documentos pendentes!");
		}		
		return listaPendencias;
	}
	
}

		