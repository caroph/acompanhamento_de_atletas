package br.com.saat.model;

public class Usuario extends Pessoa{
	public String senha;
	public int perfil;
	public String CREF;
	
	public Usuario(){}

	public Usuario(int idPessoa, String nome, String email, String telefone, String celular, 
			String senha, int perfil, String cref) {
		super(idPessoa, nome, email, telefone, celular);
		this.senha = senha;
		this.perfil = perfil;
		CREF = cref;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public String getCREF() {
		return CREF;
	}

	public void setCREF(String cref) {
		CREF = cref;
	}
}
