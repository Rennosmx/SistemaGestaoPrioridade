package DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class DAORecepcionista extends DBConect{
	private static final String TABLE_NAME = "recepcionista";
	private static final String COLUMN_ID = "id";	
	private static final String COLUMN_USER_ID = "usuario_id";
	private static final String COLUMN_CODIGO = "codigo";
	
	public DAORecepcionista(){
		
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
}
