package br.com.saat.model.negocio;

import java.util.Date;

import br.com.saat.model.dao.RelatorioDAO;

public class RelatorioNegocio {
	public RelatorioNegocio(){}

	public void verificarResultadoRelatorioRetiradaAtleta(int idAtleta) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioRetiradaAtleta(idAtleta);
		} catch (Exception e) {
			throw new Exception("Nenhuma retirada encontrada para o atleta selecionado!");
		}		
	}

	public void verificarResultadoRelatorioRetiradaPeca(int tpUniforme) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioRetiradaPeca(tpUniforme);
		} catch (Exception e) {
			throw new Exception("Nenhuma retirada encontrada para o tipo de peça selecionado!");
		}
	}

	public void verificarResultadoRelatorioResultadoTorneio(int idTorneio) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioResultadoTorneio(idTorneio);
		} catch (Exception e) {
			throw new Exception("Nenhum resultado encontrado para o torneio selecionado!");
		}
	}

	public void verificarResultadoRelatorioFrequenciaTorneioAtleta(Date inicio, Date fim) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioFrequenciaTorneioAtleta(inicio, fim);
		} catch (Exception e) {
			throw new Exception("Nenhum resultado encontrado no período selecionado!");
		}		
	}

	public void verificarResultadoRelatorioFrequenciaTorneioTipo(Date inicio, Date fim) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioFrequenciaTorneioTipo(inicio, fim);
		} catch (Exception e) {
			throw new Exception("Nenhum resultado encontrado no período selecionado!");
		}
	}

	public void verificarResultadoRelatorioFrequenciaTorneio(Date inicio, Date fim) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioFrequenciaTorneio(inicio, fim);
		} catch (Exception e) {
			throw new Exception("Nenhum resultado encontrado no período selecionado!");
		}
	}

	public void verificarResultadoRelatorioPresencaTreinos(Date inicio, Date fim) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioPresencaTreinos(inicio, fim);
		} catch (Exception e) {
			throw new Exception("Nenhum resultado encontrado no período selecionado!");
		}
	}

	public void verificarResultadoRelatorioPresencaMedica(Date inicio, Date fim) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioPresencaMedica(inicio, fim);
		} catch (Exception e) {
			throw new Exception("Nenhum resultado encontrado no período selecionado!");
		}
	}

	public void verificarResultadoRelatorioBonificacaoGeral(int mes, int ano) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioBonificacaoGeral(mes, ano);
		} catch (Exception e) {
			throw new Exception("Nenhum resultado encontrado para o mês e ano selecionado!");
		}
	}

	public void verificarResultadoRelatorioBonificacaoIndividual(int idAtleta) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoRelatorioBonificacaoIndividual(idAtleta);
		} catch (Exception e) {
			throw new Exception("Nenhuma bonificação encontrada para o atleta selecionado!");
		}
	}

	public void verificarResultadoHistoricoObservacoes(int idAtleta) throws Exception {
		try {
			RelatorioDAO dao = new RelatorioDAO();
			dao.verificarResultadoHistoricoObservacoes(idAtleta);
		} catch (Exception e) {
			throw new Exception("Nenhuma observação encontrada para o atleta selecionado!");
		}
	}
}
