package br.com.saat.model.negocio;

import java.util.List;

import br.com.saat.model.Observacao;
import br.com.saat.model.dao.ObservacaoDAO;

public class ObservacaoNegocio {
	public ObservacaoNegocio(){}

	public int salvarObservacao(Observacao observacao) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.salvarObservacao(observacao);
		}catch(Exception ex){
			throw new Exception("Erro ao salvar observação!");
		}
	}

	public boolean salvarVisualizacaoObservacao(int idObservacao, int idUsuario) throws Exception{
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.salvarVisualizacaoObservacao(idObservacao, idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao salvar observação!");
		}
	}

	public List<Observacao> buscarObservacoesAtivas(int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.buscarObservacoesAtivas(idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar observações ativas!");
		}
	}

	public List<Observacao> buscarMinhasObservacoes(int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.buscarMinhasObservacoes(idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar minhas observações!");
		}
	}
}
