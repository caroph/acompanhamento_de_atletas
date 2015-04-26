package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.CatTorneio;

public class CatTorneioNegocio {
	public List<CatTorneio> listaCatTorneio() {
		List<CatTorneio> lista = new ArrayList<CatTorneio>();
		for (CatTorneio e : CatTorneio.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaCatTorneioString() {
		List<String> lista = new ArrayList<String>();
		for (CatTorneio e : CatTorneio.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
