package br.com.saat.model.negocio;

import javax.servlet.http.Cookie;

public class CookieNegocio {

	public static Cookie addCookie(String name, String value, int maxAge) {
	    Cookie cookie = new Cookie(name, value);
	    cookie.setPath("/tcc-saat/");
	    cookie.setMaxAge(maxAge);
	    return cookie;
	}
	
	public static Cookie removeCookie(String name) {
		Cookie novoCookie = addCookie(name, null, 0);
		return novoCookie;
	}
	
	public static String getCookieValue(Cookie[] cookies, String name) {
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (name.equals(cookie.getName())) {
	                return cookie.getValue();
	            }
	        }
	    }
	    return null;
	}
}
