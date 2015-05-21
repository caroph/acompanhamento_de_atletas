package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.Mes;

public class MesNegocio {
	public MesNegocio(){}
	
	public List<Mes> listarMes() {
		List<Mes> lista = new ArrayList<Mes>();
		for (Mes g : Mes.values()) {
			lista.add(g);
		}
		return lista;
	}
}
