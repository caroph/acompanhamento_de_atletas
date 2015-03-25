package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.DiaTreino;
import br.com.saat.model.dao.DiaTreinoDAO;

public class DiaTreinoNegocio {
	
	public List<Object> validaDados(DiaTreino dia){
		List<Object> lista = new ArrayList<Object>();
		
		if(dia.getTpEquipe() == 0){
            lista.add(false);
            lista.add("Selecione corretamente o campo 'Equipe' !");
        }else if(dia.getDiaDaSemana() == 0){
            lista.add(false);
            lista.add("Selecione corretamente o campo 'Dia da Semana' !");
        }else if("".equals(dia.getHrInicio())){
            lista.add(false);
            lista.add("Informe corretamente o campo 'Hora Início' !");
        }else if("".equals(dia.getHrFim())){
            lista.add(false);
            lista.add("Informe corretamente o campo 'Hora Fim' !");
        }else{
        	lista.add(true);
        }
		
		return lista;
	}

	public boolean salvar(DiaTreino dia) {
		boolean retorno = false;
		
		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			if(dao.inserir(dia)){
				retorno = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return retorno;
	}

	public List<DiaTreino> buscaDiasTreino() {
		// TODO Auto-generated method stub
		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			List<DiaTreino> lista = dao.buscaDiasTreinos();
			return lista;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
