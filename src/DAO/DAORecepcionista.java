package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Endereco;
import model.Recepcionista;
import model.Usuario;

public class DAORecepcionista extends DBConect{
	private static final String TABLE_NAME = "recepcionista";
	public static final String COLUMN_ID = "id";	
	public static final String COLUMN_USER_ID = "usuario_id";
	public static final String COLUMN_CODIGO = "codigo";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS recepcionista"
			+ " (id serial , usuario_id integer references usuario(id) NOT NULL, codigo varchar(10) NOT NULL UNIQUE, enabled integer NOT NULL DEFAULT '1', PRIMARY KEY(id))";
	
	public DAORecepcionista(){
		super();
		createTable();
	}
	
	public void createTable(){
		super.createTable(CREATE_TABLE);
	}
	
	public void insertRecepcionista(int usuario_id, String codigo){
		//abre conexao com banco
		super.conect();
	// prepara statement para executar query
		Statement stmt = null;
	// query que será executada
		String sql = "INSERT INTO "
			+TABLE_NAME+"("+COLUMN_USER_ID+","+COLUMN_CODIGO+")"
			   + " VALUES('"+usuario_id+"','"+codigo+"')";

		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("recepcionista incluido com sucesso!");
		} catch(SQLException e){
			System.out.println("erro incluir recepcionista: " + e.getMessage());
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
	
	public Recepcionista selectRecepcionista(String column, int value){
		Recepcionista rec = new Recepcionista();
		
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		Statement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = "+value;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			rec.setCodigo(rs.getString(COLUMN_CODIGO));
			rec.setIdRecepcionista(rs.getInt(COLUMN_ID));
			
			DAOUsuario searchUser = new DAOUsuario();
			Usuario u = searchUser.selectUsuario(COLUMN_ID, rs.getInt(COLUMN_USER_ID));
			
			rec.setNome(u.getNome());
			rec.setDataNascimento(u.getDataNascimento());
			rec.setCpf(u.getCpf());
			rec.setEmail(u.getEmail());
			rec.setIdTipoUsuario(u.getIdTipoUsuario());
			rec.setLogin(u.getLogin());
			rec.setRg(u.getRg());
			rec.setSenha(u.getSenha());
			rec.setSexo(u.getSexo());
			rec.setTelefone(u.getTelefone());
			
			 
			System.out.println("Recepcionista pesquisado com sucesso!");
		} catch(SQLException e){
			System.out.println("erro ao pesquisar Recepcionista: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		return rec;
	}
	
	public Recepcionista selectRecepcionista(String column, String value){
		Recepcionista rec = new Recepcionista();
		
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		Statement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = "+value;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			rec.setCodigo(rs.getString(COLUMN_CODIGO));
			rec.setIdRecepcionista(rs.getInt(COLUMN_ID));
			
			DAOUsuario searchUser = new DAOUsuario();
			Usuario u = searchUser.selectUsuario(COLUMN_ID, rs.getInt(COLUMN_USER_ID));
			
			rec.setNome(u.getNome());
			rec.setDataNascimento(u.getDataNascimento());
			rec.setCpf(u.getCpf());
			rec.setEmail(u.getEmail());
			rec.setIdTipoUsuario(u.getIdTipoUsuario());
			rec.setLogin(u.getLogin());
			rec.setRg(u.getRg());
			rec.setSenha(u.getSenha());
			rec.setSexo(u.getSexo());
			rec.setTelefone(u.getTelefone());
			
			 
			System.out.println("Recepcionista pesquisado com sucesso!");
		} catch(SQLException e){
			System.out.println("erro ao pesquisar Recepcionista: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		return rec;
	}
}
