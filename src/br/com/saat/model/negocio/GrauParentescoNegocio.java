package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.GrauParentesco;

public class GrauParentescoNegocio {
	public GrauParentescoNegocio() {
	}

	public List<GrauParentesco> listaGraus() {
		List<GrauParentesco> lista = new ArrayList<GrauParentesco>();
		for (GrauParentesco g : GrauParentesco.values()) {
			lista.add(g);
		}
		return lista;
	}

	public List<String> listaGrausString() {
		List<String> lista = new ArrayList<String>();
		for (GrauParentesco g : GrauParentesco.values()) {
			lista.add(g.getNome());
		}
		return lista;
	}
}
