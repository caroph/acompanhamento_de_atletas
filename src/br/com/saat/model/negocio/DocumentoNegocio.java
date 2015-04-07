package br.com.saat.model.negocio;

import java.io.File;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Documento;
import br.com.saat.model.TpDocumento;
import br.com.saat.model.dao.DocumentoDAO;

public class DocumentoNegocio {

	public List<Object> validar(Documento documento){
		List<Object> listaValidacao = new ArrayList<Object>();
		
		if(documento.getTpDocumento() > 6 || documento.getTpDocumento() < 0){
			listaValidacao.add(false);
			listaValidacao.add("Tipo de documento inválido!");
		}else if(documento.getIdPessoa() <= 0){
			listaValidacao.add(false);
			listaValidacao.add("IdPessoa inválido!");
		}
		listaValidacao.add(true);
		
		return listaValidacao;
	}

	public boolean inserir(Documento documento) throws Exception {
		try{
			List<Object> listaValidacao = validar(documento);
			if((boolean)listaValidacao.get(0)){
				DocumentoDAO dao = new DocumentoDAO();
				if(dao.inserir(documento)){
					return true;
				}
			}else{
				throw new Exception((String) listaValidacao.get(1));
			}
		}catch(SQLException ex){
			throw ex;
		}catch(Exception ex){
			throw new Exception("Erro ao gravar documento no banco de dados!");
		}
		
		return false;
	}
}
