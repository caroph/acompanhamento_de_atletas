package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

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

	public int inserir(AvaliacaoAntropometrica avaliacaoAntropometrica, int idFichaDeAtendimento) throws Exception {
		stmtScript = con.prepareStatement("INSERT INTO avaliacaoantropometrica ("
				+ "idFichaDeAtendimento, "
				+ "pesoUsual, "
				+ "porcentagemGorduraUsual, "
				+ "pesoIdeal, "
				+ "porcentagemGorduraIdeal, "
				+ "pesoAtual, "
				+ "porcentagemGorduraAtual, "
				+ "altura, "
				+ "ccd, "
				+ "cce, "
				+ "cbd, "
				+ "cbe, "
				+ "pregas, "
				+ "cintura, "
				+ "peitoral) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
				, Statement.RETURN_GENERATED_KEYS);
		
		stmtScript.setInt(1, idFichaDeAtendimento);
		stmtScript.setFloat(2, avaliacaoAntropometrica.getPesoUsual());
		stmtScript.setFloat(3, avaliacaoAntropometrica.getPorcentagemGorduraUsual());
		stmtScript.setFloat(4, avaliacaoAntropometrica.getPesoIdeal());
		stmtScript.setFloat(5, avaliacaoAntropometrica.getPorcentagemGorduraIdeal());
		stmtScript.setFloat(6, avaliacaoAntropometrica.getPesoAtual());
		stmtScript.setFloat(7, avaliacaoAntropometrica.getPorcentagemGorduraAtual());
		stmtScript.setFloat(8, avaliacaoAntropometrica.getAltura());
		stmtScript.setFloat(9, avaliacaoAntropometrica.getCcd());
		stmtScript.setFloat(10, avaliacaoAntropometrica.getCce());
		stmtScript.setFloat(11, avaliacaoAntropometrica.getCbd());
		stmtScript.setFloat(12, avaliacaoAntropometrica.getCbe());
		stmtScript.setFloat(13, avaliacaoAntropometrica.getPregas());
		stmtScript.setFloat(14, avaliacaoAntropometrica.getCintura());
		stmtScript.setFloat(15, avaliacaoAntropometrica.getPeitoral());
		
		if(stmtScript.executeUpdate() > 0){
			ResultSet rs = stmtScript.getGeneratedKeys();
			if(rs.next()){
				return rs.getInt(1);
			}else
				return 0;
		}else		
			return 0;
	}

	public boolean alterar(AvaliacaoAntropometrica avaliacaoAntropometrica, int idFichaDeAtendimento) throws Exception{
		stmtScript = con.prepareStatement("UPDATE avaliacaoantropometrica SET "
				+ "pesoUsual = ?, "
				+ "porcentagemGorduraUsual = ?, "
				+ "pesoIdeal = ?, "
				+ "porcentagemGorduraIdeal = ?, "
				+ "pesoAtual = ?, "
				+ "porcentagemGorduraAtual = ?, "
				+ "altura = ?, "
				+ "ccd = ?, "
				+ "cce = ?, "
				+ "cbd = ?, "
				+ "cbe = ?, "
				+ "pregas = ?, "
				+ "cintura = ?, "
				+ "peitoral = ? WHERE idFichaDeAtendimento = ?");
		
		stmtScript.setFloat(1, avaliacaoAntropometrica.getPesoUsual());
		stmtScript.setFloat(2, avaliacaoAntropometrica.getPorcentagemGorduraUsual());
		stmtScript.setFloat(3, avaliacaoAntropometrica.getPesoIdeal());
		stmtScript.setFloat(4, avaliacaoAntropometrica.getPorcentagemGorduraIdeal());
		stmtScript.setFloat(5, avaliacaoAntropometrica.getPesoAtual());
		stmtScript.setFloat(6, avaliacaoAntropometrica.getPorcentagemGorduraAtual());
		stmtScript.setFloat(7, avaliacaoAntropometrica.getAltura());
		stmtScript.setFloat(8, avaliacaoAntropometrica.getCcd());
		stmtScript.setFloat(9, avaliacaoAntropometrica.getCce());
		stmtScript.setFloat(10, avaliacaoAntropometrica.getCbd());
		stmtScript.setFloat(11, avaliacaoAntropometrica.getCbe());
		stmtScript.setFloat(12, avaliacaoAntropometrica.getPregas());
		stmtScript.setFloat(13, avaliacaoAntropometrica.getCintura());
		stmtScript.setFloat(14, avaliacaoAntropometrica.getPeitoral());
		stmtScript.setInt(15, idFichaDeAtendimento);
		
		if(stmtScript.executeUpdate() > 0)
			return true;
		else
			return false;
	}

}
