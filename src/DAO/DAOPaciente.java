package DAO;

public class DAOPaciente extends DBConect{
	private static final String TABLE_NAME = "paciente";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_ID_USUARIO = "id_usuario";
	public static final String COLUMN_ID_PRONTUARIO = "id_prontuario";
	private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME
			+"("+COLUMN_ID+" serial,"+COLUMN_ID_USUARIO+" integer references usuario(id) NOT NULL,"
			+COLUMN_ID_PRONTUARIO+" integer references prontuario(id) NOT NULL,"
					+ " enable integer NOT NULL DEFAULT '1', PRIMARY KEY(id))";

}
