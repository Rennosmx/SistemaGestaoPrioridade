package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Medico;
import model.Paciente;
import model.Prontuario;
import model.Usuario;

public class DAOProntuario extends DBConect {
	private static final String TABLE_NAME = "prontuario";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_ID_PACIENTE = "id_paciente";
	public static final String COLUMN_PRESSAO = "pressao";
	public static final String COLUMN_ALERGIA = "alergia";
	public static final String COLUMN_LIMITACAO = "limitacao";
	public static final String COLUMN_MEDICAMENTO = "medicamento";
	public static final String COLUMN_HIPERTENSO = "hipertenso";
	public static final String COLUMN_RISCOMEDICO = "risco_medico";
	public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("
			+ COLUMN_ID+" serial, "+COLUMN_ID_PACIENTE+" integer references paciente(id) NOT NULL, "
					+ COLUMN_PRESSAO+" varchar(5) NOT NULL, "+COLUMN_ALERGIA+ " boolean, "+COLUMN_LIMITACAO+""
							+ " boolean, "+COLUMN_MEDICAMENTO+" boolean, "+COLUMN_HIPERTENSO+" boolean, "
									+ COLUMN_RISCOMEDICO+" boolean)";
	
	public DAOProntuario(){
		super();
	}
	
	public void createTable(){
		super.createTable(TABLE_NAME);
	}
	
	public void insertProntuario(int id_paciente, String pressao, boolean alergia, boolean limitacao, boolean medicamento,
			boolean hipertenso, boolean riscoMedico){
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		PreparedStatement stmt = null;
		// query que será executada
		String sql = "INSERT INTO "
					+TABLE_NAME+"("+COLUMN_ID_PACIENTE+","+COLUMN_PRESSAO+","+COLUMN_ALERGIA+","+COLUMN_LIMITACAO+","+COLUMN_MEDICAMENTO+
					","+COLUMN_HIPERTENSO+","+COLUMN_RISCOMEDICO+")"
								   + " VALUES(?,?,?,?,?,?,?)";
		try {
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, id_paciente);
			stmt.setString(2, pressao);
			stmt.setBoolean(3, alergia);
			stmt.setBoolean(4, limitacao);
			stmt.setBoolean(5, medicamento);
			stmt.setBoolean(6, hipertenso);
			stmt.setBoolean(7, riscoMedico);
			stmt.executeUpdate();
			System.out.println("Prontuario incluido com sucesso!");
		} catch(SQLException e){
			System.out.println("erro ao incluir Prontuario: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		
	}
	
	public Prontuario selectUsuario(String column, int value){
		Prontuario pro = new Prontuario();
		DAOPaciente daoUserPaciente = new DAOPaciente();
		Paciente paciente;
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		PreparedStatement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = ?";
		try {
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, value);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				pro.setPressao(rs.getString(COLUMN_PRESSAO));
				pro.setAlergia(rs.getBoolean(COLUMN_ALERGIA));
				pro.setLimitacao(rs.getBoolean(COLUMN_LIMITACAO));
				pro.setMedicamento(rs.getBoolean(COLUMN_MEDICAMENTO));
				pro.setHipertenso(rs.getBoolean(COLUMN_HIPERTENSO));
				
				paciente = daoUserPaciente.selectPaciente(DAOUsuario.COLUMN_ID, rs.getInt(COLUMN_ID_PACIENTE));
				pro.setPaciente(paciente);
			}
			System.out.println("pesquisa feita!");
		} catch(SQLException e){
			System.out.println("erro ao selecionar prontuario: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		return pro;
	}
}
