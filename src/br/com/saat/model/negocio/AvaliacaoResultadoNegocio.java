package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AvaliacaoFisica;
import br.com.saat.model.AvaliacaoResultado;
import br.com.saat.model.dao.AvaliacaoFisicaDAO;
import br.com.saat.model.dao.AvaliacaoResultadoDAO;

public class AvaliacaoResultadoNegocio {

	public List<AvaliacaoResultado> buscarAtividades(int idAtleta) throws Exception {
		AvaliacaoResultadoDAO dao = new AvaliacaoResultadoDAO();
		List<AvaliacaoResultado> listaAvaResul = new ArrayList<AvaliacaoResultado>();
		try {
			listaAvaResul = dao.buscarAtividades(idAtleta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAvaResul;
	}

	public int inserirResultado(List<AvaliacaoResultado> avaliacaoResul,
			AvaliacaoFisica avalFis) throws Exception {
		int idAvaliacaoFisica = 0;
		
		try {
			AvaliacaoResultadoDAO avalResulDAO = new AvaliacaoResultadoDAO();
			AvaliacaoFisicaDAO avalFisDAO = new AvaliacaoFisicaDAO();
			
			idAvaliacaoFisica = avalFisDAO.inserir(avalFis);
			if (idAvaliacaoFisica > 0) {
				avalFis.setIdAvaliacaoFisica(idAvaliacaoFisica);
				for (AvaliacaoResultado resultado : avaliacaoResul) {
					if (!avalResulDAO.inserir(resultado, avalFis)) {
						idAvaliacaoFisica = 0;
						break;
					}
				}
			} 
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir a avaliação física.");
		}
		return idAvaliacaoFisica;
	}

	public List<AvaliacaoResultado> buscarResulDesempenho(int idAvaliacaoFisica) throws Exception {
		List<AvaliacaoResultado> resultDesempenho = new ArrayList<AvaliacaoResultado>();
		AvaliacaoResultadoDAO avalResulDAO = new AvaliacaoResultadoDAO();
		try {
			resultDesempenho = avalResulDAO.buscarResultDesempenho(idAvaliacaoFisica);
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o(s) resultado(s) do(s) desempenho(s) na avaliação física.");
		}
		return resultDesempenho;
	}

	public boolean excluir(int idAvaliacaoFisica) throws Exception {
		boolean retorno = false;
		AvaliacaoResultadoDAO avalResulDAO = new AvaliacaoResultadoDAO();
		try {
			if(avalResulDAO.excluir(idAvaliacaoFisica)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o(s) resultado(s) do(s) desempenho(s) na avaliação física.");
		}
		return retorno;
	}

	public boolean editar(List<AvaliacaoResultado> avaliacaoResul,
			AvaliacaoFisica avalFis) throws Exception {
		boolean retorno = true;
		
		try {
			AvaliacaoResultadoDAO avalResulDAO = new AvaliacaoResultadoDAO();
			AvaliacaoFisicaDAO avalFisDAO = new AvaliacaoFisicaDAO();
			
			if (avalFisDAO.editar(avalFis)) {
				for (AvaliacaoResultado resultado : avaliacaoResul) {
					if (!avalResulDAO.editar(resultado, avalFis)) {
						retorno = false;
						break;
					}
				}
			} 
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir a avaliação física.");
		}
		
		return retorno;
	}

}
