package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.dao.CategoriaAvaliacaoDAO;

public class CategoriaAvaliacaoNegocio {
	
	public List<Object> validaDados(CategoriaAvaliacao categoria, List<Integer> tiposSelecionados) {
		List<Object> lista = new ArrayList<Object>();

		if (tiposSelecionados.isEmpty()) {
			lista.add(false);
			lista.add("Selecione ao menor um 'Tipo' de categoria !");
		} else if(categoria.getNmCategoria() == null || "".equals(categoria.getNmCategoria())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Nome' !");
		} else if(categoria.getIdadeMinima() <= 0){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Idade mínima' !");
		} else if(categoria.getIdadeMaxima() <= 0){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Idade máxima' !");
		} else if(categoria.getIdadeMinima() > categoria.getIdadeMaxima()){
			lista.add(false);
			lista.add("'Idade mínima' deve ser menos ou igual a 'Idade máxima' !");
		} else if("".equals(categoria.getSexo()) || categoria.getSexo() == null){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Sexo' !");
		} else {
			lista.add(true);
		}
		return lista;
	}

	public boolean inserir(CategoriaAvaliacao categoria, List<Integer> tiposSelecionados) throws Exception {
		boolean retorno = true;
		try {
			CategoriaAvaliacaoDAO dao = new CategoriaAvaliacaoDAO();
			for (Integer tipo : tiposSelecionados) {
				categoria.setIdTipoCat(tipo);
				if (!dao.inserir(categoria)) {
					retorno = false;
					break;
				}
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir a categoria.");
		}
		return retorno;
	}

	public List<CategoriaAvaliacao> buscarCategorias(int tipoConsulta) throws Exception {
		try {
			CategoriaAvaliacaoDAO dao = new CategoriaAvaliacaoDAO();
			List<CategoriaAvaliacao> lista = dao.buscarCategorias(tipoConsulta);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar as categorias.");
		}
	}

	public boolean desativar(CategoriaAvaliacao categoria) throws Exception {
		boolean retorno = false;
		try {
			CategoriaAvaliacaoDAO dao = new CategoriaAvaliacaoDAO();
			if (dao.desativar(categoria)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao excluir a categoria.");
		}
		return retorno;
	}
}
