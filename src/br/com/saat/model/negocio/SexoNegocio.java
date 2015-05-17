package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.Sexo;

public class SexoNegocio {
	public List<Sexo> listaSexo() {
		List<Sexo> lista = new ArrayList<Sexo>();
		for (Sexo e : Sexo.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaSexoString() {
		List<String> lista = new ArrayList<String>();
		for (Sexo e : Sexo.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
