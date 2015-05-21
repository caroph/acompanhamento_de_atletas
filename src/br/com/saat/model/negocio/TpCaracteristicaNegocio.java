package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.TpCaracteristica;

public class TpCaracteristicaNegocio {
	
	public List<TpCaracteristica> listaTpCaracteristica() {
		List<TpCaracteristica> lista = new ArrayList<TpCaracteristica>();
		for (TpCaracteristica e : TpCaracteristica.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaTpCaracteristicaString() {
		List<String> lista = new ArrayList<String>();
		for (TpCaracteristica e : TpCaracteristica.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
	
}
