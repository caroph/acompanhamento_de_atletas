package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.DiaTreino;
import br.com.saat.model.dao.DiaTreinoDAO;

public class DiaTreinoNegocio {

	public List<Object> validaDados(DiaTreino dia) {
		List<Object> lista = new ArrayList<Object>();

		if (dia.getTpEquipe() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Equipe' !");
		} else if (dia.getDiaSemana() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Dia da Semana' !");
		} else if ("".equals(dia.getHrInicio())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Hora Início' !");
		} else if ("".equals(dia.getHrFim())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Hora Fim' !");
		} else {
			lista.add(true);
		}

		return lista;
	}

	public boolean inserir(DiaTreino dia) throws Exception {
		boolean retorno = false;

		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			if (dao.inserir(dia)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"Erro! Ocorreu algum erro ao inserir o dia de treino");
		}

		return retorno;
	}

	public List<DiaTreino> buscaDiasTreino() throws Exception{
		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			List<DiaTreino> lista = dao.buscaDiasTreinos();
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os dias de treinos");
		}
	}

	public boolean desativar(DiaTreino dia) throws Exception{
		boolean retorno = false;

		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			if (dao.desativar(dia)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao desativar o dia de treino!");
		}

		return retorno;
	}

}
