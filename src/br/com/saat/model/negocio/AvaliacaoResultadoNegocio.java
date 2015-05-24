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

	public boolean inserirResultado(List<AvaliacaoResultado> avaliacaoResul,
			AvaliacaoFisica avalFis) throws Exception {
		boolean retorno = true;
		int idAvaliacaoFisica = 0;
		
		try {
			AvaliacaoResultadoDAO avalResulDAO = new AvaliacaoResultadoDAO();
			AvaliacaoFisicaDAO avalFisDAO = new AvaliacaoFisicaDAO();
			
			idAvaliacaoFisica = avalFisDAO.inserir(avalFis);
			if (idAvaliacaoFisica > 0) {
				avalFis.setIdAvaliacaoFisica(idAvaliacaoFisica);
				for (AvaliacaoResultado resultado : avaliacaoResul) {
					if (!avalResulDAO.inserir(resultado, avalFis)) {
						retorno = false;
						break;
					}
				}
			} 
		} catch (Exception e) {
			retorno = false;
			throw new Exception("Erro! Ocorreu algum erro ao inserir a avaliação física.");
		}
		return retorno;
	}

}
