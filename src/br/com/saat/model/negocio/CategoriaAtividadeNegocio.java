package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.AtividadeAvaliacao;
import br.com.saat.model.CategoriaAtividade;
import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.dao.AtividadeAvaliacaoDAO;
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

	public List<CategoriaAtividade> buscaCategoriasAtividades() throws Exception {
		try {
			CategoriaAtividadeDAO dao = new CategoriaAtividadeDAO();
			List<CategoriaAtividade> lista = dao.buscaCategoriaAtividade();
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os dados de referência.");
		}
	}

	public boolean desativar(CategoriaAtividade catAtiv) throws Exception {
		boolean retorno = false;
		try {
			CategoriaAtividadeDAO dao = new CategoriaAtividadeDAO();
			if (dao.desativar(catAtiv)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao o dados de referência.");
		}
		return retorno;
	}

	public List<CategoriaAtividade> buscarAtividades(CategoriaAvaliacao categoria) throws Exception {
		try {
			CategoriaAtividadeDAO dao = new CategoriaAtividadeDAO();
			List<CategoriaAtividade> lista = dao.buscarAtividades(categoria);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar as atividades do dado de referência.");
		}
	}

	public boolean editar(List<CategoriaAtividade> categoriaAtividades,
			String[] categoriasSelecionadas) throws Exception {
		boolean retorno = true;
		try {
			CategoriaAtividadeDAO dao = new CategoriaAtividadeDAO();
			
			for (String idCategoria : categoriasSelecionadas) {
				CategoriaAvaliacao categoria = new CategoriaAvaliacao();
				categoria.setIdCategoriaAvaliacao(Integer.parseInt(idCategoria));
				for (CategoriaAtividade catAtiv : categoriaAtividades) {
					catAtiv.setCategoriaAvaliacao(categoria);
					if (!dao.editar(catAtiv)) {
						retorno = false;
						break;
					}
				} 
			}
			
			String idAtividades = "";
			int i = 0;
			for (CategoriaAtividade atividade : categoriaAtividades) {
				idAtividades += atividade.getAtividadeAvaliacao().getIdAtividadeAvaliacao();
				i++;
				if (i < categoriaAtividades.size()) {
					idAtividades += ", ";
				}
			}
			
			for (String idCategoria : categoriasSelecionadas) {
				if (!dao.reciclarCatAtiv(idCategoria, idAtividades)) {
					retorno = false;
				}
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir a atividade.");
		}
		return retorno;
	}

	public List<CategoriaAtividade> buscarAtividadesCat(int idCategoria) throws Exception {
		try {
			CategoriaAtividadeDAO dao = new CategoriaAtividadeDAO();
			List<CategoriaAtividade> lista = dao.buscarAtividadesCat(idCategoria);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar as atividades do dado de referência.");
		}
	}

}
