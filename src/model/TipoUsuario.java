package model;

public enum TipoUsuario {
	TIPO_MEDICO(0, "Médico", "/view/CadastroMedico.fxml"),
	TIPO_PACIENTE(1, "Paciente", "/view/CadastroPaciente.fxml"),
	TIPO_RECEPCIONISTA(2, "Recepcionista", "/view/CadastroRecepcionista.fxml");
	
	private int id;
	private String tipo;
	private String path;
	
	private TipoUsuario(int id, String tipo, String path) {
		this.id = id;
		this.tipo = tipo;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
