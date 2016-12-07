package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Medico;
import model.Usuario;

public class DAOMedico extends DBConect {
	private static final String TABLE_NAME = "medico";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_USER_ID = "usuario_id";
	public static final String COLUMN_CRM = "crm";
	public static final String COLUMN_ESPECIALIDADE = "especialidade";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME
			+ "("+COLUMN_ID+" serial, "+COLUMN_USER_ID+" integer NOT NULL, "+COLUMN_CRM+" varchar(20) NOT NULL, "
			+COLUMN_ESPECIALIDADE+" varchar(50) NOT NULL, enabled integer NOT NULL DEFAULT = 1, PRIMARY KEY(id)";
	
	public DAOMedico(){
		super();
		createTable();
	}
	
	public void createTable(){
		super.createTable(CREATE_TABLE);
	}
	
	public void insertMedico(int usuario_id, String CRM, String especialidade){
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		PreparedStatement stmt = null;
		// query que será executada
		String sql = "INSERT INTO "
			+TABLE_NAME+"("+COLUMN_USER_ID+","+COLUMN_CRM+","+COLUMN_ESPECIALIDADE+")"
						   + " VALUES(?,?,?)";

		try {
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, usuario_id);
			stmt.setString(2, CRM);
			stmt.setString(3, especialidade);
			stmt.executeUpdate();
			System.out.println("Medico incluido com sucesso!");
		} catch(SQLException e){
			System.out.println("erro ao incluir Medico: " + e.getMessage());
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
	
	public Medico selectUsuario(String column, String value){
		Medico med = new Medico();
		DAOUsuario daoUser = new DAOUsuario();
		Usuario user;
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		PreparedStatement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = ?";
		try {
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, value);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				med.setCRM(rs.getString(COLUMN_CRM));
				med.setEspecialidade(rs.getString(COLUMN_ESPECIALIDADE));
				
				user = daoUser.selectUsuario(DAOUsuario.COLUMN_ID, rs.getInt(COLUMN_USER_ID));
				
				med.setId(user.getId());
				med.setNome(user.getNome());
				med.setDataNascimento(user.getDataNascimento());
				med.setCpf(user.getCpf());
				med.setEmail(user.getEmail());
				med.setIdTipoUsuario(user.getIdTipoUsuario());
				med.setLogin(user.getLogin());
				med.setRg(user.getRg());
				med.setSenha(user.getSenha());
				med.setSexo(user.getSexo());
				med.setTelefone(user.getTelefone());
			}
			System.out.println("pesquisa feita!");
		} catch(SQLException e){
			System.out.println("erro ao selecionar Medico: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		return med;
	}
	
	public Medico selectUsuario(String column, int value){
		Medico med = new Medico();
		DAOUsuario daoUser = new DAOUsuario();
		Usuario user;
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
				med.setCRM(rs.getString(COLUMN_CRM));
				med.setEspecialidade(rs.getString(COLUMN_ESPECIALIDADE));
				
				user = daoUser.selectUsuario(DAOUsuario.COLUMN_ID, rs.getInt(COLUMN_USER_ID));
				
				med.setId(user.getId());
				med.setNome(user.getNome());
				med.setDataNascimento(user.getDataNascimento());
				med.setCpf(user.getCpf());
				med.setEmail(user.getEmail());
				med.setIdTipoUsuario(user.getIdTipoUsuario());
				med.setLogin(user.getLogin());
				med.setRg(user.getRg());
				med.setSenha(user.getSenha());
				med.setSexo(user.getSexo());
				med.setTelefone(user.getTelefone());
			}
			System.out.println("pesquisa feita!");
		} catch(SQLException e){
			System.out.println("erro ao selecionar Medico: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		return med;
	}
	
}
