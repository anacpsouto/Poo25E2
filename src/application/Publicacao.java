package application;

/**
 * Representa uma publicação educativa feita por um agricultor,
 * com uma categoria associada.
 */
public class Publicacao {
    private String conteudo;
    private Categoria categoria;

    /**
     * Construtor da publicação.
     * @param conteudo Texto informativo.
     * @param categoria Categoria do conteúdo.
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
