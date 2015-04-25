package br.com.saat.model.negocio;

import br.com.saat.model.AvaliacaoAntropometrica;
import br.com.saat.model.dao.AvaliacaoAntropometricaDAO;

public class AvaliacaoAntropometricaNegocio {

	public AvaliacaoAntropometrica buscarAvaliacao(int idFichaDeAtendimento) {
		try{
			AvaliacaoAntropometricaDAO dao = new AvaliacaoAntropometricaDAO();
			return dao.buscarAvaliacao(idFichaDeAtendimento);
		}catch(Exception ex){
			
		}
		return null;
	}

}
