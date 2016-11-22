package view;

import DAO.DBConect;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

	private Main main;
	
	@FXML
	TextField txUsuario;
	
	@FXML
	TextField txSenha;
	
	@FXML
	public void btnEntrar(){
		//main.mostaTelaInicial();
	}
		
	@FXML
	public void linkCadastrar(){
		DBConect db = new DBConect();
		main.mostraTelaCadastro();
	}

	public void setMain(Main main) {
		this.main = main;
	}
			
}
