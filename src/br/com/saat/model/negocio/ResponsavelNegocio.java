package br.com.saat.model.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import br.com.saat.core.JavaMailApp;
import br.com.saat.model.Responsavel;
import br.com.saat.model.dao.ResponsavelDAO;

public class ResponsavelNegocio {
	
	public List<Object> validar(Responsavel responsavel)
	{
		List<Object> lista = new ArrayList<Object>();
		
		if(responsavel.getNome() == "" || responsavel.getNome() == null){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Nome' !");	
		}else if (responsavel.getEmail() == null || responsavel.getEmail() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Email' !");
		}else if(responsavel.getCelular() == null || responsavel.getCelular() == ""){
			lista.add(false);
			lista.add("Informe corretamente o campo 'Responsavel' !");
		}else{
			lista.add(true);
		}
		
		return lista;
	}
	
	
	public boolean inserir(Responsavel responsavel) throws Exception{
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			if(dao.inserir(responsavel))
				return true;
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao inserir o respons�vel");
		}
		return false;
	}
	
	public boolean alterar(Responsavel responsavel) throws Exception{
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			if(dao.alterar(responsavel))
				return true;
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao alterar o respons�vel");
		}
		return false;
	}
	
	public ArrayList<Responsavel> buscarTodos() throws Exception{
		ArrayList<Responsavel> lista = new ArrayList<Responsavel>();
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			lista = dao.buscarTodos();
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao buscar os respons�veis cadastrados");
		}
		
		return lista;
	}
	
	public Responsavel buscarPorId(int idResponsavel) throws Exception{
		Responsavel responsavel = new Responsavel();
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			responsavel = dao.buscarPorId(idResponsavel);
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao buscar o respons�vel selecionado");
		}	
		return responsavel;
	}
	
	public boolean desativar(int idResponsavel) throws Exception{
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			if(dao.desativar(idResponsavel))
				return true;
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao desativar o respons�vel selecionado");
		}
		
		return false;
	}
	
	public List<Responsavel> buscarRespNaoVinculado(int idAtleta) throws Exception{
		List<Responsavel> lista = new ArrayList<Responsavel>();
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			lista = dao.buscarRespNaoVinculado(idAtleta);
		}catch(Exception ex){
			throw new Exception("Erro! Ocorreu algum erro ao buscar os respons�veis");
		}
		
		return lista;
	}


	public boolean enviarEmailResponsaveis(int envio, String assunto,
			String mensagem) throws Exception {
		try{
			ResponsavelDAO dao = new ResponsavelDAO();
			List<String> emails = dao.buscarEmailResponsaveis(envio);
			
			if(emails.isEmpty()){
				throw new Exception("Mensagem n�o enviada. N�o foram encontrados respons�veis para a equipe selecionada!");
			}else{
				for (String string : emails) {
					enviarEmail(string, assunto, mensagem);
				}
			}
			return true;
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}


	private void enviarEmail(String destinatario, String assunto, String mensagem) throws Exception {
		JavaMailApp email = new JavaMailApp();
		try {
			email.enviarEmailResponsavel(destinatario, assunto,
					mensagem);
		} catch (AddressException e) {
			throw new Exception("Erro ao identificar email de respons�vel!");
		} catch (MessagingException e) {
			throw new Exception("Erro ao enviar email ao respons�vel!");
		}
	}
}
