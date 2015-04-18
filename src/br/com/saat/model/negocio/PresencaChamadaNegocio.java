package br.com.saat.model.negocio;

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
	
}
