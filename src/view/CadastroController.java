package view;


import java.io.IOException;

import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.TipoUsuario;


public class CadastroController {

	private Main main;

	@FXML
	private AnchorPane painelPrincipal;

	@FXML
	private Pane painelCadastro;

	@FXML
	private ComboBox<String> tipoUsuario = new ComboBox<String>();

	private ObservableList<String> tipoUsuarioOpcoes;

	public Pane getPainelAtual() {
		return painelCadastro;
	}

	public void setPainelAtual(Pane painelAtual) {
		this.painelCadastro = painelAtual;
	}

	@FXML
	public void initialize() {
		initComponents();
		initListeners();
		initLayout();
	}

	private void initLayout() {
		// TODO Auto-generated method stub		
	}

	public void initComponents() {
		tipoUsuarioOpcoes = FXCollections.observableArrayList();
		tipoUsuarioOpcoes.addAll("Selecione", "Paciente","Recepcionista","Médico");

		tipoUsuario.getItems().clear();
		tipoUsuario.setItems(tipoUsuarioOpcoes);
		tipoUsuario.setValue("Selecione");
	}

	public void initListeners() {
		tipoUsuario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				selecionarTipoUsuario(newValue);
			}
		});
	}

	//Metodo para atualizar pane contendo formulário do tipo de Usuário
	public void selecionarTipoUsuario(String tipoUsuario){				
		painelCadastro.getChildren().clear();
		if(tipoUsuario.equals(TipoUsuario.TIPO_MEDICO.getTipo())) {				
			carregarForm(TipoUsuario.TIPO_MEDICO);

		}

		if(tipoUsuario.equals(TipoUsuario.TIPO_PACIENTE.getTipo())) {
			carregarForm(TipoUsuario.TIPO_PACIENTE);

		} else if(tipoUsuario.equals(TipoUsuario.TIPO_RECEPCIONISTA.getTipo())){
			carregarForm(TipoUsuario.TIPO_RECEPCIONISTA);
		}
	}

	private void carregarForm(TipoUsuario tipoUsuario) {
		FXMLLoader loaderPane = new FXMLLoader();
		loaderPane.setLocation(Main.class.getResource(tipoUsuario.getPath()));					
		try {

			painelCadastro.getChildren().clear();					
			painelCadastro.getChildren().add(loaderPane.load());
			painelCadastro.requestLayout();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}