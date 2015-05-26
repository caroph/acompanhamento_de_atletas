package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AvaliacaoFisica;
import br.com.saat.model.AvaliacaoResultado;
import br.com.saat.model.dao.AvaliacaoFisicaDAO;

public class AvaliacaoFisicaNegocio {

	public List<AvaliacaoFisica> buscaHistorico(int idAtleta) throws Exception {
		List<AvaliacaoFisica> listaAvaliacaoFis = new ArrayList<AvaliacaoFisica>();
		AvaliacaoFisicaDAO avalFisDAO = new AvaliacaoFisicaDAO();
		
		AvaliacaoResultadoNegocio negocio = new AvaliacaoResultadoNegocio();
		
		try {
			listaAvaliacaoFis = avalFisDAO.buscaHistorico(idAtleta);
			
			for (AvaliacaoFisica avaliacaoFisica : listaAvaliacaoFis) {
				List<AvaliacaoResultado> avalResult = new ArrayList<AvaliacaoResultado>();
				avalResult = negocio.buscarResulDesempenho(avaliacaoFisica.getIdAvaliacaoFisica());
				
				avaliacaoFisica.setAvaliacaoResultado(avalResult);
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o(s) resultado(s) do(s) desempenho(s) na avaliação física.");
		}
		return listaAvaliacaoFis;
	}

	public boolean excluir(int idAvaliacaoFisica) throws Exception {
		boolean retorno = false;
		AvaliacaoFisicaDAO avalFisDAO = new AvaliacaoFisicaDAO();
		try {
			if(avalFisDAO.excluir(idAvaliacaoFisica)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o(s) resultado(s) do(s) desempenho(s) na avaliação física.");
		}
		return retorno;
	}

	public List<AvaliacaoFisica> buscaAvaliacoes() throws Exception {
		List<AvaliacaoFisica> listaAvaliacao = new ArrayList<AvaliacaoFisica>();
		AvaliacaoFisicaDAO avalFisDAO = new AvaliacaoFisicaDAO();
		
		try {
			listaAvaliacao = avalFisDAO.buscaAvaliacoes();
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar as últimas avaliações físicas.");
		}
		
		return listaAvaliacao;
	}

	public AvaliacaoFisica buscaAvaliacao(int idAvaliacaoFis) throws Exception {
		AvaliacaoFisica avaliacao = new AvaliacaoFisica();
		AvaliacaoFisicaDAO avalFisDAO = new AvaliacaoFisicaDAO();
		
		try {
			avaliacao = avalFisDAO.buscaAvaliacao(idAvaliacaoFis);
			if(avaliacao != null) {
				AvaliacaoResultadoNegocio negocioResul = new AvaliacaoResultadoNegocio();
				List<AvaliacaoResultado> listaResult = negocioResul.buscarResulDesempenho(idAvaliacaoFis);
				if (!listaResult.isEmpty()) {
					avaliacao.setAvaliacaoResultado(listaResult);
				} 
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o(s) resultado(s) do(s) desempenho(s) na avaliação física.");
		}
		return avaliacao;
	}

}
