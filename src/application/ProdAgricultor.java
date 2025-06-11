package application;

/**
 * Representa um produto associado a um agricultor, com preço e stock próprios.
 */
public class ProdAgricultor {
	private Produto produto;
	private Double preco;
	private int stock;
	/**
	 * 	 * Construtor completo.
	 * @param produto Produto de origem
	 * @param preco Preço atribuído pelo agricultor
	 * @param stock Quantidade disponível em stock
	 */
	public ProdAgricultor(Produto produto, Double preco, int stock) {
		this.produto = produto;
		this.preco = preco;
		this.stock = stock;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "\nProduto: " + produto.getNome() + "\nPreço: " + preco + "€" + "\nStock: " + stock;
	}
}
