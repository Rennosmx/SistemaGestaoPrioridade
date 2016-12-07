package model;

import java.util.Date;

public class Paciente extends Usuario{
	private int id_paciente;
	private int id_prontuario;
	private String estadoCivil;
	public Paciente(String login, String senha, String nome, Date dataNascimento,
			String rg, String cpf, String sexo, String telefone, String email,
			int id_paciente, String estadoCivil){
		super(login, senha, nome, dataNascimento, rg, cpf, sexo, telefone, email);
		this.id_paciente = id_paciente;
		this.estadoCivil = estadoCivil;
	}
	
	public Paciente(){
		super();
	}
	
	public void setEstadoCivil(String estadoCivil){
		this.estadoCivil = estadoCivil;
	}
	
	public String getEstadoCivil(){
		return this.estadoCivil;
	}
	
	public void setIdPaciente(int id_paciente){
		this.id_paciente = id_paciente;
	}
	
	public int getIdPaciente(){
		return this.id_paciente;
	}
	
	public void setProntuario(int id_prontuario){
		this.id_prontuario = id_prontuario;
	}
	
	public int getIdProntuario(){
		return this.id_prontuario;
	}
}
