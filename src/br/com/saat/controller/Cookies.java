package br.com.saat.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies {

	public static Cookie addCookie(String name, String value, int maxAge) {
	    Cookie cookie = new Cookie(name, value);
	    cookie.setPath("/");
	    cookie.setMaxAge(maxAge);
	    return cookie;
	}
	
	public static void removeCookie(HttpServletResponse response, String name) {
		Cookie ck = addCookie(name, null, 0);
		response.addCookie(ck);
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
