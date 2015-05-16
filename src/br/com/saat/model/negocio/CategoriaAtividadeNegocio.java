package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.CategoriaAtividade;
import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.dao.CategoriaAtividadeDAO;

public class CategoriaAtividadeNegocio {
	
	public List<Object> validaDados(List<CategoriaAtividade> categoriaAtividades, String[] categoriasSelecionadas) {
		List<Object> lista = new ArrayList<Object>();

		if (categoriasSelecionadas == null || "".equals(categoriasSelecionadas)) {
			lista.add(false);
			lista.add("Selecione ao menos uma 'Çategoria' !");
		} else if(categoriaAtividades == null || categoriaAtividades.isEmpty()){
			lista.add(false);
			lista.add("Selecione ao menos uma 'Atividade' !");
		} else {
			lista.add(true);
		}
		return lista;
	}

	public boolean inserir(List<CategoriaAtividade> categoriaAtividades,
			String[] categoriasSelecionadas) throws Exception {
		boolean retorno = true;
		try {
			CategoriaAtividadeDAO dao = new CategoriaAtividadeDAO();
			for (String idCategoria : categoriasSelecionadas) {
				CategoriaAvaliacao categoria = new CategoriaAvaliacao();
				categoria.setIdCategoriaAvaliacao(Integer.parseInt(idCategoria));
				for (CategoriaAtividade catAtiv : categoriaAtividades) {
					catAtiv.setCategoriaAvaliacao(categoria);
					if (!dao.inserir(catAtiv)) {
						retorno = false;
						break;
					}
				} 
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir a atividade.");
		}
		return retorno;
	}
	
//	public boolean inserir(AtividadeAvaliacao atividade) throws Exception {
//		boolean retorno = false;
//		try {
//			AtividadeAvaliacaoDAO dao = new AtividadeAvaliacaoDAO();
//			if (dao.inserir(atividade)) {
//				retorno = true;
//			}
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao inserir a atividade.");
//		}
//		return retorno;
//	}
//
//	public List<AtividadeAvaliacao> buscarAtividades() throws Exception {
//		try {
//			AtividadeAvaliacaoDAO dao = new AtividadeAvaliacaoDAO();
//			List<AtividadeAvaliacao> lista = dao.buscarAtividades();
//			return lista;
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao buscar as atividades.");
//		}
//	}
//
//	public boolean desativar(AtividadeAvaliacao atividade) throws Exception {
//		boolean retorno = false;
//		try {
//			AtividadeAvaliacaoDAO dao = new AtividadeAvaliacaoDAO();
//			if (dao.desativar(atividade)) {
//				retorno = true;
//			}
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao excluir a atividade.");
//		}
//		return retorno;
//	}

}
