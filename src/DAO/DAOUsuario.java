package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.Usuario;

public class DAOUsuario extends DBConect{
	private static final String TABLE_NAME = "usuario";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_LOGIN = "login";
	private static final String COLUMN_SENHA = "senha";
	private static final String COLUMN_NOME = "nome";
	private static final String COLUMN_DATA_NASCIMENTO = "dataNascimento";
	private static final String COLUMN_RG = "rg";
	private static final String COLUMN_CPF = "cpf";
	private static final String COLUMN_SEXO = "sexo";
	private static final String COLUMN_TELEFONE = "telefone";
	private static final String COLUMN_EMAIL = "email";
	private static final String COLUMN_ID_TIPO_USUARIO = "idTipoUsuario";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS usuario"
			+ " (id integer , login varchar(50) NOT NULL UNIQUE, senha varchar(50) NOT NULL, nome varchar(100) NOT NULL, dataNascimento date NOT NULL,"
			+ " rg varchar(7) NOT NULL, cpf varchar(11) NOT NULL UNIQUE, sexo varchar(1) NOT NULL, "
			+ " telefone varchar(12) NOT NULL, email varchar(80) UNIQUE, idTipoUsuario integer, "
			+ " enabled integer NOT NULL DEFAULT '1', PRIMARY KEY(id))";
	
	public DAOUsuario(){
		super();
		createTable();
	}
	
	public void createTable(){
		super.createTable(CREATE_TABLE);
	}
	
	public void insertUsuario(int id, String login, String senha, String nome, String dataNascimento, 
							  String rg, String cpf, String sexo, String telefone, String email, String idTipoUsuario){
		//abre conexao com banco
			super.conect();
		// prepara statement para executar query
			Statement stmt = null;
		// query que será executada
			String sql = "INSERT INTO "
				+TABLE_NAME+"("+COLUMN_ID+","+COLUMN_LOGIN+","+COLUMN_SENHA+","+COLUMN_NOME+","+COLUMN_DATA_NASCIMENTO+","
							   +COLUMN_RG+","+COLUMN_CPF+","+COLUMN_SEXO+","+COLUMN_TELEFONE+","+COLUMN_EMAIL+","
							   +COLUMN_ID_TIPO_USUARIO+")"
							   + " VALUES('"+id+"','"+login+"','"+senha+"','"+nome+"','"+dataNascimento+"','"
							   				+rg+",'"+cpf+",'"+sexo+",'"+telefone+"','"+email+"','"+idTipoUsuario+"')";

			try {
				stmt = this.conn.createStatement();
				stmt.executeUpdate(sql);
				System.out.println("usuario incluido com sucesso!");
			} catch(SQLException e){
				System.out.println("erro incluir endereco: " + e.getMessage());
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
	
	public Usuario selectUsuario(String column, String value){
		Usuario user = new Usuario();
		
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		Statement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = "+value;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			user.setId(rs.getInt(COLUMN_ID));
			user.setLogin(rs.getString(COLUMN_LOGIN));
			user.setSenha(rs.getString(COLUMN_SENHA));
			user.setNome(rs.getString(COLUMN_NOME));
			user.setDataNascimento(rs.getDate(COLUMN_DATA_NASCIMENTO));
			user.setCpf(rs.getString(COLUMN_CPF));
			user.setRg(rs.getString(COLUMN_RG));
			user.setSexo(rs.getString(COLUMN_SEXO));
			user.setEmail(rs.getString(COLUMN_EMAIL));
			user.setIdTipoUsuario(rs.getInt(COLUMN_ID_TIPO_USUARIO));
			user.setTelefone(rs.getString(COLUMN_TELEFONE));
			System.out.println("pesquisa feita!");
		} catch(SQLException e){
			System.out.println("erro ao selecionar usuario: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		
		return user;
	}

	public Usuario selectUsuario(String column, int value){
		Usuario user = new Usuario();
		
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		Statement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = "+value;
		
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			user.setId(rs.getInt(COLUMN_ID));
			user.setLogin(rs.getString(COLUMN_LOGIN));
			user.setSenha(rs.getString(COLUMN_SENHA));
			user.setNome(rs.getString(COLUMN_NOME));
			user.setDataNascimento(rs.getDate(COLUMN_DATA_NASCIMENTO));
			user.setCpf(rs.getString(COLUMN_CPF));
			user.setRg(rs.getString(COLUMN_RG));
			user.setSexo(rs.getString(COLUMN_SEXO));
			user.setEmail(rs.getString(COLUMN_EMAIL));
			user.setIdTipoUsuario(rs.getInt(COLUMN_ID_TIPO_USUARIO));
			user.setTelefone(rs.getString(COLUMN_TELEFONE));
			System.out.println("pesquisa feita!");
		} catch(SQLException e){
			System.out.println("erro ao selecionar usuario: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		
		return user;
	}
}