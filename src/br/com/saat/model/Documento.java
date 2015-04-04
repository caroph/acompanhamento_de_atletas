package br.com.saat.model;

import java.util.Date;

public class Documento {
	private int idPessoa;
	private int idDocumento;
	private int tpDocumento;
	private String src;
	private Date validade;
	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public int getTpDocumento() {
		return tpDocumento;
	}
	public void setTpDocumento(int tpDocumento) {
		this.tpDocumento = tpDocumento;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}	
	
}
