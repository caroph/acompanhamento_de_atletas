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
			throw new Exception("Erro ao salvar observa��o!");
		}
	}

	public boolean salvarVisualizacaoObservacao(int idObservacao, int idUsuario) throws Exception{
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.salvarVisualizacaoObservacao(idObservacao, idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao compartilhar observa��o!");
		}
	}

	public List<Observacao> buscarObservacoesAtivas(int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.buscarObservacoesAtivas(idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar observa��es ativas!");
		}
	}

	public List<Observacao> buscarMinhasObservacoes(int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.buscarMinhasObservacoes(idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar minhas observa��es!");
		}
	}

	public boolean desativarObservacao(int idObservacao) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.desativarObservacao(idObservacao);
		}catch(Exception ex){
			throw new Exception("Erro ao desativar observa��o!");
		}
	}

	public boolean alterarObservacao(Observacao observacao) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.alterarObservacao(observacao);
		}catch(Exception ex){
			throw new Exception("Erro ao editar observa��o!");
		}
	}

	public boolean excluirVisualizacaoObservacao(int idObservacao) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.excluirVisualizacaoObservacao(idObservacao);
		}catch(Exception ex){
			throw new Exception("Erro ao editar a compartilha��o da observa��o!");
		}
	}
	
	public int buscarObservacoesNotificacao(int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.buscarObservacoesNotificacao(idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar notifica��es de observa��o!");
		}
	}

	public boolean salvarObservacaoVisualizada(int idObservacao, int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.salvarObservacaoVisualizada(idObservacao, idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar salvar visualiza��o da observa��o!");
		}
	}
}
