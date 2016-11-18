package model;

import java.util.Date;

public class Recepcionista extends Usuario{
	public Recepcionista(String login, String senha, Date dataNascimento, String rg, String cpf, String sexo, String telefone){
		super(login, senha, dataNascimento, rg, cpf, sexo, telefone);
	}
}
