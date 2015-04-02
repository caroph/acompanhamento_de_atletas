package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Turno;

public class TurnoNegocio {
	public TurnoNegocio() {
	}

	public List<Turno> listaTurnos() {
		List<Turno> lista = new ArrayList<Turno>();
		for (Turno t : Turno.values()) {
			lista.add(t);
		}
		return lista;
	}

}
