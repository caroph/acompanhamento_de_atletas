package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.UnidadeDeMedida;

public class UnidadeDeMedidaNegocio {
	public List<UnidadeDeMedida> listaUnidadeDeMedida() {
		List<UnidadeDeMedida> lista = new ArrayList<UnidadeDeMedida>();
		for (UnidadeDeMedida e : UnidadeDeMedida.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaUnidadeDeMedidaString() {
		List<String> lista = new ArrayList<String>();
		for (UnidadeDeMedida e : UnidadeDeMedida.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
