package model;

import java.util.Date;

public class Consulta {
	private Paciente paciente;
	private Medico medico;
	private Date dataConsulta;
	private String motivoConsulta;
	private String laudoMedico;
	private boolean realizada;
	
	public Consulta(Paciente paciente, Medico medico, Date dataConsulta){
		this.paciente = paciente;
		this.medico = medico;
		this.dataConsulta = dataConsulta;
		this.realizada = false;
	}
	public Consulta(){
		
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public String getLaudoMedico() {
		return laudoMedico;
	}
	public void setLaudoMedico(String laudoMedico) {
		this.laudoMedico = laudoMedico;
	}
	public boolean isRealizada() {
		return realizada;
	}
	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	
	
	
}
