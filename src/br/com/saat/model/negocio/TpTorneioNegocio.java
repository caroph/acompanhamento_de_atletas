package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.TpTorneio;

public class TpTorneioNegocio {
	public List<TpTorneio> listaTpTorneio() {
		List<TpTorneio> lista = new ArrayList<TpTorneio>();
		for (TpTorneio e : TpTorneio.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaTpTorneioString() {
		List<String> lista = new ArrayList<String>();
		for (TpTorneio e : TpTorneio.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
