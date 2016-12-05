package model;

import java.util.Date;

public class Medico extends Usuario{
	private String CRM;
	private String especialidade;
	public Medico(String login, String senha, String nome, Date dataNascimento, String rg, String cpf, String sexo, String telefone, String CRM, String especialidade, String email){
		super(login, senha, nome, dataNascimento, rg, cpf, sexo, telefone, email);
		this.CRM = CRM;
		this.especialidade = especialidade;
	}
	
	public String getCRM(){
		return this.CRM;
	}
	
	public String getEspecialidade(){
		return this.especialidade;
	}
}
