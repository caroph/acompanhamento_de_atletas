package br.com.saat.model;

public class Pessoa {
	public int idPessoa;
	public String nome;
	public String email;
	public String celular;
	
	public Pessoa(){}
	
	public Pessoa(int idPessoa, String nome) {
		this.idPessoa = idPessoa;
		this.nome = nome;
	}
	
	public Pessoa(int idPessoa, String nome, String email, String celular) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.email = email;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
