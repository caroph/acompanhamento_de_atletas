package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.CategoriaAvaliacao;
import br.com.saat.model.dao.CategoriaAvaliacaoDAO;

public class CategoriaAvaliacaoNegocio {
	
	public List<Object> validaDados(CategoriaAvaliacao categoria) {
		List<Object> lista = new ArrayList<Object>();

		if (categoria.getIdTipoCat() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Tipo' !");
		} else if(categoria.getNmCategoria() == null || categoria.getNmCategoria() == ""){
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

	public boolean inserir(CategoriaAvaliacao categoria) throws Exception {
		boolean retorno = false;
		try {
			CategoriaAvaliacaoDAO dao = new CategoriaAvaliacaoDAO();
			if (dao.inserir(categoria)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir a categoria.");
		}
		return retorno;
	}

	public List<CategoriaAvaliacao> buscarCategorias() throws Exception {
		try {
			CategoriaAvaliacaoDAO dao = new CategoriaAvaliacaoDAO();
			List<CategoriaAvaliacao> lista = dao.buscarCategorias();
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
