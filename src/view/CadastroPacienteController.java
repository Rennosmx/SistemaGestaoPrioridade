package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class CadastroPacienteController {

	private Main main;
	
	@FXML
	private Pane painelPaciente;
		
	public Pane getPainelPaciente() {
		return painelPaciente;
	}

	public void setPainelPaciente(Pane painelPaciente) {
		this.painelPaciente = painelPaciente;
	}

	public void setMain(Main main){
		this.main = main;
	}	
	
}
