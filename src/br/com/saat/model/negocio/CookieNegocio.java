package br.com.saat.model.negocio;

import java.sql.SQLException;

import javax.servlet.http.Cookie;

import br.com.saat.model.dao.CookieDAO;

public class CookieNegocio {
	static CookieDAO dao;

	public static Cookie addCookie(String name, String value, int maxAge, int idUsuario) {
	    Cookie cookie = new Cookie(name, value);
	    cookie.setPath("/tcc-saat/");
	    cookie.setMaxAge(maxAge);
	    
	    //Se não for um cookie nulo, adiciona-o ao banco de dados
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
	
//	public static Cookie removeCookie(String name) {
//		Cookie novoCookie = addCookie(name, null, 0, 0);
//		return novoCookie;
//	}
	
	public static int getCookieValue(Cookie[] cookies, String name) {
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (name.equals(cookie.getName())) {
	                try {
						return dao.buscar(cookie.getValue());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						return 0;
					}
	            }
	        }
	    }
	    return 0;
	}
}
