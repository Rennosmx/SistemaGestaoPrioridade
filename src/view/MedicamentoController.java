package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class MedicamentoController {

	
	
	
	@FXML
	private MenuButton menuMedicamentos;
		
	@FXML
	private TextField nomeMedicamento;
	
	@FXML
	private TextField indicacoes;
			
	@FXML
	private TextField compostos;
	
	@FXML
	private TextField principioAtivo;
			
	@FXML
	public void initialize(){
		initComponents();
		initListeners();
		initLayout();
	}
	
	public void initLayout() {

	}

	
	public void initComponents() {
		
	}

	public void initListeners() {
					
	}
	
	@FXML
	private void cadastrarMedicamento(){
		//CADASTRA MEDICAMENTO NO BD OU ATUALIZA ALGUM MEDICAMENTO SELECIONADO 		
	}
	
	@FXML
	private void deletarMedicamento(){
		
	}
	
	@FXML
	private void voltarTelaProntuario(){
		
		Main.mostraTelaInicialRecepcionista();
	}
	
}
