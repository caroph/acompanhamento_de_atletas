package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;

public class AtletaDAO {
	private Connection con;
	private PreparedStatement stmtScript;
	
	public AtletaDAO() throws Exception{
        con = ConnectionFactory.getConnection();
    }
	
	public AtletaDAO(Connection con) throws Exception{
        this.con = con;        
    }

	public int inserir(Atleta atleta) throws SQLException {
		int idAtleta = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO atleta (idTpEquipe, nome, email, celular, "
				+ "nrMatricula, nrCadFPT, nrCadCBT, dtNascimento, RG, CPF, escola, serie, turno, "
				+ "acompPsicologico, nmMedicoResponsavel, convenio, medicacaoAutorizada, flAlergias, "
				+ "dsAlergias, flMedicacao, dsMedicacao, nmContatoEmergencia, telContatoEmergencia,"
				+ "grauParentescoContatoEmergencia, dtValidade) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		stmtScript.setInt(1, 1);
		stmtScript.setString(2, atleta.getNome());
		stmtScript.setString(3, atleta.getEmail());
		stmtScript.setString(4, atleta.getCelular());
		stmtScript.setString(5, atleta.getNrMatricula());
		stmtScript.setString(6, atleta.getNrCadFPT());
		stmtScript.setString(7, atleta.getNrCadFPT());
		stmtScript.setDate(8, new java.sql.Date(atleta.getDtNascimento().getTime()));
		stmtScript.setString(9, atleta.getRG());
		stmtScript.setString(10, atleta.getCPF());
		stmtScript.setString(11, atleta.getEscola());
		stmtScript.setString(12, atleta.getSerie());
		stmtScript.setString(13, atleta.getTurno());
		stmtScript.setBoolean(14, atleta.isAcompPsicologico());
		stmtScript.setString(15, atleta.getNmMedicoResponsavel());
		stmtScript.setString(16, atleta.getConvenio());
		stmtScript.setString(17, atleta.getMedicacaoAutorizada());
		stmtScript.setBoolean(18, atleta.isFlAlergias());
		stmtScript.setString(19, atleta.getDsAlergias());
		stmtScript.setBoolean(20, atleta.isFlMedicacao());
		stmtScript.setString(21, atleta.getDsMedicacao());
		stmtScript.setString(22, atleta.getNmContatoEmergencia());
		stmtScript.setString(23, atleta.getTelContatoEmergencia());
		stmtScript.setString(24, atleta.getGrauParentescoContatoEmergencia());
		stmtScript.setDate(25, new java.sql.Date(atleta.getDtValidade().getTime()));
		
		stmtScript.executeUpdate();
		ResultSet rs = stmtScript.getGeneratedKeys();
		
		if(rs.next()){
			idAtleta = rs.getInt(1);
		}
		return idAtleta;
	}
	
}
