package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Equipes;

public class EquipesNegocio {

	public EquipesNegocio() {
	}

	public List<Equipes> listaEquipes() {
		List<Equipes> lista = new ArrayList<Equipes>();
		for (Equipes e : Equipes.values()) {
			lista.add(e);
		}
		return lista;
	}

}
