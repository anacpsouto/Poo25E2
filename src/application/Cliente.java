/**
 * 
 */
package application;

import java.util.ArrayList;

/**
 * 
 */
public class Cliente extends Utilizador{
	private String morada;
	private int telemovel;
	private int nif;
	private ArrayList<Encomenda>encomendas;
	

	/**
	 * @param nome
	 * @param email
	 * @param password
	 * @param morada
	 * @param telemovel
	 * @param nif
	 */
	public Cliente(String nome, String email, String password, String morada, int telemovel, int nif) {
		super(nome, email, password);
		this.morada = morada;
		this.telemovel = telemovel;
		this.nif = nif;
		encomendas = new ArrayList<>();
	}


	/**
	 * @return the morada
	 */
	public String getMorada() {
		return morada;
	}


	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada) {
		this.morada = morada;
	}


	/**
	 * @return the telemovel
	 */
	public int getTelemovel() {
		return telemovel;
	}


	/**
	 * @param telemovel the telemovel to set
	 */
	public void setTelemovel(int telemovel) {
		this.telemovel = telemovel;
	}


	/**
	 * @return the nif
	 */
	public int getNif() {
		return nif;
	}

	/**
	 * @return the encomendas
	 */
	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}
	

}
