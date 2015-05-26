package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Prontuario;
import br.com.saat.model.dao.ProntuarioDAO;

public class ProntuarioNegocio {

	public List<Object> validaDados(Prontuario prontuario) {
		List<Object> lista = new ArrayList<Object>();

		if ("".equals(prontuario.getDtAtendimento()) || prontuario.getDtAtendimento() == null) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Data' !");
		} else if ("".equals(prontuario.getHrAtendimento()) || prontuario.getHrAtendimento() == null) {
			lista.add(false);
			lista.add("Selecione corretamente o campo 'Hora' !");
		} else if ("".equals(prontuario.getAnotacao())) {
			lista.add(false);
			lista.add("Informe corretamente o campo 'Anotação' !");
		} else {
			lista.add(true);
		}

		return lista;
	}

	public boolean inserir(Prontuario prontuario) throws Exception {
		boolean retorno = false;

		try {
			ProntuarioDAO dao = new ProntuarioDAO();
			if (dao.inserir(prontuario)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"Erro! Ocorreu algum erro ao inserir o atendimento.");
		}

		return retorno;
	}

	public List<Prontuario> buscaHistorico(int idAtleta, int idUsuario) throws Exception{
		try {
			ProntuarioDAO dao = new ProntuarioDAO();
			List<Prontuario> lista = dao.buscaHistorico(idAtleta, idUsuario);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o histórico de atendimentos.");
		}
	}
	
	public List<Prontuario> buscaUltimosAtend(int idUsuario) throws Exception {
		try {
			ProntuarioDAO dao = new ProntuarioDAO();
			List<Prontuario> lista = dao.buscaUltimosAtend(idUsuario);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os últimos atendimentos.");
		}
	}

	public boolean excluir(int idProntuario) throws Exception{
		boolean retorno = false;

		try {
			ProntuarioDAO dao = new ProntuarioDAO();
			if (dao.excluir(idProntuario)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao excluir o atendimento.");
		}

		return retorno;
	}

	public boolean alterar(Prontuario prontuario) throws Exception {
		boolean retorno = false;

		try {
			ProntuarioDAO dao = new ProntuarioDAO();
			if (dao.alterar(prontuario)) {
				retorno = true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao editar o atendimento.");
		}

		return retorno;
	}



}
