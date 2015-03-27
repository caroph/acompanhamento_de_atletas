package br.com.saat.model;

public class Endereco {
	private int idEndereco;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String estado;
	private String cidade;
	private String telefone;
	private int tpEndereco;
	
	public Endereco(){}
	
	public Endereco(String endereco, int numero, String complemento, String bairro, String estado, String cidade, int tpEndereco, String telefone){
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.tpEndereco = tpEndereco;
		this.telefone = telefone;		
	}
	
	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getTpEndereco() {
		return tpEndereco;
	}
	public void setTpEndereco(int tpEndereco) {
		this.tpEndereco = tpEndereco;
	}
	
	
	
}
