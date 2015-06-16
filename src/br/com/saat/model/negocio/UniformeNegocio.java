package br.com.saat.model.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.saat.model.ItemRetirada;
import br.com.saat.model.OperacaoEstoqueUniforme;
import br.com.saat.model.RetiradaUniforme;
import br.com.saat.model.Uniforme;
import br.com.saat.model.dao.UniformeDAO;

public class UniformeNegocio {
	public UniformeNegocio(){}

	public int salvarUniformes(Uniforme uniforme, String optEstoque) throws Exception {
		try{
			UniformeDAO dao = new UniformeDAO();
			return dao.salvarUniforme(uniforme, optEstoque);
		}catch(SQLException ex){
			throw new Exception("Erro ao salvar o estoque!");
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	public List<Uniforme> buscarEstoque() throws Exception {
		try{
			UniformeDAO dao = new UniformeDAO();
			return dao.buscarEstoque();
		}catch(Exception ex){
			throw new Exception("Ocorreu algum erro ao buscar o estoque!");
		}
	}

	public boolean validaDadosRetirada(List<Uniforme> uniformes) throws Exception {
		try{
			UniformeDAO dao = new UniformeDAO();
			for (Uniforme uniforme : uniformes) {
				dao.buscarEstoquePorUniforme(uniforme);
			}
			return true;
		}catch(SQLException ex){
			throw new Exception("Erro ao validar quantidade no estoque!");
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	public int buscarIdUniforme(Uniforme uniforme) throws Exception {
		try{
			UniformeDAO dao = new UniformeDAO();
			return dao.buscarIdUniforme(uniforme);
		}catch(Exception ex){
			throw new Exception("Ocorreu algum erro ao identificar a retirada!");
		}
	}

	public int salvarRetiradaUniforme(RetiradaUniforme retirada) throws Exception {
		try{
			UniformeDAO dao = new UniformeDAO();
			int idRetiradaUniforme = dao.buscarRetirada(retirada);
			if(idRetiradaUniforme != 0)
				return idRetiradaUniforme;
			return dao.salvarRetiradaUniforme(retirada);
		}catch(Exception ex){
			throw new Exception("Ocorreu algum erro ao salvar a retirada!");
		}
	}

	public boolean salvarItemUniforme(ItemRetirada item) throws Exception {
		try{
			UniformeDAO dao = new UniformeDAO();
			return dao.salvarItemUniforme(item);
		}catch(Exception ex){
			throw new Exception("Ocorreu algum erro ao salvar a retirada!");
		}
	}

	public boolean salvarOperacaoEstoque(OperacaoEstoqueUniforme op) throws Exception{
		try{
			UniformeDAO dao = new UniformeDAO();
			return dao.salvarOperacaoEstoque(op);
		}catch(Exception ex){
			throw new Exception("Ocorreu algum erro ao salvar a operação do estoque!");
		}
	}
}
