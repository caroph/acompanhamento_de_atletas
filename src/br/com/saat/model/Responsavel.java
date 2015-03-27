package br.com.saat.model;

import java.util.ArrayList;

public class Responsavel extends Pessoa {
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Responsavel(){}
	
	public Responsavel(int idPessoa, String nome, String email, String celular, ArrayList<Endereco> enderecos){
		super.setIdPessoa(idPessoa);
		super.setNome(nome);
		super.setEmail(email);
		super.setCelular(celular);
		this.enderecos = enderecos;
	}

	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
