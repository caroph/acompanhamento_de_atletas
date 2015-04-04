package br.com.saat.model.negocio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Documento;
import br.com.saat.model.TpDocumento;

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
}
