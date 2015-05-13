package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.TipoCat;

public class TipoCatNegocio {
	public List<TipoCat> listaTipoCat() {
		List<TipoCat> lista = new ArrayList<TipoCat>();
		for (TipoCat e : TipoCat.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaTipoCatString() {
		List<String> lista = new ArrayList<String>();
		for (TipoCat e : TipoCat.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
