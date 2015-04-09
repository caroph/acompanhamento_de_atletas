package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.DiasSemana;

public class DiasSemanaNegocio {

	public DiasSemanaNegocio() {}

	public List<DiasSemana> listaSemana(){
		List<DiasSemana> lista = new ArrayList<DiasSemana>();
		for (DiasSemana d : DiasSemana.values()) {
			lista.add(d);
			}		
		return lista;
	}
	
	public List<String> listaSemanaString(){
		List<String> lista = new ArrayList<String>();
		for (DiasSemana d : DiasSemana.values()) {
			lista.add(d.getNome());
			}		
		return lista;
	}
}
