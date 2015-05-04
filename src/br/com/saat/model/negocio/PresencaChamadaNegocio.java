package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

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

	public List<PresencaChamada> buscarPresencasPorChamada(int idChamada) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		List<PresencaChamada> listaPresenca = new ArrayList<PresencaChamada>();
		try{
			return dao.buscarPresencasPorChamada(idChamada);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presença");
		}
	}

	public boolean excluirPresencaChamada(int idChamada) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.excluirPresencaChamada(idChamada);
		}catch(Exception ex){
			throw new Exception("Erro ao alterar presença chamada");
		}
	}
	
}
