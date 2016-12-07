package model;

public class Medicamento {
	private String nome;
	private String indicacoes;
	private String compostos;
	private String principioAtivo;
	
	public Medicamento(String nome, String indicacoes, String principioAtivo, String compostos){
		this.nome = nome;
		this.indicacoes = indicacoes;
		this.principioAtivo = principioAtivo;
		this.compostos = compostos;
	}
	
	public Medicamento(){
		
	}
	
	public void setPrincipioAtivo(String principioAtivo){
		this.principioAtivo = principioAtivo;
	}
	
	public String getPrincipioAtivo(){
		return this.principioAtivo;
	}
	
	public void setCompostos(String compostos){
		this.compostos = compostos;
	}
	
	public String getCompostos(){
		return this.compostos;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setIndicacoes(String inidicacoes){
		this.indicacoes = inidicacoes;
	}
	
	public String getIndicaoes(){
		return this.indicacoes;
	}

}
