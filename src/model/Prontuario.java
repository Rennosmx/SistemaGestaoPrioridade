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
}
