package br.com.saat.model.negocio;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
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

	public int inserir(FichaDeAtendimento ficha) throws Exception{
		try{
			FichaDeAtendimentoDAO dao  = new FichaDeAtendimentoDAO();
			int idFichaInserida = dao.inserir(ficha);
			if(idFichaInserida > 0)
				return idFichaInserida;
			else 
				throw new Exception("Erro ao inserir ficha de atendimento no banco!");
		}catch (Exception ex) {
			throw ex;
		}
	}

	public boolean alterar(FichaDeAtendimento ficha) throws Exception{
		throw new NotImplementedException();
	}
}
