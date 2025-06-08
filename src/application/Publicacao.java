package application;

/**
 * Representa uma publicação sobre técnicas de cultivo sustentável,
 * criada por um agricultor.
 */
public class Publicacao {
	private String conteudo;
	private Categoria categoria;

	/**
	 * Construtor da classe Publicacao.
	 * @param conteudo Texto da publicação.
	 * @param categoria Categoria da publicação (ex: compostagem, adubação, etc.).
	 */
	public Publicacao(String conteudo, Categoria categoria) {
		this.conteudo = conteudo;
		this.categoria = categoria;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "[" + categoria + "] " + conteudo;
	}
}
