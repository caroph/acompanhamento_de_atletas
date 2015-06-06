package br.com.saat.model;

public class ItemRetirada {
	public int idItemRetirada;
	public RetiradaUniforme retirada;
	public Uniforme uniforme;
	public int quantidade;
	
	public ItemRetirada(){}

	public int getIdItemRetirada() {
		return idItemRetirada;
	}

	public void setIdItemRetirada(int idItemRetirada) {
		this.idItemRetirada = idItemRetirada;
	}

	public RetiradaUniforme getRetirada() {
		return retirada;
	}

	public void setRetirada(RetiradaUniforme retirada) {
		this.retirada = retirada;
	}

	public Uniforme getUniforme() {
		return uniforme;
	}

	public void setUniforme(Uniforme uniforme) {
		this.uniforme = uniforme;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
}
