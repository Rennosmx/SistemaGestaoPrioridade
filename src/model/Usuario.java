package model;

import java.util.Date;

public class Usuario {

	private int id;	
	private String login;
	private String senha;
	private Date dataNascimento;
	private String rg;
	private String cpf;
	private String sexo;
	private String telefone;
	private String email;
	
	public Usuario(String login, String senha, Date dataNascimento, String rg, String cpf, String sexo, String telefone, String email){
		this.login = login;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
