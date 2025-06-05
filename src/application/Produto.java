/**
 * 
 */
package application;

/**
 * 
 */
public class Produto {
	private int idProduto;
	private String nome;
	private String unMedida;
	private Categoria categoria;
	
	/**
	 * @param idProduto
	 * @param nome
	 * @param unMedida
	 * @param categoria
	 */
	public Produto(int idProduto, String nome, String unMedida, Categoria categoria) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.unMedida = unMedida;
		this.categoria = categoria;
	
	}

	/**
	 * @return the idProduto
	 */
	public int getIdProduto() {
		return idProduto;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the unMedida
	 */
	public String getUnMedida() {
		return unMedida;
	}

	/**
	 * @param unMedida the unMedida to set
	 */
	public void setUnMedida(String unMedida) {
		this.unMedida = unMedida;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", unMedida=" + unMedida + ", categoria="
				+ categoria + "]";
	}
	
	

}
