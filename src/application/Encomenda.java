/**
 * 
 */
package application;

import java.util.ArrayList;

/**
 * 
 */
public class Encomenda {
	private String data;
	private ArrayList<Prod_Encomenda> listaProdEncomenda;
	private Agricultor agricultor;
	private Cliente cliente;
	private EstadoEncomenda estado;

	public Encomenda(String data, Agricultor agricultor, Cliente cliente) {
		this.data = data;
		this.agricultor = agricultor;
		this.cliente = cliente;
		this.estado = EstadoEncomenda.EM_PREPARACAO;
		listaProdEncomenda = new ArrayList<>();
	}

	public String getData() {
		return data;
	}

	public ArrayList<Prod_Encomenda> getListaProdEncomenda() {
		return listaProdEncomenda;
	}

	public Agricultor getAgricultor() {
		return agricultor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public EstadoEncomenda getEstado() {
		return estado;
	}

	public void setEstado(EstadoEncomenda estado) {
		this.estado = estado;
	}

	public void incluirProdEncomenda(Prod_Encomenda prodEncomenda) {
		this.listaProdEncomenda.add(prodEncomenda);
	}
	
	

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("\nEncomenda do cliente: ").append(cliente.getNome())
	      .append(" | Agricultor: ").append(agricultor.getNome())
	      .append(" | Estado: ").append(estado)
	      .append(" | Data: ").append(data)
	      .append("\nProdutos:");

	    double total = 0.0;

	    for (Prod_Encomenda pe : listaProdEncomenda) {
	        int id = pe.getIdProd();
	        int quantidade = pe.getQuantidade();

	        // Procurar o produto na lista do agricultor
	        for (ProdAgricultor pa : agricultor.getListaProdAgricultor()) {
	            if (pa.getProduto().getIdProduto() == id) {
	                String nome = pa.getProduto().getNome();
	                double preco = pa.getPreco();
	                double subtotal = preco * quantidade;
	                total += subtotal;

	                sb.append("\n- ID: ").append(id)
	                  .append(" | Nome: ").append(nome)
	                  .append(" | Quantidade: ").append(quantidade)
	                  .append(" | Preço unidade: ").append(preco)
	                  .append(" | Subtotal: ").append(String.format("%.2f", subtotal));
	                break;
	            }
	        }
	    }

	    sb.append("\nValor total da encomenda: ").append(String.format("%.2f", total)).append(" €");
	    return sb.toString();
	}
}
