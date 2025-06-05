/**
 * 
 */
package application;

/**
 * 
 */
public class ProdAgricultor {
	private Produto produto;
	private Double preco;
	private int stock;
	
	
	/**
	 * @param produto
	 * @param preco
	 * @param stock
	 */
	
	public ProdAgricultor(Produto produto, Double preco, int stock) {
		this.produto = produto;
		this.preco = preco;
		this.stock = stock;
	}


	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}


	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}


	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}


	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}


	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
