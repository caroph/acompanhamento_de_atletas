package br.com.saat.model.negocio;

import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.dao.FichaDeAtendimentoDAO;

public class FichaDeAtendimentoNegocio {

	public FichaDeAtendimento buscarUltimaFicha(int idAtleta) throws Exception{
		try{
			FichaDeAtendimentoDAO dao  = new FichaDeAtendimentoDAO();
			return dao.buscarUltimaFicha(idAtleta);		
		}catch (Exception ex) {
			throw ex;
		}
	}
}
