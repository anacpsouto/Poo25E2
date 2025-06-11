/**
 * 
 */
package application;

/**
 * 
 */
public class Prod_Encomenda {

	private int idProd;
	private int quantidade;

	public Prod_Encomenda(int idProd, int quantidade) {
		this.idProd = idProd;
		this.quantidade = quantidade;
	}

	public int getIdProd() {
		return idProd;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ID Produto: " + idProd + ", Quantidade: " + quantidade;
	}

}
