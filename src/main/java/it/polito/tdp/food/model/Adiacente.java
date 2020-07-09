package it.polito.tdp.food.model;

public class Adiacente {
	private String nomeP;
	private Double peso;
	public Adiacente(String nomeP, Double peso) {
		super();
		this.nomeP = nomeP;
		this.peso = peso;
	}
	public String getNomeP() {
		return nomeP;
	}
	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
}
