package view;

import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class ConsultaController {

	@FXML
	private MenuButton menuConsultas;
		
	@FXML
	private TextField nomePaciente;
	
	@FXML
	private TextField nomeMedico;
	
	@FXML
	private DatePicker dataConsulta;
	
	@FXML
	private TextField motivoConsulta;
	
	@FXML
	private TextField laudoMedico;
	
	@FXML
	private CheckBox consultaRealizada;
		
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
	private void cadastrarConsulta(){
		
	}
	
	@FXML
	private void deletarConsulta(){
		
	}
	
	@FXML
	private void voltarTelaProntuario(){
		Main.mostraTelaInicialRecepcionista();
	}
}
