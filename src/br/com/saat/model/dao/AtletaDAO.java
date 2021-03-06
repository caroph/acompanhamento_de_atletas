package br.com.saat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.saat.model.Atleta;
import br.com.saat.model.AvaliacaoDesempenho;
import br.com.saat.model.ConnectionFactory;
import br.com.saat.model.DiaTreino;
import br.com.saat.model.Documento;
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
				+ "idGrauParentesco, dtValidade, sexo) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

		stmtScript.setInt(1, atleta.getIdTpEquipe());
		stmtScript.setString(2, atleta.getNome());
		stmtScript.setString(3, atleta.getEmail());
		stmtScript.setString(4, atleta.getCelular());
		stmtScript.setString(5, atleta.getNrMatricula());
		stmtScript.setString(6, atleta.getNrCadFPT());
		stmtScript.setString(7, atleta.getNrCadCBT());
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
		stmtScript.setInt(27, atleta.getSexo());
		
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
					+ "bairro, estado, cidade, telefone, flCadastroAtivo, sexo "
					+ "FROM atleta a "
					+ "LEFT JOIN endereco e "
					+ "ON a.idAtleta = e.idAtleta "
					+ "WHERE flCadastroAtivo = " + String.valueOf(ativo)
					+ " ORDER BY nome ");
		}else{
			stmtScript = con.prepareStatement("SELECT a.idAtleta, idTpEquipe, nome, email, celular, "
					+ "nrMatricula, nrCadFPT, nrCadCBT, dtNascimento, RG, CPF, escola, serie, idTurno, "
					+ "acompPsicologico, nmMedicoResponsavel, telMedicoResponsavel, convenio, "
					+ "medicacaoAutorizada, flAlergias, dsAlergias, flMedicacao, dsMedicacao, "
					+ "nmContatoEmergencia, telContatoEmergencia, idGrauParentesco, "
					+ "dtValidade, e.idEndereco, endereco, numero, complemento,"
					+ "bairro, estado, cidade, telefone, flCadastroAtivo, sexo "
					+ "FROM atleta a "
					+ "LEFT JOIN endereco e "
					+ "ON a.idAtleta = e.idAtleta "
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
			atleta.setNrCadFPT(rs.getString(7));
			atleta.setNrCadCBT(rs.getString(8));
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
			
			atleta.setSexo(rs.getInt(36));
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
				+ "bairro, estado, cidade, telefone, sexo "
				+ "FROM atleta a "
				+ "LEFT JOIN endereco e "
				+ "ON a.idAtleta = e.idAtleta "
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
			atleta.setNrCadFPT(rs.getString(7));
			atleta.setNrCadCBT(rs.getString(8));
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
			
			atleta.setSexo(rs.getInt(36));
			
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
				+ "nmContatoEmergencia = ?, telContatoEmergencia = ?, idGrauParentesco = ?, dtValidade = ?, sexo = ? "
				+ "WHERE idAtleta = ? ");

		stmtScript.setInt(1, atleta.getIdTpEquipe());
		stmtScript.setString(2, atleta.getNome());
		stmtScript.setString(3, atleta.getEmail());
		stmtScript.setString(4, atleta.getCelular());
		stmtScript.setString(5, atleta.getNrMatricula());
		stmtScript.setString(6, atleta.getNrCadFPT());
		stmtScript.setString(7, atleta.getNrCadCBT());
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
		stmtScript.setInt(27, atleta.getSexo());
		stmtScript.setInt(28, atleta.getIdPessoa());
		
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
	public boolean inserirPendenciaAtleta(int idAtleta) throws SQLException{
		stmtScript = con.prepareStatement("INSERT INTO pendencia (idPessoa, tpDocumento) "
				+ "VALUES (?,1), (?,2), (?,3), (?,4), (?,5), (?,6), (?,7)");
		for (int i = 1; i < 8; i++) {
			stmtScript.setInt(i, idAtleta);
		}
		int rows = stmtScript.executeUpdate();
		
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
				+ "nmContatoEmergencia, telContatoEmergencia, idGrauParentesco, dtNascimento, email, "
				+ "RG, CPF, sexo FROM atleta WHERE idAtleta = ?");
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
			atleta.setEmail(rs.getString(10));
			atleta.setRG(rs.getString(11));
			atleta.setCPF(rs.getString(12));
			atleta.setSexo(rs.getInt(13));
			
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
			
			stmtScript = con.prepareStatement("SELECT idDocumento, tpDocumento, srcDocumento "
					+ "FROM documento WHERE idAtleta = ? AND tpDocumento = 7");
			stmtScript.setInt(1, idAtleta);
			ResultSet rsDocumento = stmtScript.executeQuery();
			
			List<Documento> listaDocumento = new ArrayList<Documento>();
			if(rsDocumento.next()){
				Documento doc = new Documento();
				doc.setIdDocumento(rsDocumento.getInt(1));
				doc.setIdPessoa(idAtleta);
				doc.setTpDocumento(rsDocumento.getInt(2));
				doc.setSrc(rsDocumento.getString(3));
				listaDocumento.add(doc);
			}
			atleta.setListaDocumentos(listaDocumento);
			
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
				return "J� existe um atleta com o mesmo n�mero de matr�cula registrado no sistema!";			
			
			stmtScript = con.prepareStatement("SELECT nrCadCBT FROM atleta "
					+ "WHERE nrCadCBT = ?");			
			stmtScript.setString(1, nrCadCBT);	
			
			ResultSet rsCBT = stmtScript.executeQuery();
			if(rsCBT.next())
				return "J� existe um atleta com o mesmo numero de cadastro CBT registrado no sistema!";
			
			stmtScript = con.prepareStatement("SELECT nrCadFPT FROM atleta "
					+ "WHERE nrCadFPT = ?");
			stmtScript.setString(1, nrCadFPT);
			
			ResultSet rsFPT = stmtScript.executeQuery();
			if(rsFPT.next())
				return "J� existe um atleta com o mesmo numero de cadastro FPT registrado no sistema!";
		}
		else{
			stmtScript = con.prepareStatement("SELECT nrMatricula FROM atleta "
					+ "WHERE nrMatricula = ? AND idAtleta != ?");
			stmtScript.setString(1, nrMatricula);
			stmtScript.setInt(2, idPessoa);
			
			ResultSet rsNrMatricula = stmtScript.executeQuery();
			if(rsNrMatricula.next())
				return "J� existe um atleta com o mesmo n�mero de matr�cula registrado no sistema!";			
			
			stmtScript = con.prepareStatement("SELECT nrCadCBT FROM atleta "
					+ "WHERE nrCadCBT = ? AND idAtleta != ?");			
			stmtScript.setString(1, nrCadCBT);	
			stmtScript.setInt(2, idPessoa);
			
			ResultSet rsCBT = stmtScript.executeQuery();
			if(rsCBT.next())
				return "J� existe um atleta com o mesmo n�mero de cadastro CBT registrado no sistema!";
			
			stmtScript = con.prepareStatement("SELECT nrCadFPT FROM atleta "
					+ "WHERE nrCadFPT = ? AND idAtleta != ?");
			stmtScript.setString(1, nrCadFPT);
			stmtScript.setInt(2, idPessoa);
			
			ResultSet rsFPT = stmtScript.executeQuery();
			if(rsFPT.next())
				return "J� existe um atleta com o mesmo n�mero de cadastro FPT registrado no sistema!";
		}	
		return "";
	}

	public boolean desativarDocs(Atleta atleta) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE documento "
				+ "SET validadeDocumento = NOW() "
				+ "WHERE idAtleta = ? "
				+ "	AND (validadeDocumento > NOW() OR validadeDocumento IS NULL) ");
		
		stmtScript.setInt(1, atleta.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows >= 0){
			return true;
		}		
		return false;
	}

	public boolean excluirPendencias(Atleta atleta) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("DELETE FROM pendencia WHERE idPessoa = ?");
		
		stmtScript.setInt(1, atleta.getIdPessoa());
		
		rows = stmtScript.executeUpdate();
		
		if(rows >= 0){
			return true;
		}		
		return false;
	}

	public List<Atleta> buscarAtletasVinculados(int idResponsavel) throws SQLException {
		List<Atleta> listaAtleta = new ArrayList<Atleta>();
		
		stmtScript = con.prepareStatement(
				"SELECT a.nome, ar.idGrauParentesco "
				+ "FROM atletaresponsavel ar "
				+ "INNER JOIN atleta a "
				+ "		ON ar.idAtleta = a.idAtleta "
				+ "WHERE ar.idResponsavel = ? ");
		
		stmtScript.setInt(1, idResponsavel);
		
        ResultSet rs = stmtScript.executeQuery();
        
        while(rs.next()){
        	Atleta atleta = new Atleta();
        	atleta.setNome(rs.getString("nome"));
        	atleta.setIdGrauParentesco(rs.getInt("idGrauParentesco"));
        	listaAtleta.add(atleta);
        }
		
		return listaAtleta;
		
	}

	public List<Atleta> buscarAtletasAptos() throws SQLException {
		List<Atleta> listaAtleta = new ArrayList<Atleta>();
		
		stmtScript = con.prepareStatement(
				"SELECT idAtleta, nome, idTpEquipe "
				+ "FROM atleta "
				+ "WHERE nrCadCBT IS NOT NULL "
				+ "		AND nrCadFPT IS NOT NULL ");
		
        ResultSet rs = stmtScript.executeQuery();
        
        while(rs.next()){
        	Atleta atleta = new Atleta();
        	atleta.setIdPessoa(rs.getInt(1));
        	atleta.setNome(rs.getString(2));
        	atleta.setIdTpEquipe(rs.getInt(3));
        	listaAtleta.add(atleta);
        }
		
		return listaAtleta;
	}

	public List<Atleta> buscarAtletasPorNome(String busca, int idDiaTreino) throws SQLException {
		List<Atleta> listaAtleta = new ArrayList<Atleta>();
		
		stmtScript = con.prepareStatement("SELECT DISTINCT a.idAtleta, a.nome "
				+ "FROM atleta a "
				+ "JOIN diatreinoatleta da on a.idAtleta = da.idAtleta "
				+ "WHERE a.nome LIKE '%" + busca + "%' AND da.idDiaTreino = " + idDiaTreino);
		
        ResultSet rs = stmtScript.executeQuery();
        
        while(rs.next()){
        	Atleta atleta = new Atleta();
        	atleta.setIdPessoa(rs.getInt(1));
        	atleta.setNome(rs.getString(2));
        	listaAtleta.add(atleta);
        }
		
		return listaAtleta;
	}

	public List<Integer> buscarAtletasSelecionados(int idTorneio) throws SQLException {
		List<Integer> listaAtleta = new ArrayList<Integer>();
		
		stmtScript = con.prepareStatement("SELECT at.idAtleta "
				+ "FROM atletatorneio at "
				+ "WHERE at.idTorneio = ? ");
		
		stmtScript.setInt(1, idTorneio);
        ResultSet rs = stmtScript.executeQuery();
        
        while(rs.next()){
        	listaAtleta.add(rs.getInt(1));
        }
		
		return listaAtleta;
	}

	public List<Atleta> buscarAtletaBonificacao(Integer mes, int ano) throws SQLException {
		List<Atleta> listaAtleta = new ArrayList<Atleta>();
				
		stmtScript = con.prepareStatement("SELECT a.idAtleta, a.nome, ad.idAvaliacaoDesempenho, ad.avaliacoes, "
				+ "ad.torneios, ad.treinos, ad.rankCBT, ad.rankFPT, ad.rankITF, ad.bonificado, ad.observacoes "
				+ "FROM atleta a "
				+ "LEFT JOIN avaliacaodesempenho ad ON a.idAtleta = ad.idAtleta AND ad.mes = ? AND ad.ano = ? "
				+ "WHERE a.flCadastroAtivo = 1 "
				+ "ORDER BY a.nome");
		stmtScript.setInt(1, mes);
		stmtScript.setInt(2, ano);
				
        ResultSet rs = stmtScript.executeQuery();
        
        while(rs.next()){
        	Atleta a = new Atleta();
        	a.setIdPessoa(rs.getInt(1));
        	a.setNome(rs.getString(2));
        	
        	AvaliacaoDesempenho ad = new AvaliacaoDesempenho();
        	ad.setIdAvaliacaoDesempenho(rs.getInt(3));
        	ad.setAvaliacoes(rs.getBoolean(4));
        	ad.setTorneios(rs.getBoolean(5));
        	ad.setTreinos(rs.getBoolean(6));
        	ad.setRankCBT(rs.getInt(7));
        	ad.setRankFPT(rs.getInt(8));
        	ad.setRankITF(rs.getInt(9));
        	ad.setBonificado(rs.getBoolean(10));
        	ad.setObservacoes(rs.getString(11));
        	
        	List<AvaliacaoDesempenho> lista = new ArrayList<AvaliacaoDesempenho>();
        	lista.add(ad);
        	a.setAvaliacaoDesempenho(lista);
        	
        	listaAtleta.add(a);
        }
		
		return listaAtleta;	
	}

	public boolean salvarBonificacaoAtleta(AvaliacaoDesempenho bonificacao) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("INSERT INTO avaliacaodesempenho (idAtleta, idUsuario, mes, ano, "
				+ "torneios, treinos, avaliacoes, rankCBT, rankFPT, rankITF, bonificado, observacoes) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		stmtScript.setInt(1, bonificacao.getAtleta().getIdPessoa());
		stmtScript.setInt(2, bonificacao.getUsuario().getIdPessoa());
		stmtScript.setInt(3, bonificacao.getMes());
		stmtScript.setInt(4, bonificacao.getAno());
		stmtScript.setBoolean(5, bonificacao.getTorneios());
		stmtScript.setBoolean(6, bonificacao.getTreinos());
		stmtScript.setBoolean(7, bonificacao.getAvaliacoes());
		if(bonificacao.getRankCBT() == 0){
			stmtScript.setNull(8, java.sql.Types.INTEGER);
		}else{
			stmtScript.setInt(8, bonificacao.getRankCBT());
		}
		if(bonificacao.getRankFPT() == 0){
			stmtScript.setNull(9, java.sql.Types.INTEGER);
		}else{
			stmtScript.setInt(9, bonificacao.getRankFPT());
		}
		if(bonificacao.getRankITF() == 0){
			stmtScript.setNull(10, java.sql.Types.INTEGER);
		}else{
			stmtScript.setInt(10, bonificacao.getRankITF());
		}
		stmtScript.setBoolean(11, bonificacao.getBonificado());
		stmtScript.setString(12, bonificacao.getObservacoes());		
		
		rows = stmtScript.executeUpdate();
		
		if(rows > 0){
			return true;
		}		
		return false;
	}

	public boolean editarBonificacaoAtleta(AvaliacaoDesempenho bonificacao) throws SQLException {
		int rows = 0;
		
		stmtScript = con.prepareStatement("UPDATE avaliacaodesempenho SET idUsuario = ?, torneios = ?, treinos = ?, "
				+ "avaliacoes = ?, rankCBT = ?, rankFPT = ?, rankITF = ?, bonificado = ?, observacoes = ? "
				+ "WHERE idAvaliacaoDesempenho = ?");
		
		stmtScript.setInt(1, bonificacao.getUsuario().getIdPessoa());
		stmtScript.setBoolean(2, bonificacao.getTorneios());
		stmtScript.setBoolean(3, bonificacao.getTreinos());
		stmtScript.setBoolean(4, bonificacao.getAvaliacoes());
		if(bonificacao.getRankCBT() == 0){
			stmtScript.setNull(5, java.sql.Types.INTEGER);
		}else{
			stmtScript.setInt(5, bonificacao.getRankCBT());
		}
		if(bonificacao.getRankFPT() == 0){
			stmtScript.setNull(6, java.sql.Types.INTEGER);
		}else{
			stmtScript.setInt(6, bonificacao.getRankFPT());
		}
		if(bonificacao.getRankITF() == 0){
			stmtScript.setNull(7, java.sql.Types.INTEGER);
		}else{
			stmtScript.setInt(7, bonificacao.getRankITF());
		}
		stmtScript.setBoolean(8, bonificacao.getBonificado());
		stmtScript.setString(9, bonificacao.getObservacoes());
		stmtScript.setInt(10, bonificacao.getIdAvaliacaoDesempenho());	
		
		rows = stmtScript.executeUpdate();
		
		if(rows >= 0){
			return true;
		}		
		return false;
	}
	
}
