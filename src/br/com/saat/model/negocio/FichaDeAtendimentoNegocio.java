package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import br.com.saat.model.FichaDeAtendimento;
import br.com.saat.model.dao.FichaDeAtendimentoDAO;

public class FichaDeAtendimentoNegocio {

	public FichaDeAtendimento buscarUltimaFicha(int idAtleta) throws Exception{
		try{
			FichaDeAtendimentoDAO dao  = new FichaDeAtendimentoDAO();
			FichaDeAtendimento ficha = dao.buscarUltimaFicha(idAtleta);
			if(ficha != null)
				return ficha;
			else{
				ficha = new FichaDeAtendimento();
				ficha.setIdFichaDeAtendimento(0);
				return ficha;
			}
		}catch (Exception ex) {
			throw ex;
		}
	}

	public int inserir(FichaDeAtendimento ficha) throws Exception{
		try{
			FichaDeAtendimentoDAO dao  = new FichaDeAtendimentoDAO();
			int idFichaInserida = dao.inserir(ficha);
			if(idFichaInserida > 0){
				AvaliacaoAntropometricaNegocio avaliacaoNegocio = new AvaliacaoAntropometricaNegocio();
				int idAvaliacaoInserida = avaliacaoNegocio.inserir(ficha.getAvaliacaoAntropometrica(), idFichaInserida);
				if(idAvaliacaoInserida > 0){
					ficha.getAvaliacaoAntropometrica().setIdAvaliacaoAntropometrica(idAvaliacaoInserida);
					return idFichaInserida;
				}else{
					throw new Exception("Erro ao inserir avaliação antropométrica no banco!");
				}				
			}				
			else 
				throw new Exception("Erro ao inserir ficha de atendimento no banco!");
		}catch (Exception ex) {
			throw ex;
		}
	}

	public boolean alterar(FichaDeAtendimento ficha) throws Exception{
		try{
			FichaDeAtendimentoDAO dao = new FichaDeAtendimentoDAO();
			if(dao.alterar(ficha)){
				AvaliacaoAntropometricaNegocio avaliacaoNegocio = new AvaliacaoAntropometricaNegocio();
				if(avaliacaoNegocio.alterar(ficha.getAvaliacaoAntropometrica(), ficha.getIdFichaDeAtendimento()))				
					return true;
				else
					throw new Exception("Erro ao alterar a avaliação antropometrica");
			}else
				throw new Exception("Erro ao alterar ficha de atendimento!");
		}catch(Exception ex){
			throw ex;
		}
	}

	public HashMap<Integer, Date> buscarHistoricoAtendimento(int idAtleta) throws Exception{
		try{
			FichaDeAtendimentoDAO dao = new FichaDeAtendimentoDAO();
			HashMap<Integer, Date> lista = dao.buscarHistoricoAtendimento(idAtleta);
			if(lista.size() > 0){
				return lista;
			}else
				return null;
		}catch(Exception ex){
			throw ex;
		}		
	}

	public FichaDeAtendimento buscarPorId(int idFichaDeAtendimento) throws Exception {
		try{
			FichaDeAtendimentoDAO dao = new FichaDeAtendimentoDAO();
			return dao.buscarPorId(idFichaDeAtendimento);
		}catch(Exception ex){
			throw ex;
		}
	}

	public ArrayList<ArrayList<String>> buscarUltimosAtendimentos(int idPessoa) throws Exception{
		try{
			ArrayList<ArrayList<String>> listaUltimosAtendimentos = null;
			FichaDeAtendimentoDAO dao = new FichaDeAtendimentoDAO();
			listaUltimosAtendimentos = dao.buscarUltimosAtendimentos(idPessoa);
			
			if(listaUltimosAtendimentos.size() > 0){
				return listaUltimosAtendimentos;
			}else
				return null;
			
		}catch(Exception ex){
			throw ex;
		}
	}
}
