package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.TpTamanhoUniforme;

public class TpTamanhoUniformeNegocio {
	public List<TpTamanhoUniforme> listaTpTamanhoUniforme() {
		List<TpTamanhoUniforme> lista = new ArrayList<TpTamanhoUniforme>();
		for (TpTamanhoUniforme e : TpTamanhoUniforme.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaTpTamanhoUniformeString() {
		List<String> lista = new ArrayList<String>();
		for (TpTamanhoUniforme e : TpTamanhoUniforme.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
