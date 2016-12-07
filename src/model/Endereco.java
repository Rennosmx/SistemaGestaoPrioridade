package model;

public class Endereco {
	private int id;
	private String rua;
	private String cep;
	private String bairro;
	private String numero;
	private int id_usuario;
	
	public Endereco(String rua, String cep, String bairro, String numero, int id_usuario){
		this.rua = rua;
		this.cep = cep;
		this.bairro = bairro;
		this.numero = numero;
		this.id_usuario = id_usuario;
	}
	
	public Endereco(){
		
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getIdUsuario(){
		return this.id_usuario;
	}
	
	public void setIdUsuario(int id){
		this.id_usuario = id;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
