package DAO;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DAOUsuario extends DBConect{
	private static final String TABLE_NAME = "usuario";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_LOGIN = "login";
	private static final String COLUMN_SENHA = "senha";
	private static final String COLUMN_DATA_NASCIMENTO = "dataNascimento";
	private static final String COLUMN_RG = "rg";
	private static final String COLUMN_CPF = "cpf";
	private static final String COLUMN_SEXO = "sexo";
	private static final String COLUMN_TELEFONE = "telefone";
	private static final String COLUMN_EMAIL = "email";
	
	public DAOUsuario(){
		
	}
	
	public void insertUsuario(int id, String login, String senha, String dataNascimento, 
							  String rg, String cpf, String sexo, String telefone, String email){
		//abre conexao com banco
			super.conect();
		// prepara statement para executar query
			Statement stmt = null;
		// query que será executada
			String sql = "INSERT INTO "
				+TABLE_NAME+"("+COLUMN_ID+","+COLUMN_LOGIN+","+COLUMN_SENHA+","+COLUMN_DATA_NASCIMENTO+","
							   +COLUMN_RG+","+COLUMN_CPF+","+COLUMN_SEXO+","+COLUMN_TELEFONE+","+COLUMN_EMAIL+")"
							   + " VALUES('"+id+"','"+login+"','"+senha+"','"+dataNascimento+"','"
							   				+rg+",'"+cpf+",'"+sexo+",'"+telefone+"','"+email+"')";

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
	
}
