package application;

import java.io.IOException;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.CadastroController;
import view.LoginController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private static Stage primaryStage;
	private static AnchorPane telaLogin;
	private static AnchorPane telaCadastro;
	private static AnchorPane telaInicialPaciente;
	private static AnchorPane telaInicialRecepcionista;

	@Override
	public void start(Stage primaryStage) {		

		Main.primaryStage = primaryStage;

		Main.primaryStage.setTitle("SGP - Saúde");

		mostraTelaLogin();			
	}

	public static void mostraTelaLogin(){

		try {
			// Carrega a tela de login
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Login.fxml"));					
			telaLogin = (AnchorPane) loader.load();

			Scene scene = new Scene(telaLogin);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);            
			primaryStage.show();



		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mostraTelaCadastro(){

		try {
			// Carrega a tela de login
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Cadastro.fxml"));					
			telaCadastro = (AnchorPane) loader.load();

			Scene scene = new Scene(telaCadastro);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);            
			primaryStage.show();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mostraTelaInicialPaciente(){

		try {
			// Carrega a tela inicial de Paciente
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/TelaInicialPaciente.fxml"));					
			telaInicialPaciente = (AnchorPane) loader.load();

			Scene scene = new Scene(telaInicialPaciente);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);            
			primaryStage.show();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mostraTelaInicialRecepcionista(){

		try {
			// Carrega a tela inicial de Recepcionista
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/TelaInicialRecepcionista.fxml"));					
			telaInicialRecepcionista = (AnchorPane) loader.load();

			Scene scene = new Scene(telaInicialRecepcionista);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);            
			primaryStage.show();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public AnchorPane getTelaCadastro() {
		return telaCadastro;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
