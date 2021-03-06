package model;

import java.util.Date;

public class Recepcionista extends Usuario{
	private String codigo;
	private int id_recepcionista;
	public Recepcionista(String login, String senha, String nome, Date dataNascimento, String rg, String cpf, String sexo, String telefone, String email, String codigo){
		super(login, senha, nome,dataNascimento, rg, cpf, sexo, telefone, email);
		this.codigo = codigo;
	}
	
	public Recepcionista(){
		super();
	}
	
	public void setIdRecepcionista(int id){
		this.id_recepcionista = id;
	}
	
	public int getIdRecepcionista(){
		return this.id_recepcionista;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}
