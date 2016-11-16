package view;


import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;


public class CadastroController {

	private Main main;

	@FXML
	private Pane painelAtual = new Pane();
	
	@FXML
	private ComboBox<String> tipoUsuario = new ComboBox<String>();
	
	public Pane getPainelAtual() {
		return painelAtual;
	}

	public void setPainelAtual(Pane painelAtual) {
		this.painelAtual = painelAtual;
	}
	
	
	//Metodo para atualizar pane contendo formul�rio do tipo de Usu�rio
	@FXML
	public void selecaoTipoUsuario(){				
								
		if(tipoUsuario.getValue() == "Paciente"){			
			painelAtual = new Pane();									
			CadastroPacienteController painelPaciente = new CadastroPacienteController();									
			setPainelAtual(painelPaciente.getPainelPaciente());								 
		}
		if(tipoUsuario.getValue() == "Recepcionista"){

		}
		if(tipoUsuario.getValue() == "M�dico"){

		}

	}
	
	

	public void setMain(Main main){
		this.main = main;
		tipoUsuario.getItems().addAll("Paciente", "Recepcionista", "M�dico");
		tipoUsuario.setValue("Paciente");

	}	 

}