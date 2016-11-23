package model;

import java.util.Date;

public class Recepcionista extends Usuario{
	private String codigo;
	public Recepcionista(String login, String senha, Date dataNascimento, String rg, String cpf, String sexo, String telefone, String email, String codigo){
		super(login, senha, dataNascimento, rg, cpf, sexo, telefone, email);
		this.codigo = codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}
