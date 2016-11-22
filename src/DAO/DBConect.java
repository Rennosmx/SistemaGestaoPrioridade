package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConect {
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/sgp_db";
	private String user = "postgres";
	private String password = "postgres";
	protected Connection conn;
	
	public DBConect(){
		
	}
	
	public void createTable(String tableName){
		/*Statement stmt = null;
		String sql = "CREATE TABLE IF NOT EXISTS " +tableName+" (id integer , name varchar(50) NOT NULL, pass varchar(50) NOT NULL, enabled integer NOT NULL DEFAULT '1', PRIMARY KEY(id))";
		try{
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("tabela criada com sucesso!");
		} catch(SQLException e){
			System.out.println("erro criar tabela: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}*/
	}
	public void conect(){
		try{
			Class.forName(this.driver);
			this.conn = DriverManager.getConnection(this.url,this.user,this.password);
			System.out.println("open connection...");
		}catch(ClassNotFoundException e){
			System.out.println("Não foi possível encontrar o diver de Banco: " + e.getMessage() );
		}catch(SQLException e){
			System.out.println("Error ao conctar ao banco: " + e.getMessage());
		}
	}
	// desconecta do banco de dados
	public void disconect(){
		try {
			if(this.conn != null) this.conn.close();
			System.out.println("close connection...");
		} catch(SQLException e){
			System.out.println("Erro tentanto fechar a conexão com o banco: " + e.getMessage());
		}
	}
}
