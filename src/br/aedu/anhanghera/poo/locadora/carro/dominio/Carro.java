package br.aedu.anhanghera.poo.locadora.carro.dominio;

public class Carro {

	private int id;
	private String nome;
	private String modelo;

	public Carro() {
	}

	public Carro(String nome, String modelo) {
		super();
		this.nome = nome;
		this.modelo = modelo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
