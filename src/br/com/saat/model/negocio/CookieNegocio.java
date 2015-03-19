package br.com.saat.model.negocio;

import javax.servlet.http.Cookie;

import br.com.saat.model.dao.CookieDAO;

public class CookieNegocio {
	static CookieDAO dao;

	public static Cookie addCookie(String name, String value, int maxAge, int idUsuario) {
		//Setar parâmetros do cookie
	    Cookie cookie = new Cookie(name, value);
	    cookie.setPath("/tcc-saat/");
	    cookie.setMaxAge(maxAge);
	    
	    //Se não for um cookie nulo, adicioná-lo ao banco de dados
	    if(maxAge > 0){
	    	try {
	    		dao = new CookieDAO();
	    		if(!dao.inserir(value, idUsuario)){
	    			cookie = null;
	    		}			
	    	} catch (Exception e) {
	    		// TODO Auto-generated catch block
	    		cookie = null;
	    	}
	    }
	    
	    return cookie;
	}
	
	public static int getCookieValue(Cookie[] cookies, String name) {
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (name.equals(cookie.getName())) {
	            	try {
						dao = new CookieDAO();
						return dao.buscar(cookie.getValue());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						return 0;
					}	            	
	            }
	        }
	    }
	    return 0;
	}
}
