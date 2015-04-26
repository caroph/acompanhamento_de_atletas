package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.GpTorneio;

public class GpTorneioNegocio {
	public List<GpTorneio> listaGpTorneio() {
		List<GpTorneio> lista = new ArrayList<GpTorneio>();
		for (GpTorneio e : GpTorneio.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaGpTorneioString() {
		List<String> lista = new ArrayList<String>();
		for (GpTorneio e : GpTorneio.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
