package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.DiaTreino;
import br.com.saat.model.dao.DiaTreinoDAO;

public class DiaTreinoNegocio {

	public List<Object> validaDados(DiaTreino dia) {
		List<Object> lista = new ArrayList<Object>();

		if (dia.getIdTpEquipe() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Equipe' !");
		} else if (dia.getIdDiaSemana() == 0) {
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
					"Erro! Ocorreu algum erro ao inserir o dia de treino.");
		}

		return retorno;
	}

	public List<DiaTreino> buscaDiasTreino() throws Exception{
		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			List<DiaTreino> lista = dao.buscaDiasTreinos();
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os dias de treinos.");
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
			throw new Exception("Erro! Ocorreu algum erro ao desativar o dia de treino.");
		}

		return retorno;
	}

	public List<DiaTreino> carregaDiasTreino(int idTpEquipe) throws Exception{
		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			List<DiaTreino> lista = dao.carregaDiasTreino(idTpEquipe);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os dias de treinos.");
		}
	}
	
	public boolean inserirDiaTreinoAtleta(String[] diasTreino, int idAtleta) throws Exception {
		boolean retorno = true;

		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			for (String idDia : diasTreino) {
				if (!dao.inserirDiaTreinoAtleta(idDia, idAtleta)) {
					return false;
				}
			}
		} catch (Exception e) {
			throw new Exception(
				"Erro! Ocorreu algum erro ao inserir os dias de treino do atleta.");
		}

		return retorno;
	}

	public boolean alterar(String[] diasTreino, int idAtleta) throws Exception {
		try {
			DiaTreinoDAO dao = new DiaTreinoDAO();
			if(!dao.excluirDiasTreinoAtleta(idAtleta)){
				return false;
			}else{
				inserirDiaTreinoAtleta(diasTreino, idAtleta);
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao alterar os dias de treino do atleta.");
		}
		return false;
	} 

}
