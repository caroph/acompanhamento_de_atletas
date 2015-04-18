package br.com.saat.model.negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public Chamada salvarChamada(Chamada chamada) throws Exception {
		ChamadaDAO dao = new ChamadaDAO();
		try{
			chamada = dao.salvarChamada(chamada);
			return chamada;
		}catch(Exception ex){
			throw new Exception("Erro ao salvar a chamada!");
		}
	}

	public List<Object> validaDados(String data, String hora) {
		List<Object> lista = new ArrayList<Object>();
	
		if("".equals(data)){
			lista.add(false);
			lista.add("O campo 'Data' é obrigatório!");
		}else if("".equals(hora)){
			lista.add(false);
			lista.add("O campo 'Hora' é obrigatório!");
		}else{
			lista.add(true);
		}
		return lista;
	}
}
