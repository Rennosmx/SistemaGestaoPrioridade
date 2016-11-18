package model;

public class Medicamento {
	private String nome;
	private String indicacoes;
	
	public Medicamento(String nome, String indicacoes){
		this.nome = nome;
		this.indicacoes = indicacoes;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setIndicacoes(String inidicacoes){
		this.indicacoes = inidicacoes;
	}

}
