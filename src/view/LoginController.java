package view;

import javax.swing.JOptionPane;


import DAO.DAOUsuario;
import DAO.DBConect;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Usuario;

public class LoginController {

	@FXML
	TextField txUsuario;
	
	@FXML
	PasswordField txSenha;
	
	@FXML
	public void btnEntrar(){
		//main.mostaTelaInicial();
		
		//Pesquisa o usuario para o login digitado
		DAOUsuario daoUsuario = new DAOUsuario();
		Usuario usuario = daoUsuario.selectUsuario("login", txUsuario.getText());
		
		//Autentica o usuario
		if(usuario != null && txSenha.getText().equals(usuario.getSenha())){
			try {
				
				//Filtra o tipo de usuario
				
				//USUARIO DO TIPO PACIENTE
				if(usuario.getIdTipoUsuario() == 1){
					Main.mostraTelaInicialPaciente();					
				}
						
				//USUARIO DO TIPO RECEPCIONISTA
				else if(usuario.getIdTipoUsuario() == 2){
					Main.mostraTelaInicialRecepcionista();
				}
				//USUARIO DO TIPO MEDICO
				else if(usuario.getIdTipoUsuario() == 3){
					//Main.mostraTelaInicialMedico();
				}
								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Login ou Senha inválidos", 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
		
	@FXML
	public void linkCadastrar(){		
		Main.mostraTelaCadastro();
	}

	public void setMain(Main main) {
	}
			
}
