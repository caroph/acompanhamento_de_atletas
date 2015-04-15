package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.Perfis;

public class PerfisNegocio {

	public PerfisNegocio() {
	}

	public List<Perfis> listaPerfis() {
		List<Perfis> lista = new ArrayList<Perfis>();
		for (Perfis p : Perfis.values()) {
			lista.add(p);
		}
		return lista;
	}

}
