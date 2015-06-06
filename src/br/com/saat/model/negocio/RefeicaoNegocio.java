package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.enumeradores.Refeicao;

public class RefeicaoNegocio {
	public List<Refeicao> listaRefeicao() {
		List<Refeicao> lista = new ArrayList<Refeicao>();
		for (Refeicao e : Refeicao.values()) {
			lista.add(e);
		}
		return lista;
	}

	public List<String> listaRefeicaoString() {
		List<String> lista = new ArrayList<String>();
		for (Refeicao e : Refeicao.values()) {
			lista.add(e.getNome());
		}
		return lista;
	}
}
