package model;

import java.util.Date;

public class Paciente extends Usuario{
	private Prontuario prontuario;
	
	public Paciente(String login, String senha, Date dataNascimento, String rg, String cpf, String sexo, String telefone, String email){
		super(login, senha, dataNascimento, rg, cpf, sexo, telefone, email);
		
	}
	
	public void addProntuario(Prontuario prontuario){
		this.prontuario = prontuario;
	}
	
	public Prontuario getProntuario(){
		return this.prontuario;
	}
}
