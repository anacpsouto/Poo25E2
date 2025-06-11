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
	 * @param nif the nif to set
	 */
	public void setNif(int nif) {
		this.nif = nif;
	}


	/**
	 * @return the encomendas
	 */
	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("\n=== CLIENTE ===\n");
	    sb.append("Nome: ").append(getNome()).append("\n");
	    sb.append("Email: ").append(getEmail()).append("\n");
	    sb.append("Morada: ").append(morada).append("\n");
	    sb.append("Telemóvel: ").append(telemovel).append("\n");
	    sb.append("NIF: ").append(nif).append("\n");

	    sb.append("\n=== ENCOMENDAS REALIZADAS ===\n");
	    if (encomendas.isEmpty()) {
	        sb.append("Nenhuma encomenda realizada.\n");
	    } else {
	        for (Encomenda e : encomendas) {
	            sb.append("- Encomenda com o agricultor: ").append(e.getAgricultor().getNome())
	              .append(" | Data: ").append(e.getData())
	              .append(" | Estado: ").append(e.getEstado())
	              .append(" | Produtos: ").append(e.getListaProdEncomenda().size()).append("\n");
	        }
	    }

	    return sb.toString();
	}

}
