package br.com.saat.model;

public class Pessoa {
	public int idPessoa;
	public String nome;
	public String email;
	public String telefone;
	public String celular;
	
	public Pessoa(){}
	
	public Pessoa(int idPessoa, String nome, String email, String telefone, String celular) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
