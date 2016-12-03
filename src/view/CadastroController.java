package view;


import java.io.IOException;

import DAO.DAORecepcionista;
import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.TipoUsuario;


public class CadastroController {

	//Id do Formulario ativo
	private static String idCadastro;
	
	private static int idRecepcionista = 0;
	
	@FXML
	private AnchorPane painelPrincipal;

	@FXML
	private Pane painelCadastro;

	@FXML
	private ComboBox<String> tipoUsuario = new ComboBox<String>();
			
	private ObservableList<String> tipoUsuarioOpcoes;
	
	//TODOS OS CAMPOS DOS 3 FORMULARIOS
	//Campos do formulario comuns a todos os tipos de usuario
	@FXML
	private TextField login, senha, nome, telefone, rg, cpf;
	@FXML
	private TextField bairro, cidade, endereco, numResidencia, email;
	@FXML
	private DatePicker dataNascimento;
	
	//Campo especifico de Recepcionista
	@FXML
	private TextField codigoId;
	
	//Campos especificos de Medico
	@FXML
	private TextField crm, especialidade;
	
	//Campos especificos de Paciente
	@FXML
	private TextField prontuario, medicacao, alergia, descricaoLimitacao;
	@FXML
	private CheckBox limitacaoCognitiva, limitacaoLocomocao, limitacaoVisao, limitacaoAudicao, limitacaoOutras;
	
	
	
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
				idCadastro = newValue;
			}
		});
		
		
	}
	
	@FXML
	private void cancelarCadastro(){			
		Main.mostraTelaLogin();
	}
		
	@FXML
	private void cadastrar(){
			
		//Botão de cadastrar no Banco do Formulário para Médico
		if(idCadastro == "Médico") {				
			//DAOMedico novoMedico;
			System.out.println("Cadastrando Médico");
		}

		//Botão de cadastrar no Banco do Formulário para Paciente
		if(idCadastro == "Paciente") {
			//DAOPaciente novoPaciente;
			System.out.println("Cadastrando Paciente");
		} 

		//Botão de cadastrar no Banco do Formulário para Recepcionista
		if(idCadastro == "Recepcionista"){																			
			DAORecepcionista novoRecepcionista = new DAORecepcionista();
			novoRecepcionista.insertRecepcionista(idRecepcionista, (idRecepcionista+1), codigoId.getText().toString() );
			idRecepcionista++;	
		}					
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

			e1.printStackTrace();
		}
	}

	public void setMain(Main main) {		
	}

}