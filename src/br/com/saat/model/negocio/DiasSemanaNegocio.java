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
	
}
