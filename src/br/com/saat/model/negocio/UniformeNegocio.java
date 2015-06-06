package br.com.saat.model.negocio;

import java.sql.SQLException;
import java.util.List;

import br.com.saat.model.Uniforme;
import br.com.saat.model.dao.UniformeDAO;

public class UniformeNegocio {
	public UniformeNegocio(){}

	public boolean salvarUniformes(List<Uniforme> uniformes, String optEstoque) throws Exception {
		try{
			UniformeDAO dao = new UniformeDAO();
			for (Uniforme uniforme : uniformes) {
				dao.salvarUniforme(uniforme, optEstoque);
			}
			return true;
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
	
	
}
