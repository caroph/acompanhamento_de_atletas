package br.com.saat.model.negocio;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.dao.FichaDeAtendimentoDAO;

public class FichaDeAtendimentoNegocio {

	public FichaDeAtendimento buscarUltimaFicha(int idAtleta) throws Exception{
		try{
			FichaDeAtendimentoDAO dao  = new FichaDeAtendimentoDAO();
			FichaDeAtendimento ficha = dao.buscarUltimaFicha(idAtleta);
			if(ficha != null)
				return ficha;
			else{
				ficha = new FichaDeAtendimento();
				ficha.setIdFichaDeAtendimento(0);
				return ficha;
			}
		}catch (Exception ex) {
			throw ex;
		}
	}

	public int inserir(FichaDeAtendimento ficha) throws Exception{
		try{
			FichaDeAtendimentoDAO dao  = new FichaDeAtendimentoDAO();
			int idFichaInserida = dao.inserir(ficha);
			if(idFichaInserida > 0){
				AvaliacaoAntropometricaNegocio avaliacaoNegocio = new AvaliacaoAntropometricaNegocio();
				int idAvaliacaoInserida = avaliacaoNegocio.inserir(ficha.getAvaliacaoAntropometrica(), idFichaInserida);
				if(idAvaliacaoInserida > 0){
					ficha.getAvaliacaoAntropometrica().setIdAvaliacaoAntropometrica(idAvaliacaoInserida);
					return idFichaInserida;
				}else{
					throw new Exception("Erro ao inserir avaliação antropométrica no banco!");
				}				
			}				
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
