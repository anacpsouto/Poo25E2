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
	private ArrayList<String> historicoCompras;
	
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
		this.historicoCompras = new ArrayList<>();
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

	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}
	
	/**
	 * Método para editar o perfil do cliente.
	 * Permite atualização seletiva dos dados pessoais se os valores forem válidos.
	 * 
	 * @param novoNome Novo nome
	 * @param novoEmail Novo email (deve conter "@")
	 * @param novaPassword Nova senha (mínimo 8 caracteres)
	 * @param novaMorada Nova morada
	 * @param novoTelemovel Novo número de telemóvel
	 * @param novoNif Novo NIF
	 */
	public void editarPerfil(String novoNome, String novoEmail, String novaPassword, String novaMorada, Integer novoTelemovel, Integer novoNif) {
	    if (novoNome != null && !novoNome.isEmpty()) {
	        this.setNome(novoNome);
	    }
	    if (novoEmail != null && novoEmail.contains("@")) {
	        this.setEmail(novoEmail);
	    }
	    if (novaPassword != null && novaPassword.length() >= 8) {
	        this.setPassword(novaPassword);
	    }
	    if (novaMorada != null && !novaMorada.isEmpty()) {
	        this.morada = novaMorada;
	    }
	    if (novoTelemovel != null) {
	        this.telemovel = novoTelemovel;
	    }
	    if (novoNif != null) {
	        this.nif = novoNif;
	    }
	}

	
/**
 * Método para adicionar uma compra ao hitórico do cliente 
 * @param compra
 */
	 public void adicionarCompraAoHistorico(String compra) {
	     historicoCompras.add(compra);
	 }
	 
	 /**
		 * Retorna a lista de compras realizadas pelo cliente.
		 * 
		 * @return Histórico de compras
		 */

	    public ArrayList<String> getHistoricoCompras() {
	        return historicoCompras;
	    }


}//Fim class