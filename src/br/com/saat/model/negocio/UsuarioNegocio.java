package br.com.saat.model.negocio;

import br.com.saat.model.Perfis;
import br.com.saat.model.Usuario;
import br.com.saat.model.dao.UsuarioDAO;
import br.com.saat.core.*;

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
			ex.printStackTrace();
			return null;
		}
	}
	
	public String retornoLogin(int perfil){
		if(perfil == Perfis.Secretaria.getValor())
			return String.format("%s/SecretariaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Fisioterapeuta.getValor())
			return String.format("%s/FisioterapiaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Psicologa.getValor())
			return String.format("%s/PsicologiaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Nutricionista.getValor())
			return String.format("%s/NutricionistaPrincipal.jsp", Constants.VIEW);
		else if(perfil == Perfis.Tecnico.getValor())
			return String.format("%s/TecnicoAtleta.jsp", Constants.VIEW);
		else if(perfil == Perfis.PreparadorFisico.getValor())
			return String.format("%s/TecnicoAtleta.jsp", Constants.VIEW);
//      Isso não funciona, pois não vai acessar a Servlet via requestDispatcher;
//		Pensar em outro Else -> JU
//		else
			return "Autenticador?action=logout";
	}
}
