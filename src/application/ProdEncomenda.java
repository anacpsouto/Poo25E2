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
	/**
	 * @param idProduto
	 * @param quantidade
	 */
	public ProdEncomenda(int idProduto, int quantidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
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
	@Override
	public String toString() {
		return "ProdEncomenda [idProduto=" + idProduto + ", quantidade=" + quantidade + "]";
	}
    
    

}
