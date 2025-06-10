/**
 * 
 */
package application;

import java.util.ArrayList;

/**
 * Classe que representa um Cliente do sistema.
 * Herda de Utilizador e adiciona informações como morada, NIF e histórico de compras.
 */

public class Cliente extends Utilizador{
	private String morada;
	private int telemovel;
	private int nif;
	private ArrayList<Encomenda> encomendas;

	/**
	 * Construtor da classe Cliente.
	 * 
	 * @param nome Nome do cliente
	 * @param email Email do cliente
	 * @param password Senha do cliente
	 * @param morada Endereço do cliente
	 * @param telemovel Número de telemóvel
	 * @param nif Número de identificação fiscal
	 */
	public Cliente(String nome, String email, String password, String morada, int telemovel, int nif) {
		super(nome, email, password);
		this.morada = morada;
		this.telemovel = telemovel;
		this.nif = nif;
		this.encomendas = new ArrayList<>();
	}


	public String getMorada() {
		return morada;
	}


	public void setMorada(String morada) {
		this.morada = morada;
	}


	public int getTelemovel() {
		return telemovel;
	}


	public void setTelemovel(int telemovel) {
		this.telemovel = telemovel;
	}


	
	public int getNif() {
		return nif;
	}

	
	public void setNif(int nif) {
		this.nif = nif;
	}
	
	
	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}

	
public void incluirEncomendaCliente(Encomenda  encomenda) {
	this.encomendas.add(encomenda);
	
}

@Override
public String toString() {
	return "Cliente [morada=" + morada + ", telemovel=" + telemovel + ", nif=" + nif + "]";
}

}//Fim class