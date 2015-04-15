package br.com.saat.model;

import java.util.ArrayList;

import br.com.saat.enumeradores.GrauParentesco;

public class Responsavel extends Pessoa {
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	public int idGrauParentesco;
	
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
	
	public int getIdGrauParentesco() {
		return idGrauParentesco;
	}

	public void setIdGrauParentesco(int idGrauParentesco) {
		this.idGrauParentesco = idGrauParentesco;
	}

	public String getNomeGrauParentesco(){
		String retorno = "";
		switch (this.idGrauParentesco) {
		case 1:
			retorno = GrauParentesco.Mae.getNome();
			break;
		case 2:
			retorno = GrauParentesco.Pai.getNome();
			break;
		case 3:
			retorno = GrauParentesco.Tio.getNome();
			break;
		case 4:
			retorno = GrauParentesco.Irmao.getNome();
			break;
		case 5:
			retorno = GrauParentesco.Avo.getNome();
			break;
		case 6:
			retorno = GrauParentesco.Outros.getNome();
			break;
		}
		return retorno;
	}
	
}
