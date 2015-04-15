package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.saat.enumeradores.GrauParentesco;

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
	
	public Map<Integer, String> listaGrausObject(){
		Map<Integer,String> lista = new HashMap<Integer,String>();
		for (GrauParentesco g : GrauParentesco.values()) {
			lista.put(g.getValor(), g.getNome());
		}
		return lista;
	}
}
