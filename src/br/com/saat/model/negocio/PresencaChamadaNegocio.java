package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.saat.enumeradores.Presenca;
import br.com.saat.model.Atleta;
import br.com.saat.model.PresencaChamada;
import br.com.saat.model.dao.PresencaChamadaDAO;

public class PresencaChamadaNegocio {
	public PresencaChamadaNegocio(){}

	public boolean salvarPresencaChamada(PresencaChamada presenca) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.salvarPresencaChamada(presenca);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presen�a");
		}
	}

	public List<PresencaChamada> buscarPresencasPorChamada(int idChamada) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.buscarPresencasPorChamada(idChamada);
		}catch(Exception ex){
			throw new Exception("Erro ao registrar presen�a");
		}
	}

	public boolean excluirPresencaChamada(int idChamada) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.excluirPresencaChamada(idChamada);
		}catch(Exception ex){
			throw new Exception("Erro ao alterar presen�a chamada");
		}
	}

	public List<Atleta> buscarPresencasPorData(Date dt, int idDiaTreino) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.buscarPresencasPorData(dt, idDiaTreino);
		}catch(Exception ex){
			throw new Exception("Erro ao buscar chamada");
		}
	}

	public boolean alterarPresencaChamada(PresencaChamada presenca, String tpPresenca) throws Exception{
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.alterarPresencaChamada(presenca, tpPresenca);
		}catch(Exception ex){
			throw new Exception("Erro ao editar chamada");
		}
		
	}

	public int verificarPresenca(int idChamada, int idAtleta) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.verificarPresenca(idChamada, idAtleta);
		}catch(Exception ex){
			throw new Exception("Erro ao verificar se j� existe presen�a para o atleta chamada");
		}
	}

	public boolean salvarPresencaChamada(PresencaChamada presenca, String tpPresenca) throws Exception {
		PresencaChamadaDAO dao = new PresencaChamadaDAO();
		try{
			return dao.salvarPresencaChamada(presenca, tpPresenca);
		}catch(Exception ex){
			throw new Exception("Erro ao salvar presen�a");
		}
	}

	public List<Object> validaDados(PresencaChamada presenca, String tpPresenca) {
		List<Object> lista = new ArrayList<Object>();
		
		if("T".equals(tpPresenca) && presenca.getEstadoPresencaT() == Presenca.Outros.getValor()
					&& "".equals(presenca.getJustificativaT())){
			lista.add(false);
			lista.add("� obrigat�rio o preenchimento da justificativa quando � selecionada a op��o outros");
		}else if(presenca.getEstadoPresencaF() == Presenca.Outros.getValor()
					&& "".equals(presenca.getJustificativaF())){
			lista.add(false);
			lista.add("� obrigat�rio o preenchimento da justificativa quando � selecionada a op��o outros");
		}else{
			lista.add(true);
		}
		
		return lista;
	}
	
}
