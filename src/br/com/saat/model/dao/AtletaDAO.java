package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.Endereco;

import com.mysql.jdbc.Statement;

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
				+ "acompPsicologico, nmMedicoResponsavel, telMedicoResponsavel, convenio, medicacaoAutorizada, "
				+ "flAlergias, dsAlergias, flMedicacao, dsMedicacao, nmContatoEmergencia, telContatoEmergencia,"
				+ "grauParentescoContatoEmergencia, dtValidade) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

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
		stmtScript.setString(16, atleta.getTelMedicoResponsavel());
		stmtScript.setString(17, atleta.getConvenio());
		stmtScript.setString(18, atleta.getMedicacaoAutorizada());
		stmtScript.setBoolean(19, atleta.isFlAlergias());
		stmtScript.setString(20, atleta.getDsAlergias());
		stmtScript.setBoolean(21, atleta.isFlMedicacao());
		stmtScript.setString(22, atleta.getDsMedicacao());
		stmtScript.setString(23, atleta.getNmContatoEmergencia());
		stmtScript.setString(24, atleta.getTelContatoEmergencia());
		stmtScript.setString(25, atleta.getGrauParentescoContatoEmergencia());
		stmtScript.setDate(26, new java.sql.Date(atleta.getDtValidade().getTime()));
		
		stmtScript.executeUpdate();
		ResultSet rs = stmtScript.getGeneratedKeys();
		
		if(rs.next()){
			idAtleta = rs.getInt(1);
		}
		return idAtleta;
	}

	public List<Atleta> buscarAtletas() throws SQLException {
		List<Atleta> lista = new ArrayList<Atleta>();
		
		stmtScript = con.prepareStatement("SELECT a.idAtleta, idTpEquipe, nome, email, celular, "
				+ "nrMatricula, nrCadFPT, nrCadCBT, dtNascimento, RG, CPF, escola, serie, turno, "
				+ "acompPsicologico, nmMedicoResponsavel, telMedicoResponsavel, convenio, "
				+ "medicacaoAutorizada, flAlergias, dsAlergias, flMedicacao, dsMedicacao, "
				+ "nmContatoEmergencia, telContatoEmergencia, grauParentescoContatoEmergencia, "
				+ "dtValidade, endereco, numero, complemento,"
				+ "bairro, estado, cidade, telefone "
				+ "FROM atleta a "
				+ "INNER JOIN endereco e "
				+ "ON a.idAtleta = e.idEndereco "
				+ "WHERE flCadastroAtivo = 1 ");
		
		ResultSet rs = stmtScript.executeQuery();
		
		while(rs.next()){
			Atleta atleta = new Atleta();
			Endereco endereco = new Endereco();
			
			atleta.setIdPessoa(rs.getInt(1));
			atleta.setIdTpEquipe(rs.getInt(2));
			atleta.setNome(rs.getString(3));
			atleta.setEmail(rs.getString(4));
			atleta.setCelular(rs.getString(5));
			atleta.setNrMatricula(rs.getString(6));
			atleta.setNrCadCBT(rs.getString(7));
			atleta.setNrCadFPT(rs.getString(8));
			atleta.setDtNascimento(rs.getDate(9));
			atleta.setRG(rs.getString(10));
			atleta.setCPF(rs.getString(11));
			atleta.setEscola(rs.getString(12));
			atleta.setSerie(rs.getString(13));
			atleta.setTurno(rs.getString(14));
			atleta.setAcompPsicologico(rs.getBoolean(15));
			atleta.setNmMedicoResponsavel(rs.getString(16));
			atleta.setTelMedicoResponsal(rs.getString(17));
			atleta.setConvenio(rs.getString(18));
			atleta.setMedicacaoAutorizada(rs.getString(19));
			atleta.setFlAlergias(rs.getBoolean(20));
			atleta.setDsAlergias(rs.getString(21));
			atleta.setFlMedicacao(rs.getBoolean(22));
			atleta.setDsMedicacao(rs.getString(23));
			atleta.setNmContatoEmergencia(rs.getString(24));
			atleta.setTelContatoEmergencia(rs.getString(25));
			atleta.setGrauParentescoContatoEmergencia(rs.getString(26));
			atleta.setDtValidade(rs.getDate(27));
			atleta.setEndereco(endereco);
			
			endereco.setEndereco(rs.getString(28));
			endereco.setNumero(rs.getInt(29));
			endereco.setComplemento(rs.getString(30));
			endereco.setBairro(rs.getString(31));
			endereco.setEstado(rs.getString(32));
			endereco.setCidade(rs.getString(33));
			endereco.setTelefone(rs.getString(34));
			
			lista.add(atleta);
		}

		return lista;
	}
	
}
