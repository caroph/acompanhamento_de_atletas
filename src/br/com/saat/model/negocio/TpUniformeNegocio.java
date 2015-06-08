package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.TpUniforme;

public class TpUniformeNegocio {
	public TpUniformeNegocio(){}
	
	public List<TpUniforme> listaTpUniforme() {
		List<TpUniforme> lista = new ArrayList<TpUniforme>();
		for (TpUniforme e : TpUniforme.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaTpUniformeString() {
		List<String> lista = new ArrayList<String>();
		for (TpUniforme e : TpUniforme.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
