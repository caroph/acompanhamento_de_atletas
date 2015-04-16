package br.com.saat.model.negocio;

import br.com.saat.model.dao.PresencaChamadaDAO;

public class PresencaChamadaNegocio {
	public PresencaChamadaNegocio(){}

	public void salvarPresencaChamada(int idChamada, int idAtleta, int estadoPresenca) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			dao.salvarPresencaChamada(idChamada, idAtleta, estadoPresenca);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presença");
		}
	}
	
}
