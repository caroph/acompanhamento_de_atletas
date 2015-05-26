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
			throw new Exception("Erro ao compartilhar observação!");
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

	public boolean desativarObservacao(int idObservacao) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.desativarObservacao(idObservacao);
		}catch(Exception ex){
			throw new Exception("Erro ao desativar observação!");
		}
	}

	public boolean alterarObservacao(Observacao observacao) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.alterarObservacao(observacao);
		}catch(Exception ex){
			throw new Exception("Erro ao editar observação!");
		}
	}

	public boolean excluirVisualizacaoObservacao(int idObservacao) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.excluirVisualizacaoObservacao(idObservacao);
		}catch(Exception ex){
			throw new Exception("Erro ao editar a compartilhação da observação!");
		}
	}
	
	public int buscarObservacoesNotificacao(int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.buscarObservacoesNotificacao(idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar notificações de observação!");
		}
	}

	public boolean salvarObservacaoVisualizada(int idObservacao, int idUsuario) throws Exception {
		try{
			ObservacaoDAO dao = new ObservacaoDAO();
			return dao.salvarObservacaoVisualizada(idObservacao, idUsuario);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar salvar visualização da observação!");
		}
	}
}
