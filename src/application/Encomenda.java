package application;
import java.util.ArrayList;
/**
 * Classe que representa uma encomenda feita por um cliente a um agricultor.
 * Gerencia produtos, estados do ciclo de entrega, pagamento e valor total.
 */
public class Encomenda {
    private String data;
    private ArrayList<ProdEncomenda> listaProdEncomenda;
    private EstadoEncomenda estado;
    private Agricultor agricultor;
    private Cliente cliente;
    private double valorTotal;
    private String metodoPagamento;
    private boolean pago;
    /**
	 * @param data
	 * @param listaProdEncomenda
	 * @param estado
	 * @param agricultor
	 * @param cliente
	 * @param valorTotal
	 * @param metodoPagamento
	 * @param pago
	 */
	public Encomenda(String data, ArrayList<ProdEncomenda> listaProdEncomenda, EstadoEncomenda estado,
			Agricultor agricultor, Cliente cliente, double valorTotal, String metodoPagamento, boolean pago) {
		this.data = data;
		this.listaProdEncomenda = listaProdEncomenda;
		this.estado = estado;
		this.agricultor = agricultor;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.metodoPagamento = metodoPagamento;
		this.pago = pago;
	}

	// Getters e setters essenciais

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<ProdEncomenda> getListaProdEncomenda() {
        return listaProdEncomenda;
    }

    public EstadoEncomenda getEstado() {
        return estado;
    }
    
    public boolean isPago() {
        return pago;
       }
    
    public void confirmarPagamento() {
        if (this.pago = true) {
        System.out.println("Pagamento confirmado! A encomenda está agora em preparação.");
        }
      } 
    public void avancarEstado{
    	estado = System.out.println("Entregue");
    	}
    
    public Agricultor getAgricultor() {
        return agricultor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void adicionarProduto(ProdEncomenda prod) {
        listaProdEncomenda.add(prod);
        calcularValorTotal();
    }

    /**
     * Remove um produto pelo seu ID e recalcula o valor total.
     *
     * @param idProd ID do produto a remover.
     */
    public void removerProduto(int idProd) {
        ProdEncomenda p;
		listaProdEncomenda.remove(p.getIdProduto() == idProd);
        calcularValorTotal();
    }

    /**
     * Calcula o valor total da encomenda, somando (preço unitário × quantidade)
     * para cada item em listaProdEncomenda.
     */
    public void calcularValorTotal() {
        this.valorTotal = 0.0;
        for (ProdEncomenda p : listaProdEncomenda) {
            this.valorTotal += p.getPreco() * p.getQuantidade();
        }
    }

    @Override
    public String toString() {
        return "Encomenda{" +
               "data='" + data + '\'' +
               ", cliente='" + cliente.getNome() + '\'' +
               ", agricultor='" + agricultor.getNome() + '\'' +
               ", estado=" + estado +
               ", valorTotal=" + valorTotal + "€" +
               ", pago=" + pago +
               '}';
    }
}
