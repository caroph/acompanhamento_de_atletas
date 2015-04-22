package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.Endereco;
import br.com.saat.model.Responsavel;

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
				+ "nrMatricula, nrCadFPT, nrCadCBT, dtNascimento, RG, CPF, escola, serie, idTurno, "
				+ "acompPsicologico, nmMedicoResponsavel, telMedicoResponsavel, convenio, medicacaoAutorizada, "
				+ "flAlergias, dsAlergias, flMedicacao, dsMedicacao, nmContatoEmergencia, telContatoEmergencia, "
				+ "idGrauParentesco, dtValidade) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

		stmtScript.setInt(1, atleta.getIdTpEquipe());
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
		stmtScript.setInt(13, atleta.getIdTurno());
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
		stmtScript.setInt(25, atleta.getIdGrauParentesco());
		stmtScript.setDate(26, new java.sql.Date(atleta.getDtValidade().getTime()));
		
		stmtScript.executeUpdate();
		ResultSet rs = stmtScript.getGeneratedKeys();
		
		if(rs.next()){
			idAtleta = rs.getInt(1);
		}
		return idAtleta;
	}

	public List<Atleta> buscarAtletas(int ativo) throws SQLException {
		List<Atleta> lista = new ArrayList<Atleta>();
		
		if(ativo < 2){
			stmtScript = con.prepareStatement("SELECT a.idAtleta, idTpEquipe, nome, email, celular, "
					+ "nrMatricula, nrCadFPT, nrCadCBT, dtNascimento, RG, CPF, escola, serie, idTurno, "
					+ "acompPsicologico, nmMedicoResponsavel, telMedicoResponsavel, convenio, "
					+ "medicacaoAutorizada, flAlergias, dsAlergias, flMedicacao, dsMedicacao, "
					+ "nmContatoEmergencia, telContatoEmergencia, idGrauParentesco, "
					+ "dtValidade, e.idEndereco, endereco, numero, complemento,"
					+ "bairro, estado, cidade, telefone, flCadastroAtivo "
					+ "FROM atleta a "
					+ "INNER JOIN endereco e "
					+ "ON a.idAtleta = e.idEndereco "
					+ "WHERE flCadastroAtivo = " + String.valueOf(ativo)
					+ " ORDER BY nome ");
		}else{
			stmtScript = con.prepareStatement("SELECT a.idAtleta, idTpEquipe, nome, email, celular, "
					+ "nrMatricula, nrCadFPT, nrCadCBT, dtNascimento, RG, CPF, escola, serie, idTurno, "
					+ "acompPsicologico, nmMedicoResponsavel, telMedicoResponsavel, convenio, "
					+ "medicacaoAutorizada, flAlergias, dsAlergias, flMedicacao, dsMedicacao, "
					+ "nmContatoEmergencia, telContatoEmergencia, idGrauParentesco, "
					+ "dtValidade, e.idEndereco, endereco, numero, complemento,"
					+ "bairro, estado, cidade, telefone, flCadastroAtivo "
					+ "FROM atleta a "
					+ "LEFT JOIN endereco e "
					+ "ON a.idAtleta = e.idEndereco "
					+ " ORDER BY nome ");
		}
		
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
			atleta.setIdTurno(rs.getInt(14));
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
			atleta.setIdGrauParentesco(rs.getInt(26));
			atleta.setDtValidade(rs.getDate(27));
			atleta.setFlCadastroAtivo(rs.getInt(36));
			atleta.setEndereco(endereco);
			
			endereco.setIdEndereco(rs.getInt(28));
			endereco.setEndereco(rs.getString(29));
			endereco.setNumero(rs.getInt(30));
			endereco.setComplemento(rs.getString(31));
			endereco.setBairro(rs.getString(32));
			endereco.setEstado(rs.getString(33));
			endereco.setCidade(rs.getString(34));
			endereco.setTelefone(rs.getString(35));
			
			lista.add(atleta);
		}

		return lista;
	}

	public Atleta buscarAtleta(int idAtleta) throws SQLException {
		stmtScript = con.prepareStatement("SELECT a.idAtleta, idTpEquipe, nome, email, celular, "
				+ "nrMatricula, nrCadFPT, nrCadCBT, dtNascimento, RG, CPF, escola, serie, idTurno, "
				+ "acompPsicologico, nmMedicoResponsavel, telMedicoResponsavel, convenio, "
				+ "medicacaoAutorizada, flAlergias, dsAlergias, flMedicacao, dsMedicacao, "
				+ "nmContatoEmergencia, telContatoEmergencia, idGrauParentesco, "
				+ "dtValidade, e.idEndereco, endereco, numero, complemento,"
				+ "bairro, estado, cidade, telefone "
				+ "FROM atleta a "
				+ "LEFT JOIN endereco e "
				+ "ON a.idAtleta = e.idEndereco "
				+ "WHERE a.idAtleta = ?");
		
		stmtScript.setInt(1, idAtleta);

		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
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
			atleta.setIdTurno(rs.getInt(14));
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
			atleta.setIdGrauParentesco(rs.getInt(26));
			atleta.setDtValidade(rs.getDate(27));
			atleta.setEndereco(endereco);
			
			endereco.setIdEndereco(rs.getInt(28));
			endereco.setEndereco(rs.getString(29));
			endereco.setNumero(rs.getInt(30));
			endereco.setComplemento(rs.getString(31));
			endereco.setBairro(rs.getString(32));
			endereco.setEstado(rs.getString(33));
			endereco.setCidade(rs.getString(34));
			endereco.setTelefone(rs.getString(35));
			
			return atleta;
		}
		
		return null;
	}

	public boolean alterar(Atleta atleta) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE atleta "
				+ "SET idTpEquipe = ?, nome = ?, email = ?, celular = ?, nrMatricula = ?, nrCadFPT = ?, "
				+ "nrCadCBT = ?, dtNascimento = ?, RG = ?, CPF = ?, escola = ?, serie = ?, idTurno = ?, "
				+ "acompPsicologico = ?, nmMedicoResponsavel = ?, telMedicoResponsavel = ?, convenio = ?, "
				+ "medicacaoAutorizada = ?, flAlergias = ?, dsAlergias = ?, flMedicacao = ?, dsMedicacao = ?, "
				+ "nmContatoEmergencia = ?, telContatoEmergencia = ?, idGrauParentesco = ?, dtValidade = ? "
				+ "WHERE idAtleta = ? ");

		stmtScript.setInt(1, atleta.getIdTpEquipe());
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
		stmtScript.setInt(13, atleta.getIdTurno());
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
		stmtScript.setInt(25, atleta.getIdGrauParentesco());
		stmtScript.setDate(26, new java.sql.Date(atleta.getDtValidade().getTime()));
		stmtScript.setInt(27, atleta.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}
	
	public List<Integer> buscaDiasTreinoAtleta(int idAtleta) throws SQLException{
		List<Integer> lista = new ArrayList<Integer>();
		
		stmtScript = con.prepareStatement(
				"SELECT d.idDiaTreino FROM atleta a "
				+ "JOIN diatreinoatleta da on a.idAtleta = da.idAtleta "
				+ "JOIN diatreino d on da.idDiaTreino = d.idDiaTreino "
				+ "WHERE a.idAtleta = ?");
		
		stmtScript.setInt(1, idAtleta);
        ResultSet rs = stmtScript.executeQuery();
        
        while(rs.next()){
        	lista.add(rs.getInt(1));
        }
		
		return lista;
	}

	public boolean desativar(Atleta atleta) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE atleta SET flCadastroAtivo = 0 WHERE idAtleta = ?");
		stmtScript.setInt(1, atleta.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}

	public boolean ativar(Atleta atleta) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE atleta SET flCadastroAtivo = 1 WHERE idAtleta = ?");
		stmtScript.setInt(1, atleta.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}

	public boolean vincularResponsavel(int idAtleta, int idResponsavel,
			int idGrauParentesco) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO atletaresponsavel (idAtleta, idResponsavel, "
				+ "idGrauParentesco) VALUES (?,?,?)");
		stmtScript.setInt(1, idAtleta);
		stmtScript.setInt(2, idResponsavel);
		stmtScript.setInt(3, idGrauParentesco);
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}

	public Atleta buscarAtletaDetalhes(int idAtleta) throws SQLException {
		Atleta atleta = new Atleta();
		
		stmtScript = con.prepareStatement("SELECT nome, idTpEquipe, nrMatricula, nrCadCBT, nrCadFPT, "
				+ "nmContatoEmergencia, telContatoEmergencia, idGrauParentesco, dtNascimento FROM atleta WHERE idAtleta = ?");
		stmtScript.setInt(1, idAtleta);
		
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			atleta.setIdPessoa(idAtleta);
			atleta.setNome(rs.getString(1));
			atleta.setIdTpEquipe(rs.getInt(2));
			atleta.setNrMatricula(rs.getString(3));
			atleta.setNrCadCBT(rs.getString(4));
			atleta.setNrCadFPT(rs.getString(5));
			atleta.setNmContatoEmergencia(rs.getString(6));
			atleta.setTelContatoEmergencia(rs.getString(7));
			atleta.setIdGrauParentesco(rs.getInt(8));
			atleta.setDtNascimento(rs.getDate(9));
			
			stmtScript = con.prepareStatement("SELECT dt.idDiaSemana, dt.hrInicio, dt.hrFim "
					+ "FROM diatreinoatleta dta JOIN diatreino dt on dt.idDiaTreino = dta.idDiaTreino "
					+ "WHERE dta.idAtleta = ?");
			stmtScript.setInt(1, idAtleta);
			ResultSet rsDiaTreino = stmtScript.executeQuery();
			
			List<DiaTreino> listaDiasTreino = new ArrayList<DiaTreino>();
			while(rsDiaTreino.next()){
				DiaTreino dt = new DiaTreino();
				dt.setIdDiaDaSemana(rsDiaTreino.getInt(1));
				dt.setHrInicio(rsDiaTreino.getTime(2));
				dt.setHrFim(rsDiaTreino.getTime(3));
				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
				dt.setHrFimDisplay(dateFormat.format(dt.getHrFim()));
				dt.setHrInicioDisplay(dateFormat.format(dt.getHrInicio()));
				listaDiasTreino.add(dt);
			}
			atleta.setListaDiasTreinos(listaDiasTreino);
			
			stmtScript = con.prepareStatement("SELECT r.nome, r.celular, ar.idGrauParentesco FROM responsavel r "
					+ "JOIN atletaresponsavel ar on ar.idResponsavel = r.idResponsavel WHERE ar.idAtleta = ?");
			stmtScript.setInt(1, idAtleta);
			ResultSet rsResponsavel = stmtScript.executeQuery();
			
			List<Responsavel> listaResponsaveis = new ArrayList<Responsavel>();
			while(rsResponsavel.next()){
				Responsavel resp = new Responsavel();
				resp.setNome(rsResponsavel.getString(1));
				resp.setCelular(rsResponsavel.getString(2));
				resp.setIdGrauParentesco(rsResponsavel.getInt(3));
				listaResponsaveis.add(resp);
			}
			atleta.setListaResponsaveis(listaResponsaveis);
		}
				
		return atleta;
	}

	public String buscarNome(int idPessoa) throws Exception{
		stmtScript = con.prepareStatement("SELECT nome FROM atleta WHERE idAtleta = ?");
		stmtScript.setInt(1, idPessoa);
		ResultSet rs = stmtScript.executeQuery();
		
		if(rs.next()){
			return rs.getString("nome");
		}else
			return "";
	}

	public String verificarCodigos(int idPessoa, String nrMatricula,
			String nrCadCBT, String nrCadFPT) throws SQLException {
		if(idPessoa == 0){
			stmtScript = con.prepareStatement("SELECT nrMatricula FROM atleta "
					+ "WHERE nrMatricula = ?");
			stmtScript.setString(1, nrMatricula);
			
			ResultSet rsNrMatricula = stmtScript.executeQuery();
			if(rsNrMatricula.next())
				return "Já existe um atleta com o mesmo numero de matrícula registrado no sistema!";			
			
			stmtScript = con.prepareStatement("SELECT nrCadCBT FROM atleta "
					+ "WHERE nrCadCBT = ?");			
			stmtScript.setString(1, nrCadCBT);	
			
			ResultSet rsCBT = stmtScript.executeQuery();
			if(rsCBT.next())
				return "Já existe um atleta com o mesmo numero de cadastro CBT registrado no sistema!";
			
			stmtScript = con.prepareStatement("SELECT nrCadFPT FROM atleta "
					+ "WHERE nrCadFPT = ?");
			stmtScript.setString(1, nrCadFPT);
			
			ResultSet rsFPT = stmtScript.executeQuery();
			if(rsFPT.next())
				return "Já existe um atleta com o mesmo numero de cadastro FPT registrado no sistema!";
		}
		else{
			stmtScript = con.prepareStatement("SELECT nrMatricula FROM atleta "
					+ "WHERE nrMatricula = ? AND idAtleta != ?");
			stmtScript.setString(1, nrMatricula);
			stmtScript.setInt(2, idPessoa);
			
			ResultSet rsNrMatricula = stmtScript.executeQuery();
			if(rsNrMatricula.next())
				return "Já existe um atleta com o mesmo numero de matrícula registrado no sistema!";			
			
			stmtScript = con.prepareStatement("SELECT nrCadCBT FROM atleta "
					+ "WHERE nrCadCBT = ? AND idAtleta != ?");			
			stmtScript.setString(1, nrCadCBT);	
			stmtScript.setInt(2, idPessoa);
			
			ResultSet rsCBT = stmtScript.executeQuery();
			if(rsCBT.next())
				return "Já existe um atleta com o mesmo numero de cadastro CBT registrado no sistema!";
			
			stmtScript = con.prepareStatement("SELECT nrCadFPT FROM atleta "
					+ "WHERE nrCadFPT = ? AND idAtleta != ?");
			stmtScript.setString(1, nrCadFPT);
			stmtScript.setInt(2, idPessoa);
			
			ResultSet rsFPT = stmtScript.executeQuery();
			if(rsFPT.next())
				return "Já existe um atleta com o mesmo numero de cadastro FPT registrado no sistema!";
		}	
		return "";
	}
	
}
