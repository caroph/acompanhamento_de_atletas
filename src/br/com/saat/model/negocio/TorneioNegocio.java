package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.dao.Torneio;

public class TorneioNegocio {
	
	public List<Object> validaDados(Torneio torneio) {
		List<Object> lista = new ArrayList<Object>();

		if ("".equals(torneio.getNome()) || torneio.getNome() == null) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Nome' !");
		} else if(torneio.getEstado() == null || torneio.getEstado() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Estado' !");
		}else if(torneio.getCidade() == null || torneio.getCidade() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Cidade' !");
		} else if ("".equals(torneio.getDtInicial())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Data Inicial' !");
		} else if ("".equals(torneio.getDtFinal())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Data Final' !");
		} else if(torneio.getDtInicial().after(torneio.getDtFinal())){
			lista.add(false);
			lista.add("A data inicial deve ser menor que a data final !");
		} else if (torneio.getIdNaipe() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Naipe' !");
		}else if (torneio.getIdCatTorneio() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Categoria' !");
		}else if (torneio.getIdTpTorneio() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Tipo' !");
		}else if (torneio.getIdGpTorneio() == 0) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Grupo' !");
		}  else {
			lista.add(true);
		}
		return lista;
	}

	public int inserir(Torneio torneio) throws Exception {
		int idNovoTorneio = 0;
		try {
			TorneioDAO dao = new TorneioDAO();
			idNovoTorneio = dao.inserir(torneio);
		} catch (Exception e) {
			throw new Exception(
					"Erro! Ocorreu algum erro ao inserir o torneio.");
		}
		return idNovoTorneio;
	}
	
	public boolean inserirAtletasPart(String[] atletasPart, int idNovoTorneio) throws Exception {
		boolean retorno = true;
		try {
			TorneioDAO dao = new TorneioDAO();
			for (String idAtleta : atletasPart) {
				if (!dao.inserirAtletasPart(idAtleta, idNovoTorneio)) {
					return false;
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"Erro! Ocorreu algum erro ao inserir os atletas participantes do torneio.");
		}
		return retorno;
	}

	public List<Torneio> buscarTorneios() throws Exception{
		try {
			TorneioDAO dao = new TorneioDAO();
			List<Torneio> lista = dao.buscarTorneios();
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os torneios.");
		}
	}

	public boolean desativar(Torneio torneio) throws Exception{
		boolean retorno = false;
		try {
			TorneioDAO dao = new TorneioDAO();
			if (dao.desativar(torneio)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao excluir o torneio.");
		}
		return retorno;
	}

	public Torneio buscarTorneio(int idTorneio) throws Exception {
		Torneio torneio = new Torneio();
		try {
			TorneioDAO dao = new TorneioDAO();
			torneio = dao.buscaTorneio(idTorneio);
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o torneio.");
		}
		return torneio;
	}

	public List<Atleta> buscaAtletasPart(int idTorneio) throws Exception {
		try {
			TorneioDAO dao = new TorneioDAO();
			List<Atleta> lista = dao.buscaAtletasPart(idTorneio);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os atletas participantes.");
		}
	}


}
