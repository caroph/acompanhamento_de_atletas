package br.com.saat.model.negocio;

import java.util.Date;

import br.com.saat.model.Chamada;
import br.com.saat.model.dao.ChamadaDAO;

public class ChamadaNegocio {
	public ChamadaNegocio(){}
	
	public Chamada buscarChamadaPorDia(Date dia, int idDiaTreino) throws Exception{
		ChamadaDAO dao = new ChamadaDAO();
		Chamada chamada = new Chamada();
		try{
			chamada = dao.buscarChamadaPorData(dia, idDiaTreino);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar a chamada");
		}
		return chamada;
	}
}
