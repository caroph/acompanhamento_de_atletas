package br.com.saat.model.negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.saat.model.Chamada;
import br.com.saat.model.dao.ChamadaDAO;

public class ChamadaNegocio {
	public ChamadaNegocio(){}
	
	public Chamada buscarChamadaPorDia(String data, int idDiaTreino) throws Exception{
		ChamadaDAO dao = new ChamadaDAO();
		
		Date dt = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		dt = formatter.parse(data);
		
		try{
			Chamada chamada = dao.buscarChamadaPorData(dt, idDiaTreino);
			return chamada;
		}catch(Exception ex){
			throw new Exception("Erro ao buscar a chamada!");
		}		
	}
}
