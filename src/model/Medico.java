package model;

import java.util.Date;

public class Medico extends Usuario{
	private int id_medico;
	private String CRM;
	private String especialidade;
	public Medico(String login, String senha, String nome, Date dataNascimento, String rg, String cpf, String sexo, String telefone, String CRM, String especialidade, String email){
		super(login, senha, nome, dataNascimento, rg, cpf, sexo, telefone, email);
		this.CRM = CRM;
		this.especialidade = especialidade;
	}
	
	public Medico(){
		super();
	}
	
	public void setCRM(String CRM){
		this.CRM = CRM;
	}
	
	public String getCRM(){
		return this.CRM;
	}
	
	public void setEspecialidade(String especialidade){
		this.especialidade = especialidade;
	}
	
	public String getEspecialidade(){
		return this.especialidade;
	}
	
	public void setIdMedico(int id){
		this.id_medico = id;
	}
	
	public int getIdMedico(){
		return this.id_medico;
	}
}
