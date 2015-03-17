package br.com.saat.core;

public class Constants {
	public static final String THEME = "default";
	public static final String PATH = String.format("themes/%s/assets", THEME);
	public static final String CSS = String.format("%s/css", PATH);
	public static final String PLUGINS = String.format("%s/plugins", PATH);
	public static final String FONT = String.format("%s/fonts", PATH);
	public static final String JS = String.format("%s/js", PATH);
	public static final String VIEW = String.format("/WEB-INF/view");
	public static final String IMG = String.format("%s/img", PATH);
	public static final String COOKIE_NAME = "usuarioLogado";
	public static final int COOKIE_AGE = (60*60*24*365);
	
}
