package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.ResultadoTorneio;

public class ResultadoTorneioNegocio {
	public List<ResultadoTorneio> listaResultadoTorneio() {
		List<ResultadoTorneio> lista = new ArrayList<ResultadoTorneio>();
		for (ResultadoTorneio e : ResultadoTorneio.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaResultadoTorneioString() {
		List<String> lista = new ArrayList<String>();
		for (ResultadoTorneio e : ResultadoTorneio.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
