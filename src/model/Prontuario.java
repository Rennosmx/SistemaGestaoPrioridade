package model;

import java.util.ArrayList;
import java.util.Date;

public class Prontuario {
	private String nome;
	private Date dataNascimento;
	private Endereco endereco;
	private String RG;
	private String CPF;
	private String estadoCivil;
	private String telefone;
	private boolean alergia;
	private String sexo;
	private String email;
	private boolean limitacao;
	private ArrayList<Medicamento> listMedicamentos;
	private boolean medicamento;
	
	public Prontuario(String nome, String rg, String cpf, String estadoCivil, String telefone, String sexo, String email, Date dataNascimento, Endereco endereco, boolean alergia, boolean limitacao, boolean medicamento){
		this.nome = nome;
		this.RG = rg;
		this.CPF = cpf;
		this.estadoCivil = estadoCivil;
		this.telefone = telefone;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.alergia = alergia;
		this.limitacao = limitacao;
		this.medicamento = medicamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isAlergia() {
		return alergia;
	}

	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLimitacao() {
		return limitacao;
	}

	public void setLimitacao(boolean limitacao) {
		this.limitacao = limitacao;
	}

	public boolean isMedicamento() {
		return medicamento;
	}

	public void setMedicamento(boolean medicamento) {
		this.medicamento = medicamento;
	}
	
	public void addMedicamento(Medicamento medicamento){
		if(this.listMedicamentos == null){
			this.listMedicamentos = new ArrayList<Medicamento>();
		}
		
		if(isMedicamento()){
			this.listMedicamentos.add(medicamento);
		}
	}
	
	
}
