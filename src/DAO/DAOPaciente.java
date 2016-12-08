package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Paciente;
import model.Prontuario;
import model.Usuario;

public class DAOPaciente extends DBConect{
	private static final String TABLE_NAME = "paciente";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_ID_USUARIO = "id_usuario";
	public static final String COLUMN_ESTADO_CIVIL = "estado_civil";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME
			+"("+COLUMN_ID+" serial,"+COLUMN_ID_USUARIO+" integer references usuario(id) NOT NULL,"
					+ COLUMN_ESTADO_CIVIL+" varchar(15) NOT NULL, enable integer NOT NULL DEFAULT '1', PRIMARY KEY(id))";
	
	public DAOPaciente(){
		super();
		createTable();
	}
	
	private void createTable(){
		super.createTable(CREATE_TABLE);
	}
	
	public void insertPaciente(int id_usuario, String estadoCivil){
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		PreparedStatement stmt = null;
		// query que será executada
		String sql = "INSERT INTO "
					+TABLE_NAME+"("+COLUMN_ID_USUARIO+","+COLUMN_ESTADO_CIVIL+")"
								   + " VALUES(?,?)";
		try {
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, id_usuario);
			stmt.setString(2, estadoCivil);
			stmt.executeUpdate();
			System.out.println("Paciente incluido com sucesso!");
		} catch(SQLException e){
			System.out.println("erro ao incluir Paciente: " + e.getMessage());
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
	
	public Paciente selectPaciente(String column, int value){
		Paciente pro = new Paciente();
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
				pro.setIdPaciente(rs.getInt(COLUMN_ID));
				pro.setEstadoCivil(rs.getString(COLUMN_ESTADO_CIVIL));
				
				user = daoUser.selectUsuario(DAOUsuario.COLUMN_ID, rs.getInt(COLUMN_ID_USUARIO));
				
				pro.setId(user.getId());
				pro.setNome(user.getNome());
				pro.setDataNascimento(user.getDataNascimento());
				pro.setCpf(user.getCpf());
				pro.setEmail(user.getEmail());
				pro.setIdTipoUsuario(user.getIdTipoUsuario());
				pro.setLogin(user.getLogin());
				pro.setRg(user.getRg());
				pro.setSenha(user.getSenha());
				pro.setSexo(user.getSexo());
				pro.setTelefone(user.getTelefone());
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
		return pro;
	}

}
