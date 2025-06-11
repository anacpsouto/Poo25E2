/**
 * 
 */
package application;

import java.util.ArrayList;

/**
 * 
 */
public class Agricultor extends Utilizador {
	private String localRetirada;
	private ArrayList<Integer> avaliacoes;
	private ArrayList<ProdAgricultor> listaProdAgricultor;
	private ArrayList<Publicacao> publicacoes;
	private ArrayList<Encomenda> encomendas;

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

	public boolean produtoJaExiste(int produtoId) {
		for (ProdAgricultor prodAgricultor : listaProdAgricultor) {
			if (prodAgricultor.getProduto().getIdProduto() == produtoId) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Calcula a média das avaliações do agricultor
	 * @return média das avaliações ou 0 se não houver avaliações
	 */
	public double calcularMediaAvaliacoes() {
	    if (avaliacoes == null || avaliacoes.isEmpty()) {
	        return 0.0;
	    }
	    
	    double soma = 0.0;
	    for (Integer nota : avaliacoes) {
	        soma += nota;
	    }
	    return soma / avaliacoes.size();
	}

	@Override
	public String toString() {		

		StringBuilder sb = new StringBuilder();
		sb.append("\n=== AGRICULTOR ===\n");
		sb.append("Nome: ").append(getNome()).append("\n");
		sb.append("Email: ").append(getEmail()).append("\n");
		sb.append("Local de Retirada: ").append(localRetirada).append("\n");
		sb.append(String.format("Avaliação Média: %.1f/5.0 (%d avaliações)%n", 
	            calcularMediaAvaliacoes(), avaliacoes.size()));

		sb.append("\n=== PRODUTOS CADASTRADOS ===\n");
		if (listaProdAgricultor.isEmpty()) {
			sb.append("Nenhum produto cadastrado.\n");
		} else {
			for (ProdAgricultor prod : listaProdAgricultor) {
				sb.append("- ").append(prod.getProduto().getNome()).append(" | Preço: ").append(prod.getPreco())
						.append("€/").append(prod.getProduto().getUnMedida()).append(" | Stock: ")
						.append(prod.getStock()).append("\n");
			}
		}

		sb.append("\n=== PUBLICACOES ===\n");
		if (publicacoes.isEmpty()) {
			sb.append("Nenhuma publicação feita.\n");
		} else {
			publicacoes.forEach(pub -> sb.append("- ").append(pub).append("\n"));
		}
		/*
		 * sb.append("\n=== ENCOMENDAS ===\n");
		 * sb.append("Total: ").append(encomendas.size()).append(" encomendas\n");
		 */

		return sb.toString();
	}

}
