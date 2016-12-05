package DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class DAORecepcionista extends DBConect{
	private static final String TABLE_NAME = "recepcionista";
	private static final String COLUMN_ID = "id";	
	private static final String COLUMN_USER_ID = "usuario_id";
	private static final String COLUMN_CODIGO = "codigo";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS recepcionista"
			+ " (id integer , usuario_id integer NOT NULL, codigo varchar(10) NOT NULL, enabled integer NOT NULL DEFAULT '1', PRIMARY KEY(id))";
	
	public DAORecepcionista(){
		super();
	}
	
	public void createTable(){
		super.createTable(CREATE_TABLE);
	}
	
	public void insertRecepcionista(int colunm_id, int usuario_id, String codigo){
		//abre conexao com banco
		super.conect();
	// prepara statement para executar query
		Statement stmt = null;
	// query que será executada
		String sql = "INSERT INTO "
			+TABLE_NAME+"("+COLUMN_ID+","+COLUMN_USER_ID+","+COLUMN_CODIGO+")"
			   + " VALUES('"+colunm_id+"','"+usuario_id+"','"+codigo+"')";

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
}
