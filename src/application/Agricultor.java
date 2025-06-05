/**
 * 
 */
package application;

import java.util.ArrayList;

/**
 * 
 */
public class Agricultor extends Utilizador{
	private String localRetirada;
	private ArrayList<Integer>avaliacoes;
	private ArrayList<ProdAgricultor>listaProdAgricultor;
	private ArrayList<Publicacao>publicacoes;
	private ArrayList<Encomenda>encomendas;
	/**
	 * @param nome
	 * @param email
	 * @param password
	 * @param localRetirada
	 */
	public Agricultor(String nome, String email, String password, String localRetirada) {
		super(nome, email, password);
		this.localRetirada = localRetirada;
		avaliacoes = new ArrayList<>();
		listaProdAgricultor = new ArrayList<>();
		publicacoes = new ArrayList<>();
		encomendas = new ArrayList<>();
	}
	/**
	 * @return the localRetirada
	 */
	public String getLocalRetirada() {
		return localRetirada;
	}
	/**
	 * @param localRetirada the localRetirada to set
	 */
	public void setLocalRetirada(String localRetirada) {
		this.localRetirada = localRetirada;
	}
	/**
	 * @return the avaliacoes
	 */
	public ArrayList<Integer> getAvaliacoes() {
		return avaliacoes;
	}
	
	/**
	 * @return the listaProdAgricultor
	 */
	public ArrayList<ProdAgricultor> getListaProdAgricultor() {
		return listaProdAgricultor;
	}
	
	/**
	 * @return the publicacoes
	 */
	public ArrayList<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	/**
	 * @return the encomendas
	 */
	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}
	
}
