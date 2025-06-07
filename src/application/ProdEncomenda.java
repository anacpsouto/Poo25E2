/**
 * 
 */
package application;

/**
 * 
 */
public class ProdEncomenda {
    private int idProduto;
    private int quantidade;
    private double precoUnitario;
	/**
	 * @param idProduto
	 * @param quantidade
	 */
	public ProdEncomenda(int idProduto, int quantidade, double precoUnitario) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}
	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	/**
	 * @return the idProduto
	 */
	public int getIdProduto() {
		return idProduto;
	}
	/**
	 * @return the precoUnitario
	 */
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public double getSubtotal() {
		return quantidade * precoUnitario;
		}
	@Override
	public String toString() {
		return "ProdEncomenda [idProduto=" + idProduto + ", quantidade=" + quantidade + "]";
	}
    
    

}
