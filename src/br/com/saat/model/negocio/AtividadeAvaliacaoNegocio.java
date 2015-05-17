package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AtividadeAvaliacao;
import br.com.saat.model.dao.AtividadeAvaliacaoDAO;

public class AtividadeAvaliacaoNegocio {
	
	public List<Object> validaDados(AtividadeAvaliacao atividade) {
		List<Object> lista = new ArrayList<Object>();

		if ("".equals(atividade.getCapacidade()) || atividade.getCapacidade() == null) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Capacidade' !");
		} else if(atividade.getTeste() == null || "".equals(atividade.getTeste())){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Teste' !");
		}else if(atividade.getIdUnidadeDeMedida() == 0){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Unidade de medida' !");
		}  else {
			lista.add(true);
		}
		return lista;
	}

	public boolean inserir(AtividadeAvaliacao atividade) throws Exception {
		boolean retorno = false;
		try {
			AtividadeAvaliacaoDAO dao = new AtividadeAvaliacaoDAO();
			if (dao.inserir(atividade)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir a atividade.");
		}
		return retorno;
	}

	public List<AtividadeAvaliacao> buscarAtividades(int tipoConsulta, int idCategoria) throws Exception {
		try {
			AtividadeAvaliacaoDAO dao = new AtividadeAvaliacaoDAO();
			List<AtividadeAvaliacao> lista = dao.buscarAtividades(tipoConsulta, idCategoria);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar as atividades.");
		}
	}

	public boolean desativar(AtividadeAvaliacao atividade) throws Exception {
		boolean retorno = false;
		try {
			AtividadeAvaliacaoDAO dao = new AtividadeAvaliacaoDAO();
			if (dao.desativar(atividade)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao excluir a atividade.");
		}
		return retorno;
	}
	
}
