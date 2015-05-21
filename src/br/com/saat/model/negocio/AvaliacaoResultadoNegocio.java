package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AvaliacaoResultado;
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

}
