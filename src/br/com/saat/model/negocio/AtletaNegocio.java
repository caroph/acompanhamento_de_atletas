package br.com.saat.model.negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.AvaliacaoDesempenho;
import br.com.saat.model.dao.AtletaDAO;

public class AtletaNegocio {

	public AtletaNegocio(){}

	public List<Object> validaDados(Atleta atleta) throws Exception {
		List<Object> lista = new ArrayList<Object>();
		AtletaDAO dao = new AtletaDAO();
		
		try{
			String codigoExistente = dao.verificarCodigos(atleta.getIdPessoa(), atleta.getNrMatricula(),
					atleta.getNrCadCBT(), atleta.getNrCadFPT());
			
			if (atleta.getIdTpEquipe() == 0) {
				lista.add(false);
				lista.add("Selecione corretamente o campo 'Equipe' !");
			}else if ("".equals(atleta.getNrMatricula()) || atleta.getNrMatricula() == null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'Nº Matrícula Clube Curitibano' !");
			} else if ("".equals(atleta.getNome()) || atleta.getNome() == null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'Nome' !");
			} else if ("".equals(atleta.getDtNascimento()) || atleta.getDtNascimento() == null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'Data de Nascimento' !");
			} else if ("".equals(atleta.getRG()) || atleta.getRG()== null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'RG' !");
			} else if ("".equals(atleta.getCPF()) || atleta.getCPF() == null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'CPF' !");
			} else if ("".equals(atleta.getNmContatoEmergencia()) || atleta.getNmContatoEmergencia() == null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'Nome Contato Emergência' !");
			} else if ("".equals(atleta.getTelContatoEmergencia()) || atleta.getTelContatoEmergencia() == null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'Telefone Contato de Emergência' !");
			} else if ("".equals(atleta.getDtValidade()) || atleta.getDtValidade() == null) {
				lista.add(false);
				lista.add("Informe corretamente o campo 'Data de Validade' !");
			}else if(!"".equals(codigoExistente)){
				lista.add(false);
				lista.add(codigoExistente);
			}else if(new Date().before(atleta.getDtNascimento())){
				lista.add(false);
				lista.add("A Data de nascimento deve ser menor que a data atual!");
			}else if(new Date().after(atleta.getDtValidade())){
				lista.add(false);
				lista.add("A Data de validade deve ser maior que a data atual!");
			}else {
				lista.add(true);
			}
		}catch(Exception ex){
			throw new Exception("Ocorreu algum erro ao buscar atletas com mesmos numeros de cadastro!");
		}
		
		return lista;
	}

