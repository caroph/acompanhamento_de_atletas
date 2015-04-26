package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.Naipe;

public class NaipeNegocio {
	public List<Naipe> listaNaipe() {
		List<Naipe> lista = new ArrayList<Naipe>();
		for (Naipe e : Naipe.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaNaipeString() {
		List<String> lista = new ArrayList<String>();
		for (Naipe e : Naipe.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
