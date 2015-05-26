package br.com.saat.model.negocio;

import java.util.Date;
import java.util.List;

import br.com.saat.model.Atleta;
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
			throw new Exception("Erro ao registrar presen�a");
		}
	}

	public boolean salvarPresencaChamada(PresencaChamada presenca) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.salvarPresencaChamada(presenca);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presen�a");
		}
	}

	public List<PresencaChamada> buscarPresencasPorChamada(int idChamada) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.buscarPresencasPorChamada(idChamada);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presen�a");
		}
	}

	public boolean excluirPresencaChamada(int idChamada) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.excluirPresencaChamada(idChamada);
		}catch(Exception ex){
			throw new Exception("Erro ao alterar presen�a chamada");
		}
	}

	public List<Atleta> buscarPresencasPorData(Date dt, int idDiaTreino) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.buscarPresencasPorData(dt, idDiaTreino);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar chamada");
		}
	}

	public boolean alterarPresencaChamada(int idPresencaChamada,
			int estadoPresenca, String justificativa, String tpPresenca, int nrQuadra) throws Exception{
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.alterarPresencaChamada(idPresencaChamada, estadoPresenca, justificativa, tpPresenca, nrQuadra);
		}catch(Exception ex){
			throw new Exception("Erro ao editar chamada");
		}
		
	}

	public int verificarPresenca(int idChamada, int idAtleta) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.verificarPresenca(idChamada, idAtleta);
		}catch(Exception ex){
			throw new Exception("Erro ao verificar se j� existe presen�a para o atleta chamada");
		}
	}

	public boolean salvarPresencaChamada(int idChamada, int idAtleta, int estadoPresenca,
			String justificativa, String tpPresenca) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.salvarPresencaChamada(idChamada, idAtleta, estadoPresenca, justificativa, tpPresenca);
		}catch(Exception ex){
			throw new Exception("Erro ao salvar presen�a");
		}
	}
	
}
