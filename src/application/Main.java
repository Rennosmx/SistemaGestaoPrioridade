package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.LoginController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane telaLogin;
	
	@Override
	public void start(Stage primaryStage) {		
		
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SGP - Saúde");
        
        mostraTelaLogin();			
	}
	
	
public void mostraTelaLogin(){
		
		try {
			 // Carrega a tela de login
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Login.fxml"));					
			telaLogin = (AnchorPane) loader.load();
			
			Scene scene = new Scene(telaLogin);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);            
            primaryStage.show();
			                      
            LoginController controller = loader.getController();
            controller.setMain(this);
            
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
