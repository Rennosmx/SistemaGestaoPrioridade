package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.Usuario;

public class DAOUsuario extends DBConect{
	private static final String TABLE_NAME = "usuario";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_LOGIN = "login";
	public static final String COLUMN_SENHA = "senha";
	public static final String COLUMN_NOME = "nome";
	public static final String COLUMN_DATA_NASCIMENTO = "dataNascimento";
	public static final String COLUMN_RG = "rg";
	public static final String COLUMN_CPF = "cpf";
	public static final String COLUMN_SEXO = "sexo";
	public static final String COLUMN_TELEFONE = "telefone";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_ID_TIPO_USUARIO = "idTipoUsuario";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS usuario"
			+ " (id serial , login varchar(50) NOT NULL UNIQUE, senha varchar(50) NOT NULL, nome varchar(100) NOT NULL, dataNascimento date NOT NULL,"
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
	
	public void insertUsuario(String login, String senha, String nome, Date dataNascimento, 
							  String rg, String cpf, String sexo, String telefone, String email, int idTipoUsuario){
		//abre conexao com banco
			super.conect();
		// prepara statement para executar query
			PreparedStatement stmt = null;
		// query que será executada
			String sql = "INSERT INTO "
				+TABLE_NAME+"("+COLUMN_LOGIN+","+COLUMN_SENHA+","+COLUMN_NOME+","+COLUMN_DATA_NASCIMENTO+","
							   +COLUMN_RG+","+COLUMN_CPF+","+COLUMN_SEXO+","+COLUMN_TELEFONE+","+COLUMN_EMAIL+","
							   +COLUMN_ID_TIPO_USUARIO+")"
							   + " VALUES(?,?,?,?,?,?,?,?,?,?)";

			try {
				stmt = this.conn.prepareStatement(sql);
				stmt.setString(1, login);
				stmt.setString(2, senha);
				stmt.setString(3, nome);
				stmt.setDate(4, new java.sql.Date(dataNascimento.getTime()));
				stmt.setString(5, rg);
				stmt.setString(6, cpf);
				stmt.setString(7, sexo);
				stmt.setString(8, telefone);
				stmt.setString(9, email);
				stmt.setInt(10, idTipoUsuario);
				stmt.executeUpdate();
				System.out.println("usuario incluido com sucesso!");
			} catch(SQLException e){
				System.out.println("erro ao incluir usuario: " + e.getMessage());
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
		PreparedStatement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = ?";
		try {
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, value);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
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
			}
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
		super.disconect();
		return user;
	}

	public Usuario selectUsuario(String column, int value){
		Usuario user = new Usuario();
		
		//abre conexao com banco
		super.conect();
		PreparedStatement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = ?";
		try {
			stmt = this.conn.prepareStatement(sql);
			stmt.setInt(1, value);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
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
			}
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
		super.disconect();
		return user;
	}
}