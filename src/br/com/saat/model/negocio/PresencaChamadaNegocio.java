package br.com.saat.model.negocio;

import br.com.saat.model.PresencaChamada;
import br.com.saat.model.dao.PresencaChamadaDAO;

public class PresencaChamadaNegocio {
	public PresencaChamadaNegocio(){}

	public boolean salvarPresencaChamada(int idChamada, int idAtleta, int estadoPresenca, String justificativa) 
			throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.salvarPresencaChamada(idChamada, idAtleta, estadoPresenca, justificativa);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presença");
		}
	}

	public boolean salvarPresencaChamada(PresencaChamada presenca) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.salvarPresencaChamada(presenca);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presença");
		}
	}
	
}
