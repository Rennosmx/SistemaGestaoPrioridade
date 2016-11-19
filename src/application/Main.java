package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.CadastroController;
import view.LoginController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane telaLogin, telaCadastro;	
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) {		
		
		this.primaryStage = primaryStage;

        this.primaryStage.setTitle("SGP - Sa�de");
        
        mostraTelaLogin();			
	}
	
	public void mostraTelaLogin(){
		
		try {
			 // Carrega a tela de login
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Login.fxml"));					
			telaLogin = (AnchorPane) loader.load();
			
			scene = new Scene(telaLogin);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);            
            primaryStage.show();
			       
            LoginController controller = loader.getController();
            controller.setMain(this);
            
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mostraTelaCadastro(){
		
		try {
			 // Carrega a tela de login
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Cadastro.fxml"));					
			telaCadastro = (AnchorPane) loader.load();
															
			scene = new Scene(telaCadastro);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);            
            primaryStage.show();
            
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
	public Scene getScene() {
		return scene;
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
