package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.saat.model.AvaliacaoAntropometrica;
import br.com.saat.model.ConnectionFactory;

public class AvaliacaoAntropometricaDAO {

	private Connection con;
	private PreparedStatement stmtScript;
	
	public AvaliacaoAntropometricaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public AvaliacaoAntropometricaDAO(Connection con) throws Exception{
        this.con = con;        
    }
	
	public AvaliacaoAntropometrica buscarAvaliacao(int idFichaDeAtendimento) throws Exception {
		stmtScript = con.prepareStatement("SELECT * FROM avaliacaoantropometrica WHERE idFichaDeAtendimento = ?");
		stmtScript.setInt(1, idFichaDeAtendimento);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			AvaliacaoAntropometrica avaliacao = new AvaliacaoAntropometrica();
			avaliacao.setIdAvaliacaoAntropometrica(rs.getInt("idAvaliacaoAntropometrica"));
			avaliacao.setPesoUsual(rs.getFloat("pesoUsual"));
			avaliacao.setPorcentagemGorduraUsual(rs.getFloat("porcentagemGorduraUsual"));
			avaliacao.setPesoIdeal(rs.getFloat("pesoIdeal"));
			avaliacao.setPorcentagemGorduraIdeal(rs.getFloat("porcentagemGorduraIdeal"));
			avaliacao.setPesoAtual(rs.getFloat("pesoAtual"));
			avaliacao.setPorcentagemGorduraAtual(rs.getFloat("porcentagemGorduraAtual"));
			avaliacao.setAltura(rs.getFloat("altura"));
			avaliacao.setCcd(rs.getFloat("ccd"));
			avaliacao.setCce(rs.getFloat("cce"));
			avaliacao.setCbd(rs.getFloat("cbd"));
			avaliacao.setCbe(rs.getFloat("cbe"));
			avaliacao.setPregas(rs.getFloat("pregas"));
			avaliacao.setCintura(rs.getFloat("cintura"));
			avaliacao.setPeitoral(rs.getFloat("peitoral"));
			return avaliacao;
		}else 
			return null;
	}

}
