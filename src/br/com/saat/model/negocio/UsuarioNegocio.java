package br.com.saat.model.negocio;

import br.com.saat.model.Perfis;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.UsuarioDAO;

public class UsuarioNegocio {
	UsuarioDAO dao;
	Usuario usuario;
	public UsuarioNegocio(){}
	
	public Usuario autenticar(String email, String senha){
		try{
			dao = new UsuarioDAO();
			usuario = new Usuario();
			
			usuario = dao.autenticar(email, senha);
			return usuario;
			
		}catch(Exception ex){
			return null;
		}
	}
	
	public String retornoLogin(int perfil){
		if(perfil == Perfis.Secretaria.getValor())
			return "view/SecretariaPrincipal.jsp";
		else if(perfil == Perfis.Fisioterapeuta.getValor())
			return "view/FisioterapiaPrincipal.jsp";
		else if(perfil == Perfis.Psicologa.getValor())
			return "view/PsicologiaPrincipal.jsp";
		else if(perfil == Perfis.Nutricionista.getValor())
			return "view/NutricionistaPrincipal.jsp";
		else if(perfil == Perfis.Tecnico.getValor())
			return "view/TecnicoAtleta.jsp";
		else if(perfil == Perfis.PreparadorFisico.getValor())
			return "view/TecnicoAtleta.jsp";
		else
			return "Autenticador?action=logout";
	}
}
