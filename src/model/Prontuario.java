package model;

import java.util.ArrayList;

public class Prontuario {
	private int id;
	private Paciente paciente;
	private String pressaoArterial;
	private boolean alergia;
	private boolean limitacao;
	private boolean medicamento;
	private boolean hipertenso;
	private boolean riscoMedico;
	private ArrayList<Medicamento> listMedicamentos;
	private ArrayList<Consulta> historicoConsultas;
	private ArrayList<String> listAlergia;
	
	
	public Prontuario(Paciente paciente, boolean alergia, boolean limitacao, boolean medicamento, boolean hipertenso,
			boolean riscoMedico){
		this.paciente = paciente;
		this.alergia = alergia;
		this.limitacao = limitacao;
		this.medicamento = medicamento;
		this.hipertenso = hipertenso;
		this.riscoMedico = riscoMedico;
	}
	
	public Prontuario(){
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public boolean isRiscoMedico(){
		return this.riscoMedico;
	}
	
	public void setRiscoMedico(boolean riscoMedico){
		this.riscoMedico = riscoMedico;
	}
	
	public boolean isHipertenso(){
		return this.hipertenso;
	}
	
	public void setHipertenso(boolean hipertenso){
		this.hipertenso = hipertenso;
	}
	
	public void setPressao(String pressao){
		this.pressaoArterial = pressao;
	}
	
	public String getPresao(){
		return this.pressaoArterial;
	}
	
	public void setPaciente(Paciente paciente){
		this.paciente = paciente;
	}
	
	public Paciente getPaciente(){
		return this.paciente;
	}

	public boolean isAlergia() {
		return alergia;
	}

	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
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
	
	public void addAlergia(String alergia){
		if(this.listAlergia == null){
			this.listAlergia = new ArrayList<String>();
		}
		
		if(isAlergia()){
			this.listAlergia.add(alergia);
		}
	}
	
	public void addConsulta(Consulta consulta){
		if(this.historicoConsultas == null){
			this.historicoConsultas = new ArrayList<Consulta>();
		}
		
		this.historicoConsultas.add(consulta);
	}
	
	
}
