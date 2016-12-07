package DAO;

public class DAOMedico extends DBConect {
	private static final String TABLE_NAME = "medico";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_USER_ID = "usuario_id";
	public static final String COLUMN_CRM = "crm";
	public static final String COLUMN_ESPECIALIDADE = "especialidade";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME
			+ "("+COLUMN_ID+" serial, "+COLUMN_USER_ID+" integer NOT NULL, "+COLUMN_CRM+" varchar(20) NOT NULL, "
			+COLUMN_ESPECIALIDADE+" varchar(50) NOT NULL, enabled integer NOT NULL DEFAULT = 1, PRIMARY KEY(id)";
	
	public DAOMedico(){
		super();
		createTable();
	}
	
	public void createTable(){
		super.createTable(TABLE_NAME);
	}
	
	public void insertMedico(){
		
	}
}
