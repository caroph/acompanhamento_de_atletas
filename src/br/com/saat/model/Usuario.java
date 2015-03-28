package br.com.saat.model;

public class Usuario extends Pessoa{
	public String senha;
	public int perfil;
	public String CREF;
	public String telefone;
	
	public Usuario(){}
	
	public Usuario(int idPessoa, String nome, String email, int perfil) {
		super(idPessoa, nome, email);
		this.perfil = perfil;
	}

	public Usuario(int idPessoa, String nome, String email, String celular, 
			String senha, int perfil, String cref, String telefone) {
		super(idPessoa, nome, email, celular);
		this.senha = senha;
		this.perfil = perfil;
		this.CREF = cref;
		this.telefone = telefone;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	
	public String getNomePerfil(){
		String retorno = "";
		switch(this.perfil){
			case 1:
				retorno = Perfis.Secretaria.getNome();
				break;
			case 2:
				retorno = Perfis.Nutricionista.getNome();
				break;
			case 3:
				retorno = Perfis.Psicologa.getNome();
				break;
			case 4:
				retorno = Perfis.Fisioterapeuta.getNome();
				break;
			case 5:
				retorno = Perfis.Tecnico.getNome();
				break;
			case 6:
				retorno = Perfis.PreparadorFisico.getNome();
				break;
		}
		return retorno;
	}
}
