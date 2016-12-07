package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Endereco;

public class DAOEndereco extends DBConect {
	private static final String TABLE_NAME = "endereco";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_RUA = "rua";
	public static final String COLUMN_CEP = "cep";
	public static final String COLUMN_BAIRRO = "bairro";
	public static final String COLUMN_NUMERO = "numero";
	public static final String COLUMN_ID_USER = "id_usuario";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME+""
			+ " ("+COLUMN_ID+" serial , "+COLUMN_RUA+" varchar(50) NOT NULL, "
			+COLUMN_CEP+" varchar(8) NOT NULL, "+COLUMN_BAIRRO+" varchar(50) NOT NULL,"
			+ " "+COLUMN_NUMERO+" varchar(5) NOT NULL, enabled integer NOT NULL DEFAULT '1', "+COLUMN_ID_USER+" integer references usuario(id), PRIMARY KEY(id))";
	public DAOEndereco(){
		super();
		createTable();
	}
	
	public void createTable(){
		super.createTable(CREATE_TABLE);
	}
	
	public void insertEndereco(String rua, String cep, String bairro, int numero, int id_usuario){
	//abre conexao com banco
		super.conect();
	// prepara statement para executar query
		Statement stmt = null;
	// query que será executada
		String sql = "INSERT INTO "
			+TABLE_NAME+"("+COLUMN_RUA+","+COLUMN_CEP+","+COLUMN_BAIRRO+","+COLUMN_NUMERO+","+COLUMN_ID_USER+")"
								+ " VALUES('"+rua+"','"+cep+"','"+bairro+"','"+numero+"','"+id_usuario+"')";

		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			 
			System.out.println("endereco incluido com sucesso!");
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
	
	public Endereco selectEndereco(String column, String value){
		Endereco end = new Endereco();
		
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		Statement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = "+value;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			end.setBairro(rs.getString(COLUMN_BAIRRO));
			end.setCep(rs.getString(COLUMN_CEP));
			end.setRua(rs.getString(COLUMN_RUA));
			end.setNumero(rs.getString(COLUMN_NUMERO));
			end.setId(rs.getInt(COLUMN_ID));
			end.setIdUsuario(rs.getInt(COLUMN_ID_USER));

			 
			System.out.println("endereco pesquisado com sucesso!");
		} catch(SQLException e){
			System.out.println("erro ao pesquisar endereco: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		
		return end;
	}
	
	public Endereco selectEndereco(String column, int value){
		Endereco end = new Endereco();
		
		//abre conexao com banco
		super.conect();
		// prepara statement para executar query
		Statement stmt = null;
		// query que será executada
		String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+column+" = "+value;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			end.setBairro(rs.getString(COLUMN_BAIRRO));
			end.setCep(rs.getString(COLUMN_CEP));
			end.setRua(rs.getString(COLUMN_RUA));
			end.setNumero(rs.getString(COLUMN_NUMERO));
			end.setId(rs.getInt(COLUMN_ID));
			end.setIdUsuario(rs.getInt(COLUMN_ID_USER));
			 
			System.out.println("endereco pesquisado com sucesso!");
		} catch(SQLException e){
			System.out.println("erro ao pesquisar endereco: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
		super.disconect();
		
		return end;
	}
}
