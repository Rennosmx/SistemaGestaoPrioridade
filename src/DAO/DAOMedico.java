package DAO;

public class DAOMedico extends DBConect {
	private static final String TABLE_NAME = "medico";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_USER_ID = "usuario_id";
	public static final String COLUMN_CRM = "crm";
	public static final String COLUMN_ESPECIALIDADE = "especialidade";
	private static final String CREATE_TABLE = "";
	
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
