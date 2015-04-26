package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

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
//
//	public List<DiaTreino> buscaDiasTreino() throws Exception{
//		try {
//			DiaTreinoDAO dao = new DiaTreinoDAO();
//			List<DiaTreino> lista = dao.buscaDiasTreinos();
//			return lista;
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao buscar os dias de treinos.");
//		}
//	}
//
//	public boolean desativar(DiaTreino dia) throws Exception{
//		boolean retorno = false;
//
//		try {
//			DiaTreinoDAO dao = new DiaTreinoDAO();
//			if (dao.desativar(dia)) {
//				retorno = true;
//			}
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao desativar o dia de treino.");
//		}
//
//		return retorno;
//	}
//
//	public List<DiaTreino> carregaDiasTreino(int idTpEquipe) throws Exception{
//		try {
//			DiaTreinoDAO dao = new DiaTreinoDAO();
//			List<DiaTreino> lista = dao.carregaDiasTreino(idTpEquipe);
//			return lista;
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao buscar os dias de treinos.");
//		}
//	}
//	
//	public boolean alterar(String[] diasTreino, int idAtleta) throws Exception {
//		try {
//			DiaTreinoDAO dao = new DiaTreinoDAO();
//			if(!dao.excluirDiasTreinoAtleta(idAtleta)){
//				return false;
//			}else{
//				inserirDiaTreinoAtleta(diasTreino, idAtleta);
//			}
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao alterar os dias de treino do atleta.");
//		}
//		return true;
//	}


}
