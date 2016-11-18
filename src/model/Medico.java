package model;

import java.util.Date;

public class Medico extends Usuario{
	private String CRM;
	private String especialidade;
	public Medico(String login, String senha, Date dataNascimento, String rg, String cpf, String sexo, String telefone, String CRM, String especialidade){
		super(login, senha, dataNascimento, rg, cpf, sexo, telefone);
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
