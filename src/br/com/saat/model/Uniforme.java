package br.com.saat.model;

import br.com.saat.enumeradores.GrauParentesco;
import br.com.saat.enumeradores.TpTamanhoUniforme;
import br.com.saat.enumeradores.TpUniforme;

public class Uniforme {
	public int idUniforme;
	public int tpUniforme;
	public int tamanhoUniforme;
	public int quantidadeUniforme;
	
	public Uniforme(){}
	
	public Uniforme(int tpUniforme, int tamanhoUniforme, int quantidadeUniforme) {
		this.tpUniforme = tpUniforme;
		this.tamanhoUniforme = tamanhoUniforme;
		this.quantidadeUniforme = quantidadeUniforme;
	}



	public int getIdUniforme() {
		return idUniforme;
	}

	public void setIdUniforme(int idUniforme) {
		this.idUniforme = idUniforme;
	}

	public int getTpUniforme() {
		return tpUniforme;
	}

	public void setTpUniforme(int tpUniforme) {
		this.tpUniforme = tpUniforme;
	}

	public int getTamanhoUniforme() {
		return tamanhoUniforme;
	}

	public void setTamanhoUniforme(int tamanhoUniforme) {
		this.tamanhoUniforme = tamanhoUniforme;
	}

	public int getQuantidadeUniforme() {
		return quantidadeUniforme;
	}

	public void setQuantidadeUniforme(int quantidadeUniforme) {
		this.quantidadeUniforme = quantidadeUniforme;
	}	
	
	public String getNomeTpUniforme(){
		String retorno = "";
		switch (this.tpUniforme) {
		case 1:
			retorno = TpUniforme.Blusinha.getNome();
			break;
		case 2:
			retorno = TpUniforme.Camiseta.getNome();
			break;
		case 3:
			retorno = TpUniforme.Saia.getNome();
			break;
		case 4:
			retorno = TpUniforme.Bermuda.getNome();
			break;
		case 5:
			retorno = TpUniforme.Jaqueta.getNome();
			break;
		case 6:
			retorno = TpUniforme.Calca.getNome();
			break;
		}
		return retorno;
	}
	
	public String getNomeTamanhoUniforme(){
		String retorno = "";
		switch (this.tamanhoUniforme) {
		case 1:
			retorno = TpTamanhoUniforme.N10.getNome();
			break;
		case 2:
			retorno = TpTamanhoUniforme.N12.getNome();
			break;
		case 3:
			retorno = TpTamanhoUniforme.N14.getNome();
			break;
		case 4:
			retorno = TpTamanhoUniforme.N16.getNome();
			break;
		case 5:
			retorno = TpTamanhoUniforme.PP.getNome();
			break;
		case 6:
			retorno = TpTamanhoUniforme.P.getNome();
			break;
		case 7:
			retorno = TpTamanhoUniforme.M.getNome();
			break;
		case 8:
			retorno = TpTamanhoUniforme.G.getNome();
			break;
		case 9:
			retorno = TpTamanhoUniforme.GG.getNome();
			break;
		}
		return retorno;
	}
}
