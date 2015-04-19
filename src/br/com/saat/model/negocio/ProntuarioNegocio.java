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
//	public boolean inserirDiaTreinoAtleta(String[] diasTreino, int idAtleta) throws Exception {
//		boolean retorno = true;
//
//		try {
//			DiaTreinoDAO dao = new DiaTreinoDAO();
//			for (String idDia : diasTreino) {
//				if (!dao.inserirDiaTreinoAtleta(idDia, idAtleta)) {
//					return false;
//				}
//			}
//		} catch (Exception e) {
//			throw new Exception(
//				"Erro! Ocorreu algum erro ao inserir os dias de treino do atleta.");
//		}
//
//		return retorno;
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
//
//	public DiaTreino buscarDiaTreino(String data, int idAtleta, String hr) throws Exception {
//		Date dt = new Date();
//		DateFormat formatter = new SimpleDateFormat("HH:mm"); 
//		SimpleDateFormat formatterData = new SimpleDateFormat("yyyy-MM-dd");
//    	Date hora = new Date();
//		
//		if(!"".equals(data))
//			dt = formatterData.parse(data);		 
//		
//		if(!"".equals(hr)){
//			try {
//				hora = (Date)formatter.parse(hr);
//			} catch (Exception e) {
//				throw new Exception("Erro ao formatar o horário de treino");
//			}
//		}
//		
//		Calendar c = Calendar.getInstance();
//		c.setTime(dt);
//		int semana = c.get(Calendar.DAY_OF_WEEK);
//		
//		try {
//			DiaTreinoDAO dao = new DiaTreinoDAO();
//			DiaTreino dia = dao.buscarDiaTreino(semana, idAtleta, hora);
//			return dia;
//		} catch (Exception e) {
//			throw new Exception("Erro! Ocorreu algum erro ao buscar os dias de treinos.");
//		}
//	} 



}
