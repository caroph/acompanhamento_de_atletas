package br.com.saat.model.negocio;

import br.com.saat.model.AvaliacaoAntropometrica;
import br.com.saat.model.dao.AvaliacaoAntropometricaDAO;

public class AvaliacaoAntropometricaNegocio {

	public AvaliacaoAntropometrica buscarAvaliacao(int idFichaDeAtendimento) throws Exception{
		try{
			AvaliacaoAntropometricaDAO dao = new AvaliacaoAntropometricaDAO();
			AvaliacaoAntropometrica avaliacao = dao.buscarAvaliacao(idFichaDeAtendimento);
			if(avaliacao != null)
				return avaliacao;
			else{
				avaliacao = new AvaliacaoAntropometrica();
				avaliacao.setIdAvaliacaoAntropometrica(0);
			}			
		}catch(Exception ex){
			throw ex;
		}
		return null;
	}

	public int inserir(AvaliacaoAntropometrica avaliacaoAntropometrica, int idFichaDeAtendimento) throws Exception{
		try{
			AvaliacaoAntropometricaDAO dao = new AvaliacaoAntropometricaDAO();
			int idAvaliacaoInserida = dao.inserir(avaliacaoAntropometrica, idFichaDeAtendimento);
			if(idAvaliacaoInserida > 0)
				return idAvaliacaoInserida;
			else
				return 0;
		}catch(Exception ex){
			throw ex;
		}
	}

	public boolean alterar(AvaliacaoAntropometrica avaliacaoAntropometrica, int idFichaDeAtendimento) throws Exception {
		try{
			AvaliacaoAntropometricaDAO dao = new AvaliacaoAntropometricaDAO();
			return dao.alterar(avaliacaoAntropometrica, idFichaDeAtendimento);
		}catch(Exception ex){
			throw ex;
		}
	}

}