	public int inserir(Atleta atleta) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			int idAtleta = dao.inserir(atleta);
			return idAtleta;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir o atleta.");
		}
	}

	public boolean alterar(Atleta atleta) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			if (dao.alterar(atleta)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao alterar o atleta.");
		}
		return false;
	}

	public List<Atleta> buscarAtletas(int ativo) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			List<Atleta> lista = dao.buscarAtletas(ativo);
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os atletas.");
		}
	}

	public Atleta buscarAtleta(int idAtleta) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			Atleta atleta = dao.buscarAtleta(idAtleta);
			return atleta;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o atleta.");
		}
	}
	
	public List<Integer> buscaDiasTreinoAtleta(int idAtleta) throws Exception{
		List<Integer> lista = new ArrayList<Integer>();
		try {
			AtletaDAO dao = new AtletaDAO();
			lista = dao.buscaDiasTreinoAtleta(idAtleta);
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os dias de treino do atleta.");
		}
		return lista;
	}

	public boolean desativar(Atleta atleta) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			if (dao.desativar(atleta)) {
				if(dao.desativarDocs(atleta)){
					if(dao.excluirPendencias(atleta)){
						return true;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao desativar o atleta!");
		}
		return false;
	}

	public boolean ativar(Atleta atleta) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			if (dao.ativar(atleta)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao ativar o atleta!");
		}
		return false;
	}
	
	public boolean inserirPendenciaAtleta(int idAtleta) throws Exception{
		try {
			AtletaDAO dao = new AtletaDAO();
			if (dao.inserirPendenciaAtleta(idAtleta)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao inserir pendêcias para o atleta!");
		}
		return false;
	}

	public boolean vincularResponsavel(int idAtleta, int idResponsavel,
			int idGrauParentesco) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			if (dao.vincularResponsavel(idAtleta, idResponsavel, idGrauParentesco)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao vincular o responsável!");
		}
		return false;
	}

	public Atleta buscarAtletaDetalhes(int idAtleta) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			Atleta atleta = dao.buscarAtletaDetalhes(idAtleta);
			DateFormat formatter = new SimpleDateFormat("dd/MM/YYYY"); 
			String dt = formatter.format(atleta.getDtNascimento());
			atleta.setDtNascimentoDisplay(dt);
			return atleta;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o atleta.");
		}
	}

	public List<Atleta> buscarAtletasVinculados(int idResponsavel) throws Exception {
		try {
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			AtletaDAO dao = new AtletaDAO();
			listaAtleta = dao.buscarAtletasVinculados(idResponsavel);
			return listaAtleta;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os atletas vinculados ao responsável.");
		}
	}

	public List<Atleta> buscarAtletasAptos() throws Exception {
		try {
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			AtletaDAO dao = new AtletaDAO();
			listaAtleta = dao.buscarAtletasAptos();
			return listaAtleta;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar os atletas aptos a participar de torneios.");
		}
	}

	public List<Atleta> buscarAtletasPorNome(String busca, String diaTreino) throws Exception {
		try {
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			AtletaDAO dao = new AtletaDAO();
			int idDiaTreino = Integer.parseInt(diaTreino);
			listaAtleta = dao.buscarAtletasPorNome(busca, idDiaTreino);
			return listaAtleta;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o nome dos atletas.");
		}
	}

	public List<Integer> buscarAtletasSelecionados(int idTorneio) throws Exception {
		try {
			List<Integer> listaAtleta = new ArrayList<Integer>();
			AtletaDAO dao = new AtletaDAO();
			listaAtleta = dao.buscarAtletasSelecionados(idTorneio);
			return listaAtleta;
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao buscar o nome dos atletas participantes.");
		}
	}

	public List<Atleta> buscarAtletaBonificacao(Integer mes, int ano) throws Exception{
		try {
			List<Atleta> listaAtleta = new ArrayList<Atleta>();
			AtletaDAO dao = new AtletaDAO();
			listaAtleta = dao.buscarAtletaBonificacao(mes, ano);
			return listaAtleta;
		} catch (Exception e) {
			throw new Exception("Ocorreu algum erro ao buscar o os atletas.");
		}
	}

	public boolean salvarBonificacaoAtleta(AvaliacaoDesempenho bonificacao) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			if(bonificacao.getMes() == 0){
				throw new Exception("O mês deve ser pré selecionado");
			}
			if(bonificacao.getAno() == 0){
				throw new Exception("O ano deve ser pré selecionado");
			}
			return dao.salvarBonificacaoAtleta(bonificacao);
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao cadastrar a bonificação do atleta!");
		}
	}

	public boolean editarBonificacaoAtleta(AvaliacaoDesempenho bonificacao) throws Exception {
		try {
			AtletaDAO dao = new AtletaDAO();
			if(bonificacao.getMes() == 0){
				throw new Exception("O mês deve ser pré selecionado");
			}
			if(bonificacao.getAno() == 0){
				throw new Exception("O ano deve ser pré selecionado");
			}
			return dao.editarBonificacaoAtleta(bonificacao);
		} catch (Exception e) {
			throw new Exception("Erro! Ocorreu algum erro ao editar a bonificação do atleta!");
		}
	}
	
}
