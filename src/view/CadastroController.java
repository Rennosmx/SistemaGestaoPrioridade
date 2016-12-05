package view;


import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.DAOEndereco;
import DAO.DAORecepcionista;
import DAO.DAOUsuario;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.TipoUsuario;


public class CadastroController {

	//Id do Formulario ativo
	private static String idCadastro;

	private static int idRecepcionista;

	private String sexo;

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
	private TextField login, nome, telefone, rg, cpf;	
	@FXML
	private PasswordField senha;	
	@FXML
	private TextField bairro, cidade, endereco, numResidencia, email;
	@FXML
	private DatePicker dataNascimento;
	@FXML
	private RadioButton sexoMasculino, sexoFeminino;

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

		//Associando radioButton marcado � string Sexo
		if(sexoMasculino.isFocused()){
			sexo = "Masculino";
		}else if(sexoFeminino.isFocused()){
			sexo = "Feminino";
		}

		//Checando tipo de formul�rio
		if(idCadastro == "Médico") {				
			//DAOMedico novoMedico;
			System.out.println("Cadastrando Médico");
		}else if(idCadastro == "Paciente") {
			//DAOPaciente novoPaciente;
			System.out.println("Cadastrando Paciente");
		}else if(idCadastro == "Recepcionista"){																			
			//idRecepcionista++;	
		
//			while(validacaoFormularioRecepcionista() == false){
//				validacaoFormularioRecepcionista();
//			}																				

/*		 			
			//Iniciando inser��o de usuarioRecepcionista na tabela Usuario
			DAOUsuario usuarioRecepcionista = new DAOUsuario();

			//Convertendo DatePicker para Date											
			String data = dataNascimento.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

			usuarioRecepcionista.insertUsuario(idRecepcionista, login.getText(), senha.getText(), data, 
											   rg.getText(), cpf.getText(), sexo, telefone.getText(), email.getText());
 */												
			int numeroResidencia = 0;
			try{
				numeroResidencia = Integer.parseInt(numResidencia.getText());
			}catch(NumberFormatException ex){

			}

			//Inser��o do endere�o do Recepecionista na tabela Endere�o
			DAOEndereco enderecoRecepcionista = new DAOEndereco();
			enderecoRecepcionista.insertEndereco(idRecepcionista, endereco.getText(), cidade.getText(), 
					bairro.getText(), numeroResidencia);

			//Inser��o do recepcionista na tabela Recepcionista
			DAORecepcionista novoRecepcionista = new DAORecepcionista();
			novoRecepcionista.insertRecepcionista(idRecepcionista, idRecepcionista, codigoId.getText().toString() );			
		}					

	}


	public boolean validacaoFormularioRecepcionista(){

		String numeros = "01234567989";


		//TRATAMENTO DE ERROS		
		if (login.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Login", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (senha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe uma senha", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;		
		}

		if (nome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Nome", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (dataNascimento.getValue() == null) {
			JOptionPane.showMessageDialog(null, "Informe uma Data", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (nome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Nome", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (sexoMasculino.isFocused() && sexoFeminino.isFocused() || 
				!sexoMasculino.isFocused() && !sexoFeminino.isFocused()) {

			JOptionPane.showMessageDialog(null, "Selecione uma op��o para informar o Sexo", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (email.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um E-mail", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (telefone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Telefone", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		} else if(!telefone.getText().contains(numeros)){
			JOptionPane.showMessageDialog(null, "O telefone deve conter apenas n�meros", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (rg.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um RG", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		} else if(!rg.getText().contains(numeros)){
			JOptionPane.showMessageDialog(null, "O RG deve conter apenas n�meros", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (cpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um CPF", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		} else if(!cpf.getText().contains(numeros)){
			JOptionPane.showMessageDialog(null, "O CPF deve conter apenas n�meros", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (bairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Bairro", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (cidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Cidade", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (endereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um Endereco", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		if (numResidencia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um N�mero de Resid�ncia", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		} else if(!numResidencia.getText().contains(numeros)){
			JOptionPane.showMessageDialog(null, "O N�mero de Resid�ncia deve conter apenas n�meros", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (codigoId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe um c�digo para o Recepcionista", 
					"Erro", JOptionPane.ERROR_MESSAGE);
			return false;			
		}

		return true;
	}


	//Metodo para atualizar pane contendo formul�rio do tipo de Usu�rio
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

}