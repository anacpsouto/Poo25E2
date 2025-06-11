/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */
public class GereSistema {
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Produto> catalogo;
	// declaração do padrão de senha usado:
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_]).{8,}$";
	private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	// compilação do padrão acima.

	/**
	 *
	 */
	public GereSistema() {
		utilizadores = new ArrayList<>();
		catalogo = new ArrayList<>();
	}

	public boolean validacaoEmail(String email) {
		Pattern pattern = Pattern.compile(REGEX_EMAIL);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			System.out.println("Email inválido!");
		}
		return matcher.matches();
	}

	public boolean validacaoSenha(String password) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			System.out.println("\nA sua senha precisa conter:\n" + "-Pelo menos 8 caractéres.\n"
					+ "-Pelo menos 1 letra maiúscula.\n" + "-Pelo menos 1 letra minúscula.\n" + "-Pelo menos 1 número\n"
					+ "-Pelo menos 1 caractere especial (@#$%&)\n");
		}

		return matcher.matches();
	}

	public Utilizador fazerLogin(String email, String password) {
		boolean encontrou = false;
		for (Utilizador utilizador : utilizadores) {
			if (utilizador.getEmail().equals(email)) {
				encontrou = true;
				if (utilizador.getPassword().equals(password)) {
					System.out.println(utilizador.getClass().getSimpleName());
					return utilizador;
				}
			}
		}
		/*
		 * if(encontrou) { System.out.println("E-mail ou senha incorretos! \n"); return
		 * null; }
		 */

		System.out.println("Utilizador não encontrado. \n");
		return null;

	}

	public void inserirUtilizador(Utilizador newUtilizador) {
		utilizadores.add(newUtilizador);
	}

	public void adicionarProduto(Produto p) {
		catalogo.add(p);
	}

	public void removerProduto(int idProd) {
		catalogo.removeIf(p -> p.getIdProduto() == idProd);
	}

	public Produto procurarProdutoNoCatalogo(String nomeProduto) {
		for (Produto p : catalogo) {
			if (p.getNome().equalsIgnoreCase(nomeProduto)) {
				return p;
			}
		}
		return null;
	}

	public void registarProdAgricultor(String email, ProdAgricultor prodAgricultor) {
		for (Utilizador u : utilizadores) {
			if (u.getEmail().equalsIgnoreCase(email) && u instanceof Agricultor) {
				Agricultor a = (Agricultor) u;
				a.getListaProdAgricultor().add(prodAgricultor);
				break;
			}
		}
	}

	public void adicionarStock(String email, String nomeProduto, int quantidade) {
		for (Utilizador u : utilizadores) {
			if (u.getEmail().equalsIgnoreCase(email) && u instanceof Agricultor) {
				Agricultor a = (Agricultor) u;
				for (ProdAgricultor pa : a.getListaProdAgricultor()) {
					if (pa.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
						int novoStock = pa.getStock() + quantidade;
						pa.setStock(novoStock);

						break;
					}

				}

			}
		}

	}

	public void removerProdutoDoAgricultor(String email, String nomeProduto) {
		for (Utilizador u : utilizadores) {
			if (u.getEmail().equalsIgnoreCase(email) && u instanceof Agricultor) {
				Agricultor a = (Agricultor) u;
				a.getListaProdAgricultor().removeIf(pa -> pa.getProduto().getNome().equalsIgnoreCase(nomeProduto));
			}
		}
	}

	public void avaliar(String email, int nota) {
		for (Utilizador u : utilizadores) {
			if (u.getEmail().equalsIgnoreCase(email) && u instanceof Agricultor) {
				Agricultor a = (Agricultor) u;
				a.getAvaliacoes().add(nota);
				break;
			}
		}
	}

	public void mostrarCatalogo() {
	    System.out.println("\n=== CATÁLOGO DE PRODUTOS DISPONÍVEIS ===");

	    for (Utilizador u : utilizadores) {
	        if (u.getClass().getSimpleName().equals("Agricultor")) {
	            Agricultor a = (Agricultor) u;

				/*
				 * for (ProdAgricultor pa : a.getListaProdAgricultor()) { if (pa.getStock() > 0)
				 * { System.out.println("Agricultor: " + a.getNome() + " | Produto: " +
				 * pa.getProduto().getNome() + " | Preço: " + pa.getPreco() + " | Stock: " +
				 * pa.getStock()); } }
				 */
	            
	            System.out.println(a);
	        }
	    }
	}
	

	public void imprimeTodosOsProdutosDoCatalogoGeral() {
		System.out.println("\n=== CATÁLOGO GERAL DE PRODUTOS ===");		
		for(Produto prodGeral : catalogo) {
			System.out.println(prodGeral);
		}
		System.out.println();
	}

	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void retornaIdsIndisponiveis() {
		System.out.println("Ids já utilizados em outros produtos: ");
		for (Produto p : catalogo) {
			System.out.println(" Nome do Produto: " + p.getNome() + "Id do Produto:" + p.getIdProduto());
		}
	}
	
	public void retornaListaDeProdAgricultor(Agricultor agricultor) {
		System.out.println("\n=== SUA LISTA DE PRODUTOS CADASTRADOS (COMO PRODUTOR)===");
		System.out.println();

	    boolean haProdCadastrado = false;
	    if (! agricultor.getListaProdAgricultor().isEmpty()) {
	    	for (ProdAgricultor prodAgricultor: agricultor.getListaProdAgricultor()) {
		    	System.out.println(prodAgricultor);
		    }
	    	haProdCadastrado = true;
	    }else {
            System.out.println("\nAinda não possui produtos registados no seu catálogo de produtor agricola.");
        }
	    System.out.println();
	}

	public void verTodasPublicacoes() {
	    System.out.println("\n=== TODAS AS PUBLICAÇÕES ===");

	    boolean houveAlgumaPublicacao = false;

	    for (Utilizador u : utilizadores) {
	        if (u.getClass().getSimpleName().equals("Agricultor")) {
	            Agricultor a = (Agricultor) u;

	            if (!a.getPublicacoes().isEmpty()) {
	                System.out.println("\nPublicações de " + a.getNome() + ":");
	                for (Publicacao pub : a.getPublicacoes()) {
	                    System.out.println("- [" + pub.getCategoria() + "] " + pub.getConteudo());
	                }
	                houveAlgumaPublicacao = true;
	            } else {
	                System.out.println("\nO agricultor " + a.getNome() + " ainda não possui publicações.");
	            }
	        }
	    }

	    if (!houveAlgumaPublicacao) {
	        System.out.println("\nAinda não há nenhuma publicação no sistema.");
	    }
	}
	
	public void criarNovaPublicacao(Agricultor agricultor, Publicacao novaPublicacao ) {
				agricultor.getPublicacoes().add(novaPublicacao);
				
				System.out.println("\nPublicação criada com sucesso!");
			    System.out.println("[" + novaPublicacao.getCategoria() + "] " + " || " + novaPublicacao.getConteudo());

	}

	public void procurarAgricultorPorNome(String nome) {
        boolean encontrou = false;

        System.out.println("\n=== Agricultores com o nome " + nome + " ===");

        for (Utilizador u : utilizadores) {
            if (u.getClass().getSimpleName().equals("Agricultor") && u.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Nome: " + u.getNome() + " | Email: " + u.getEmail());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum agricultor encontrado com esse nome.");
        }
    }

	public void inicializarDadosTeste() {
		// Limpar listas existentes (opcional)
		// utilizadores.clear();
		// catalogo.clear();
		// publicacoes.clear();

		// Inserindo 5 agricultores com publicações
		Agricultor ag1 = new Agricultor("João Silva", "joao@gmail.com", "Senha123!", "Fazenda Sol Nascente");
		ag1.getAvaliacoes().addAll(List.of(4, 5, 4));
		ag1.getPublicacoes().add(new Publicacao("Como cultivar maçãs orgânicas", Categoria.FRUTA));
		ag1.getPublicacoes().add(new Publicacao("Técnicas de compostagem eficiente", Categoria.COMPOSTAGEM));
		ag1.getPublicacoes().add(new Publicacao("Controle natural de pragas", Categoria.ADUBACAO_ORGANICA));
		inserirUtilizador(ag1);

		Agricultor ag2 = new Agricultor("Maria Oliveira", "maria@gmail.com", "Senha123!", "Sítio Flor do Campo");
		ag2.getAvaliacoes().addAll(List.of(5, 5, 4, 3));
		ag2.getPublicacoes()
				.add(new Publicacao("Rotação de culturas para pequenas propriedades", Categoria.ROTACAO_DE_CULTURA));
		ag2.getPublicacoes().add(new Publicacao("Cultivo de hortaliças sem agrotóxicos", Categoria.HORTALICAS));
		ag2.getPublicacoes().add(new Publicacao("Armazenamento de grãos em pequena escala", Categoria.ARMAZENAMENTO));
		inserirUtilizador(ag2);

		Agricultor ag3 = new Agricultor("Carlos Santos", "carlos@gmail.com", "Senha123!", "Chácara Boa Esperança");
		ag3.getAvaliacoes().addAll(List.of(3, 4, 5));
		ag3.getPublicacoes().add(new Publicacao("Manejo integrado de pomares", Categoria.FRUTA));
		ag3.getPublicacoes().add(new Publicacao("Produção de mudas saudáveis", Categoria.HORTALICAS));
		ag3.getPublicacoes().add(new Publicacao("Uso de cobertura vegetal", Categoria.ADUBACAO_ORGANICA));
		inserirUtilizador(ag3);

		Agricultor ag4 = new Agricultor("Ana Pereira", "ana@gmail.com", "Senha123!", "Granja São Francisco");
		ag4.getAvaliacoes().addAll(List.of(5, 5));
		ag4.getPublicacoes().add(new Publicacao("Criação de abelhas para polinização", Categoria.PRODUTOS_APICOLAS));
		ag4.getPublicacoes().add(new Publicacao("Plantio consorciado de legumes", Categoria.LEGUMINOSAS));
		ag4.getPublicacoes().add(new Publicacao("Técnicas de irrigação econômica", Categoria.HORTALICAS));
		inserirUtilizador(ag4);

		Agricultor ag5 = new Agricultor("Pedro Costa", "pedro@gmail.com", "Senha123!", "Roça Verde Vida");
		ag5.getAvaliacoes().add(4);
		ag5.getPublicacoes()
				.add(new Publicacao("Cultivo de ervas aromáticas", Categoria.ERVAS_AROMATICAS_E_ESPECIARIAS));
		ag5.getPublicacoes().add(new Publicacao("Produção de farinha artesanal", Categoria.CEREAIS));
		ag5.getPublicacoes().add(new Publicacao("Manejo ecológico do solo", Categoria.ADUBACAO_ORGANICA));
		inserirUtilizador(ag5);

		// Inserindo 5 clientes (sem publicações, pois apenas agricultores publicam)
		Cliente cl1 = new Cliente("Luís Fernandes", "luis@gmail.com", "Senha123!", "Rua das Flores, 123", 912345678,
				123456789);
		inserirUtilizador(cl1);

		Cliente cl2 = new Cliente("Sofia Rodrigues", "sofia@gmail.com", "Senha123!", "Avenida Central, 456", 923456789,
				234567890);
		inserirUtilizador(cl2);

		Cliente cl3 = new Cliente("Miguel Alves", "miguel@gmail.com", "Senha123!", "Travessa da Fonte, 789", 934567890,
				345678901);
		inserirUtilizador(cl3);

		Cliente cl4 = new Cliente("Beatriz Sousa", "beatriz@gmail.com", "Senha123!", "Praça do Município, 10",
				945678901, 456789012);
		inserirUtilizador(cl4);

		Cliente cl5 = new Cliente("Tiago Martins", "tiago@gmail.com", "Senha123!", "Alameda dos Bosques, 25", 956789012,
				567890123);
		inserirUtilizador(cl5);

		// Criando e adicionando alguns produtos ao arrayList catalogo (de produtos)
		Produto p1 = new Produto(1, "Maçã", "kg", Categoria.FRUTA);
		catalogo.add(p1);
		Produto p2 = new Produto(2, "Batata", "kg", Categoria.RAIZES_E_TUBERCULOS);
		catalogo.add(p2);
		Produto p3 = new Produto(3, "Ovos", "dúzia", Categoria.OVOS);
		catalogo.add(p3);
		Produto p4 = new Produto(4, "Mel", "frasco", Categoria.PRODUTOS_APICOLAS);
		catalogo.add(p4);

		// Adicionando alguns produtos as listas de produtos vendidos por cada um dos
		// agricultores.
		// Agricultor ag1 vende os produtos: p1 e p2
		ag1.getListaProdAgricultor().add(new ProdAgricultor(p1, 1.20, 50));
		ag1.getListaProdAgricultor().add(new ProdAgricultor(p2, 0.80, 30));
		// Agricultor ag2 vende os produtos: p2 , p3 e p4
		ag2.getListaProdAgricultor().add(new ProdAgricultor(p2, 0.90, 25));
		ag2.getListaProdAgricultor().add(new ProdAgricultor(p3, 1.90, 10));
		ag2.getListaProdAgricultor().add(new ProdAgricultor(p4, 2.50, 5));
		// Agricultor ag3 vende os produtos: p1 e p3
		ag3.getListaProdAgricultor().add(new ProdAgricultor(p1, 1.70, 10));
		ag3.getListaProdAgricultor().add(new ProdAgricultor(p3, 2.00, 15));
		// Agricultor ag4 vende os produtos: p1, p3 e p4
		ag4.getListaProdAgricultor().add(new ProdAgricultor(p1, 0.50, 25));
		ag4.getListaProdAgricultor().add(new ProdAgricultor(p3, 2.00, 25));
		ag4.getListaProdAgricultor().add(new ProdAgricultor(p4, 2.00, 25));

		// ... outros produtos para outros agricultores
	}

}
