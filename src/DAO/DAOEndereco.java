package DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class DAOEndereco extends DBConect {
	private static final String TABLE_NAME = "endereco";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_RUA = "rua";
	private static final String COLUMN_CEP = "cep";
	private static final String COLUMN_BAIRRO = "bairro";
	private static final String COLUMN_NUMERO = "numero";
	
	public DAOEndereco(){
		
	}
	
	public void insertEndereco(int id, String rua, String cep, String bairro, int numero){
	//abre conexao com banco
		super.conect();
	// prepara statement para executar query
		Statement stmt = null;
	// query que será executada
		String sql = "INSERT INTO "
			+TABLE_NAME+"("+COLUMN_ID+","+COLUMN_RUA+","+COLUMN_CEP+","+COLUMN_BAIRRO+","+COLUMN_NUMERO+")"
								+ " VALUES('"+id+"','"+rua+"','"+cep+"','"+bairro+"','"+numero+"')";

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
}
