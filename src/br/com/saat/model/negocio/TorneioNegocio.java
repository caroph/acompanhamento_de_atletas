package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.Usuario;
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

	public int inserir(Torneio torneio, Usuario usuario) throws Exception {
		int idNovoTorneio = 0;
		try {
			TorneioDAO dao = new TorneioDAO();
			idNovoTorneio = dao.inserir(torneio, usuario);
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

	public boolean desativar(Torneio torneio, Usuario usuario) throws Exception{
		boolean retorno = false;
		try {
			TorneioDAO dao = new TorneioDAO();
			if (dao.desativar(torneio, usuario)) {
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

	public boolean editarTorneio(Torneio torneio, String[] atletasPart, Usuario usuario) throws Exception {
		boolean retorno = true;
		try {
			TorneioDAO dao = new TorneioDAO();
			String idAtletas = "";
			int i = 0;
			if (dao.editar(torneio, usuario)) {
				if (!"".equals(atletasPart) && atletasPart != null) {
					for (String idAtleta : atletasPart) {
						idAtletas += idAtleta;
						i++;
						if (i < atletasPart.length) {
							idAtletas += ", ";
						}
					}
					if (dao.reciclarAtletasPart(idAtletas, torneio.getIdTorneio())) {
						for (String idAtleta : atletasPart) {
							if (!dao.inserirAtletasPart(idAtleta, torneio.getIdTorneio())) {
								return false;
							}
						}
					}
				} else {
					if (!dao.reciclarAtletasPart(idAtletas, torneio.getIdTorneio())) {
						return false;
					}
				}
			}
		} catch (Exception e) {
			retorno = false;
			throw new Exception(
					"Erro! Ocorreu algum erro ao editar o torneio.");
		}
		return retorno;
	}

	public List<Object> validaDadosFinalizar(Torneio torneio) {
		List<Object> lista = new ArrayList<Object>();

		if ("".equals(torneio.getInscritosGeral()) || torneio.getInscritosGeral() == 0) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Total incritos (geral)' !");
		} else if("".equals(torneio.getInscritosClube()) || torneio.getInscritosClube() == 0){
			lista.add(false);
			lista.add("Informe corretamente o campo ''Total incritos (Clube Curitibano)' !");
		} else if(torneio.getIdDestaque() == null || torneio.getIdDestaque().getIdPessoa() == 0){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Atleta destaque' !");
		} else if ("".equals(torneio.getFotografo())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Fotógrafo' !");
		} else if ("".equals(torneio.getEncaminhamentoMkt())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Encaminhar ao marketing em' !");
		} else {
			lista.add(true);
		}
		return lista;
	}

	public List<Object> validaAtletasPart(List<Atleta> listaAtletasPart) {
		List<Object> lista = new ArrayList<Object>();
		
		for (Atleta atleta : listaAtletasPart) {
			if (atleta.getColocacao() == null || "".equals(atleta.getColocacao())) {
				lista.add(false);
				lista.add("Favor informar corretamente a colocação do(a) atleta " + atleta.getNome() + "!");
				break;
			}
		}
		
		if (lista.size() == 0) {
			if (listaAtletasPart == null || listaAtletasPart.size() <= 0) {
				lista.add(false);
				lista.add("Erro ao consultar os atletas participantes do torneio!");
			} else {
				lista.add(true);
			}
		}
		
		return lista;
	}

	public boolean finalizarTorneio(Torneio torneio,
			List<Atleta> listaAtletasPart, Usuario usuario) throws Exception {
		boolean retorno = true;
		try {
			TorneioDAO dao = new TorneioDAO();
			if (dao.finalizar(torneio, usuario)) {
				for (Atleta atleta : listaAtletasPart) {
					if (!dao.inserirResulAtletasPart(atleta, torneio.getIdTorneio())) {
						return false;
					}
				}
			}
		} catch (Exception e) {
			retorno = false;
			throw new Exception(
					"Erro! Ocorreu algum erro ao finalizar o torneio.");
		}
		return retorno;
	}


}
