package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		GereSistema gereSistema = new GereSistema();
		gereSistema.inicializarDadosTeste();

		Scanner input = new Scanner(System.in);

		int opcaoEscolhida = -1;
		String email = "";
		String password;

		System.out.println("\n==== Sistema de Apoio a Pequenos Agricultores ====");
		do {
			System.out.println("-----------------------------------------");
			System.out.println("O que deseja fazer ? ");
			System.out.println("1) Fazer login");
			System.out.println("2) Criar um perfil");
			System.out.println("0) Sair da aplicacão");
			System.out.println("-----------------------------------------");
			System.out.print("OPCÃO ESCOLHIDA: ");
			opcaoEscolhida = input.nextInt();
			input.nextLine();
			System.out.println("-----------------------------------------");

			switch (opcaoEscolhida) {
			case 0:
				System.out.println("Você escolheu sair da aplicação. Até logo!");
				break;
			case 1:
				boolean loginRealizado = false;
				while (!loginRealizado) {
					do {
						System.out.print("Email: ");
						email = input.nextLine();
					} while (!gereSistema.validacaoEmail(email) || email.isBlank());

					do {
						System.out.print("Password: ");
						password = input.nextLine();
					} while (!gereSistema.validacaoSenha(password) || password.isBlank());

					Utilizador u = gereSistema.fazerLogin(email, password);
					if (u != null) {
						loginRealizado = true;
						if (u.getClass().getSimpleName().equals("Agricultor")) {
							menuAgricultor((Agricultor) u, gereSistema, input);
						} else if (u.getClass().getSimpleName().equals("Cliente")) {
							menuCliente((Cliente) u, gereSistema, input);
						}
						break;
					}

					/*
					 * tipoUtilizador = gereSistema.fazerLogin(email, password); if
					 * (!tipoUtilizador.isBlank()) { loginRealizado = true;
					 * System.out.println("TIPO UTILIZADOR  " + tipoUtilizador);
					 * System.out.println(tipoUtilizador.getClass().getName()); if
					 * (tipoUtilizador.equals("Agricultor")) { menuAgricultor(input); break; } else
					 * { menuCliente(input); break; } } else { break; }
					 */
				}
				break;
			case 2:
				int intuito;
				String nome;
				do {
					System.out.println("O que deseja fazer ? " + "\n1) COMPRAR" + "\n2) VENDER");
					intuito = input.nextInt();
					input.nextLine();
				} while (intuito != 1 && intuito != 2);

				if (intuito == 1) {
					registoCliente(input, gereSistema);
				} else if (intuito == 2) {
					registoAgricultor(input, gereSistema);
				}
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.\n");
				break;
			}
		} while (opcaoEscolhida != 0);

	}

	public static void registoAgricultor(Scanner input, GereSistema gereSistema) {
		String nome;
		String email;
		String password;
		String localRetirada;
		do {
			System.out.print("Nome: ");
			nome = input.nextLine();
		} while (nome.isBlank());

		do {
			System.out.print("Email: ");
			email = input.nextLine();
		} while (!gereSistema.validacaoEmail(email) || email.isBlank());

		do {
			System.out.print("Password: ");
			password = input.nextLine();
		} while (!gereSistema.validacaoSenha(password) || password.isBlank());

		do {
			System.out.println("Local de Retirada das encomendas: ");
			localRetirada = input.nextLine();
		} while (localRetirada.isBlank());

		Agricultor agricultor = new Agricultor(nome, email, password, localRetirada);
		gereSistema.inserirUtilizador(agricultor);
	}

	public static void registoCliente(Scanner input, GereSistema gereSistema) {
		String nome;
		String email;
		String password;
		String morada;
		int telemovel;
		int nif;
		String inputStr;

		do {
			System.out.print("Nome: ");
			nome = input.nextLine();
		} while (nome.isBlank());

		do {
			System.out.print("Email: ");
			email = input.nextLine();
		} while (!gereSistema.validacaoEmail(email) || email.isBlank());

		do {
			System.out.print("Password: ");
			password = input.nextLine();
		} while (!gereSistema.validacaoSenha(password) || password.isBlank());

		do {
			System.out.print("Morada: ");
			morada = input.nextLine();
		} while (morada.isBlank());

		do {
			System.out.print("Telemovel: ");
			inputStr = input.nextLine().trim();
		} while (inputStr.isBlank() || !inputStr.matches("\\d{9}"));

		telemovel = Integer.parseInt(inputStr);

		do {
			System.out.print("Nif: ");
			inputStr = input.nextLine().trim();
		} while (inputStr.isBlank() || !inputStr.matches("\\d{9}"));

		nif = Integer.parseInt(inputStr);

		Cliente cliente = new Cliente(nome, email, password, morada, telemovel, nif);
		gereSistema.inserirUtilizador(cliente);
	}

	public static void menuAgricultor(Agricultor agricultor, GereSistema gereSistema, Scanner input) {
		System.out.println("\n===== SEJA BEM-VINDO AGRICULTOR " + agricultor.getNome() + "=====");
		int opcaoEscolhida;
		do {

			System.out.println("\n===== Menu Agricultor =====");
			System.out.println("1. Registar meu produto");
			System.out.println("2. Adicionar stock");
			System.out.println("3. Remover produto");
			System.out.println("4. Ver encomendas em preparação");
			System.out.println("5. Ver/publicar conteúdo sustentável");
			System.out.println("6. Editar perfil");
			System.out.println("7. Ver histórico de vendas");
			System.out.println("8. Ver média de avaliações");
			System.out.println("0. LogOut");
			System.out.print("Opção: ");
			opcaoEscolhida = input.nextInt();
			input.nextLine();
			System.out.println("\n==========================");

			switch (opcaoEscolhida) {
			case 0:
				System.out.println("Fazendo logOut na conta" + agricultor.getNome() + ". Até mais! ");
				break;
			case 1:
				gereSistema.imprimeTodosOsProdutosDoCatalogoGeral();
				gereSistema.retornaListaDeProdAgricultor(agricultor);
				System.out.print("Nome do produto: ");
				String nomeProduto = input.nextLine();
				Produto p = gereSistema.procurarProdutoNoCatalogo(nomeProduto);
				if (p == null) {
					System.out.println("Produto não existe no catálogo. Deseja adicioná-lo? (s/n)");
					if (input.nextLine().equalsIgnoreCase("s")) {
						gereSistema.retornaIdsIndisponiveis();
						System.out.println("Id do produto (tem de ser um número inteiro): ");
						int id = input.nextInt();
						input.nextLine();
						/*
						 * System.out.println("Nome: "); String nome = input.nextLine();
						 */
						System.out.println("Nome a ser cadastrado no sistema para esse produto: " + nomeProduto);
						System.out.println("Unidade de Medida do produto: ");
						String unMedida = input.next();
						System.out.println("\nCategorias disponíveis:");
						for (Categoria cat : Categoria.values()) {
							System.out.println("- " + cat.name());
						}
						Categoria categoria = null;
						while (categoria == null) {
							System.out.println("\nDigite a categoria exatamente como mostrado acima: ");
							try {
								categoria = Categoria.valueOf(input.nextLine().toUpperCase());
							} catch (IllegalArgumentException e) {
								System.out.println("Categoria inválida! Por favor, digite exatamente como mostrado.");
							}
						}
						Produto novoPcatalogo = new Produto(id, nomeProduto, unMedida, categoria);
						gereSistema.adicionarProduto(novoPcatalogo);
						System.out.println("Produto adicionado ao catalogo.");
						p = novoPcatalogo;
					}
				}
				if (p != null) {
					// Verificar se o produto já está na lista do agricultor
					if (agricultor.produtoJaExiste(p.getIdProduto())) {
						System.out.println("\nEste produto já está no seu catálogo!");
						System.out.println("Deseja atualizar o preço? (s/n)");
						String resposta = input.nextLine();

						if (resposta.equalsIgnoreCase("s")) {
							// Tratamento seguro para entrada do preço
							double preco = 0;
							boolean precoValido = false;
							while (!precoValido) {
								try {
									System.out.print("Novo preço (use ponto como separador decimal, ex: 1.50): ");
									preco = input.nextDouble();
									input.nextLine(); // Consumir a quebra de linha
									precoValido = true;

									// Atualizar preço do produto existente
									for (ProdAgricultor prodAgricultor : agricultor.getListaProdAgricultor()) {
										if (prodAgricultor.getProduto().getIdProduto() == p.getIdProduto()) {
											prodAgricultor.setPreco(preco);
											System.out.println("Preço atualizado com sucesso!");
											break;
										}
									}
								} catch (InputMismatchException e) {
									System.out.println("Formato inválido! Use números com ponto decimal (ex: 1.50)");
									input.nextLine(); // Limpar o buffer do scanner
								}
							}
						}
					} else {
						System.out.println("\nAdicionando produto ao seu catálogo de agricultor:");

						// Tratamento seguro para entrada do preço
						double preco = 0;
						boolean precoValido = false;
						while (!precoValido) {
							try {
								System.out.print("Preço (use ponto como separador decimal, ex: 1.50): ");
								preco = input.nextDouble();
								input.nextLine(); // Consumir a quebra de linha
								precoValido = true;

								// Adicionar novo produto à lista do agricultor
								ProdAgricultor pa = new ProdAgricultor(p, preco, 0);
								agricultor.getListaProdAgricultor().add(pa);
								System.out.println("Produto registado com sucesso!");
								System.out.println("\n=== LISTA DE PRODUTOS CADASTRADOS ===\n");
								for (ProdAgricultor prodAgricultor : agricultor.getListaProdAgricultor()) {
									System.out.println(prodAgricultor);
								}
							} catch (InputMismatchException e) {
								System.out.println("Formato inválido! Use números com ponto decimal (ex: 1.50)");
								input.nextLine(); // Limpar o buffer do scanner
							}
						}
					}
				}
				break;
			case 2:
				String resposta;
				do {
					System.out.print(
							"Antes de atualizar o stock, deseja ver a sua lista de produtos cadastrados? (s/n): ");
					resposta = input.nextLine().trim();
				} while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				if (resposta.equalsIgnoreCase("s")) {
					System.out.println("\n=== SUA LISTA DE PRODUTOS CADASTRADOS ATUAL ===\n");
					for (ProdAgricultor prodAgricultor : agricultor.getListaProdAgricultor()) {
						System.out.println(prodAgricultor);
					}
				}

				String nomeAdd;
				do {
					System.out.print("Nome do produto para atualização: ");
					nomeAdd = input.nextLine();
				} while (nomeAdd.isBlank());

				boolean encontrado = false;
				for (ProdAgricultor pa : agricultor.getListaProdAgricultor()) {
					if (pa.getProduto().getNome().equalsIgnoreCase(nomeAdd)) {
						System.out.print("Quantidade a adicionar: ");
						int q = input.nextInt();
						input.nextLine();
						pa.setStock(pa.getStock() + q);
						System.out.println("Stock atualizado.");
						System.out.println("\n=== SUA LISTA DE PRODUTOS CADASTRADOS ATUALIZADA===\n");
						for (ProdAgricultor prodAgricultor : agricultor.getListaProdAgricultor()) {
							System.out.println(prodAgricultor);
						}
						encontrado = true;
						break;
					}
				}
				if (!encontrado)
					System.out.println("Produto não encontrado.");
				break;
			case 3:
				System.out.println("\n=== SUA LISTA DE PRODUTOS ATUAL ===\n");
				for (ProdAgricultor prodAgricultor : agricultor.getListaProdAgricultor()) {
					System.out.println(prodAgricultor);
				}
				System.out.print("Nome do produto a remover: ");
				String nomeRemover = input.nextLine();
				agricultor.getListaProdAgricultor()
						.removeIf(pa -> pa.getProduto().getNome().equalsIgnoreCase(nomeRemover));
				System.out.println("Produto removido da sua lista.");
				System.out.println("\n=== SUA LISTA DE PRODUTOS ATUALIZADA===\n");
				for (ProdAgricultor prodAgricultor : agricultor.getListaProdAgricultor()) {
					System.out.println(prodAgricultor);
				}
				break;
			case 4:
				System.out.println("=== Encomendas em preparação ===");

				List<Encomenda> emPreparacao = new ArrayList<>();

				for (Encomenda e : agricultor.getEncomendas()) {
					if (e.getEstado() == EstadoEncomenda.EM_PREPARACAO) {
						emPreparacao.add(e);
					}
				}

				if (emPreparacao.isEmpty()) {
					System.out.println("Nenhuma encomenda em preparação no momento.");
				} else {
					System.out.println("Encomendas encontradas:");
					for (Encomenda e : emPreparacao) {
						System.out.println(e);
					}

					// Pergunta se deseja alterar alguma encomenda
					String resposta1;
					do {
						System.out.print("\nDeseja marcar alguma encomenda como concluída? (s/n): ");
						resposta1 = input.nextLine().trim();
					} while (!resposta1.equalsIgnoreCase("s") && !resposta1.equalsIgnoreCase("n"));

					if (resposta1.equalsIgnoreCase("s")) {
						System.out.print("Informe o email do cliente cuja encomenda deseja concluir: ");
						String emailCliente = input.nextLine().trim();

						boolean encontrou = false;
						for (Encomenda e : emPreparacao) {
							if (e.getCliente().getEmail().equalsIgnoreCase(emailCliente)) {
								System.out.println("\nEncomenda encontrada:");
								System.out.println(e);

								String confirma;
								do {
									System.out.print("Deseja alterar o estado para CONCLUÍDO? (s/n): ");
									confirma = input.nextLine().trim();
								} while (!confirma.equalsIgnoreCase("s") && !confirma.equalsIgnoreCase("n"));

								if (confirma.equalsIgnoreCase("s")) {
									e.setEstado(EstadoEncomenda.CONCLUIDO);
									System.out.println("Estado da encomenda atualizado para CONCLUÍDO.");
								} else {
									System.out.println("Estado da encomenda não foi alterado.");
								}

								encontrou = true;
								break; // só trata uma encomenda por chamada
							}
						}

						if (!encontrou) {
							System.out.println(
									"Nenhuma encomenda em preparação encontrada para o cliente com esse email.");
						}

						// Mostrar a lista atualizada
						System.out.println("\n=== Encomendas ainda em preparação ===");
						boolean restam = false;
						for (Encomenda e : agricultor.getEncomendas()) {
							if (e.getEstado() == EstadoEncomenda.EM_PREPARACAO) {
								System.out.println(e);
								restam = true;
							}
						}

						if (!restam) {
							System.out.println("Agora não há mais encomendas em preparação.");
						}
					}
				}
				break;
			case 5:

				System.out.println("\n=== CONTEÚDO SUSTENTÁVEL ===");
				System.out.println("1. Ver todas as publicações");
				System.out.println("2. Criar nova publicação");
				System.out.println("0. Voltar");
				System.out.print("Opção: ");

				int opcaoPublicacao = input.nextInt();
				input.nextLine(); // Limpar buffer

				switch (opcaoPublicacao) {
				case 1:
					gereSistema.verTodasPublicacoes();
					break;
				case 2:
					System.out.println("\n=== CRIAR NOVA PUBLICAÇÃO ===");

					// 1. Ler conteúdo
					System.out.print("Escreva o conteúdo da publicação: ");
					String conteudo = input.nextLine();

					// 2. Mostrar categorias
					System.out.println("\nCategorias disponíveis:");
					for (Categoria cat : Categoria.values()) {
						System.out.println("- " + cat.name());
					}

					// 3. Escolher categoria com validação
					Categoria categoria = null;
					while (categoria == null) {
						System.out.print("\nDigite a categoria (como mostrado acima): ");
						String inputCat = input.nextLine().toUpperCase();

						try {
							categoria = Categoria.valueOf(inputCat);
						} catch (IllegalArgumentException e) {
							System.out.println("Categoria inválida. Tente novamente.");
						}
					}

					// 4. Criar publicação
					Publicacao novaPublicacao = new Publicacao(conteudo, categoria);

					// 5. Adicionar ao agricultor
					gereSistema.criarNovaPublicacao(agricultor, novaPublicacao);
					break;

				case 0:
					break;
				default:
					System.out.println("Opção inválida!");
				}
				break;
			case 6:
				System.out.println("\n=== Editar Perfil do Agricultor ===");

				String resposta1;

				// Nome
				System.out.println("Nome atual: " + agricultor.getNome());
				do {
					System.out.print("Deseja alterar o nome? (s/n): ");
					resposta1 = input.nextLine().trim();
				} while (!resposta1.equalsIgnoreCase("s") && !resposta1.equalsIgnoreCase("n"));

				if (resposta1.equalsIgnoreCase("s")) {
					String novoNome;
					do {
						System.out.print("Novo nome: ");
						novoNome = input.nextLine().trim();
					} while (novoNome.isBlank());
					agricultor.setNome(novoNome);
				}

				// Email
				System.out.println("Email atual: " + agricultor.getEmail());
				do {
					System.out.print("Deseja alterar o email? (s/n): ");
					resposta1 = input.nextLine().trim();
				} while (!resposta1.equalsIgnoreCase("s") && !resposta1.equalsIgnoreCase("n"));

				if (resposta1.equalsIgnoreCase("s")) {
					String novoEmail;
					do {
						System.out.print("Novo email: ");
						novoEmail = input.nextLine().trim();
					} while (!gereSistema.validacaoEmail(novoEmail) || novoEmail.isBlank());
					agricultor.setEmail(novoEmail);
				}

				// Password
				System.out.println("Password atual: " + agricultor.getPassword());
				do {
					System.out.print("Deseja alterar a password? (s/n): ");
					resposta1 = input.nextLine().trim();
				} while (!resposta1.equalsIgnoreCase("s") && !resposta1.equalsIgnoreCase("n"));

				if (resposta1.equalsIgnoreCase("s")) {
					String novaPassword;
					do {
						System.out.print("Nova password: ");
						novaPassword = input.nextLine().trim();
					} while (!gereSistema.validacaoSenha(novaPassword) || novaPassword.isBlank());
					agricultor.setPassword(novaPassword);
				}

				// Local de Retirada
				System.out.println("Local de retirada atual: " + agricultor.getLocalRetirada());
				do {
					System.out.print("Deseja alterar o local de retirada? (s/n): ");
					resposta1 = input.nextLine().trim();
				} while (!resposta1.equalsIgnoreCase("s") && !resposta1.equalsIgnoreCase("n"));

				if (resposta1.equalsIgnoreCase("s")) {
					String novoLocal;
					do {
						System.out.print("Novo local de retirada: ");
						novoLocal = input.nextLine().trim();
					} while (novoLocal.isBlank());
					agricultor.setLocalRetirada(novoLocal);
				}

				System.out.println("\nPerfil atualizado com sucesso!");
				System.out.println("========== DADOS ATUAIS DO AGRICULTOR ==========");
				System.out.println("Nome: " + agricultor.getNome());
				System.out.println("Email: " + agricultor.getEmail());
				System.out.println("Password: " + agricultor.getPassword());
				System.out.println("Local de Retirada: " + agricultor.getLocalRetirada());
				System.out.println("=================================================");
			case 7:
				for (Encomenda e : agricultor.getEncomendas()) {
					System.out.println(e);
				}
				break;
			case 8:
				double media = agricultor.getAvaliacoes().stream().mapToInt(Integer::intValue).average().orElse(0.0);
				System.out.printf("Média de avaliações: %.2f\n", media);
				break;
			default:
				System.out.println("Opção inválida.");
			}
		} while (opcaoEscolhida != 0);

	}

	public static void menuCliente(Cliente cliente, GereSistema gereSistema, Scanner input) {
		int opcaoEscolhida;

		System.out.println("\n===== SEJA BEM-VINDO CLIENTE " + cliente.getNome() + "=====");

		do {
			System.out.println("\n===== Menu Cliente =====");
			System.out.println("1. Ver catálogo de produtos disponíveis");
			System.out.println("2. Encomendar produto");
			System.out.println("3. Ver histórico de compras");
			System.out.println("4. Editar perfil");
			System.out.println("5. Avaliar agricultor");
			System.out.println("0. LogOut");
			System.out.print("Opção: ");
			opcaoEscolhida = input.nextInt();
			input.nextLine();
			System.out.println("\n==========================");

			switch (opcaoEscolhida) {
			case 0:
				System.out.println("Fazendo logOut da conta " + cliente.getNome() + ". Até logo!");
				break;

			case 1:
				gereSistema.mostrarCatalogo();
				break;

			case 2:
				System.out.print("Digite o nome do agricultor: ");
				String nomeAgr = input.nextLine();

				// Mostra todos os agricultores com esse nome
				gereSistema.procurarAgricultorPorNome(nomeAgr);

				System.out.print("\nDigite o email do agricultor com quem deseja encomendar: ");
				String emailAgr = input.nextLine();

				Agricultor agricultor = null;
				for (Utilizador u : gereSistema.getUtilizadores()) {
					if (u.getClass().getSimpleName().equals("Agricultor") && u.getEmail().equalsIgnoreCase(emailAgr)) {
						agricultor = (Agricultor) u;
						break;
					}
				}

				if (agricultor == null) {
					System.out.println("Agricultor não encontrado.");
					break;
				}

				Encomenda encomenda = new Encomenda(java.time.LocalDate.now().toString(), agricultor, cliente);

				System.out.println("\n=== LISTA DE PRODUTOS DO AGRICULTOR " + agricultor.getNome() + " ===\n");
				for (ProdAgricultor prodAgricultor : agricultor.getListaProdAgricultor()) {
					System.out.println(prodAgricultor);
				}
				System.out.println();

				while (true) {

					System.out.print("Produto a encomendar (ou digite voltar para sair ou finalizar a encomenda): ");
					String nomeProduto = input.nextLine();

					if (nomeProduto.equalsIgnoreCase("voltar"))
						break;

					ProdAgricultor prodAgr = null;
					for (ProdAgricultor pa : agricultor.getListaProdAgricultor()) {
						if (pa.getProduto().getNome().equalsIgnoreCase(nomeProduto) && pa.getStock() > 0) {
							prodAgr = pa;
							break;
						}
					}

					if (prodAgr == null) {
						System.out.println("Produto não encontrado ou sem stock.");
						continue;
					}
					int qtd = -1;

					do {
						System.out.print("Quantidade: ");
						String entrada = input.nextLine().trim();

						if (entrada.isEmpty()) {
							System.out.println("Erro: campo vazio. Digite um número válido.");
							continue;
						}

						try {
							qtd = Integer.parseInt(entrada);

							if (qtd <= 0) {
								System.out.println("Erro: a quantidade deve ser maior que zero.");
								continue;
							}

							if (qtd > prodAgr.getStock()) {
								System.out.println("Quantidade indisponível. Stock atual: " + prodAgr.getStock());
								continue;
							}

							break; // se o input for válido, sai do loop

						} catch (NumberFormatException e) {
							System.out.println("Erro: entrada inválida. Digite um número inteiro.");
						}

					} while (true);

					Prod_Encomenda newProdEncomenda = new Prod_Encomenda(prodAgr.getProduto().getIdProduto(), qtd);
					encomenda.incluirProdEncomenda(newProdEncomenda);
					prodAgr.setStock(prodAgr.getStock() - qtd);
				}

				if (!encomenda.getListaProdEncomenda().isEmpty()) {
					agricultor.getEncomendas().add(encomenda);
					cliente.getEncomendas().add(encomenda);
					System.out.println("Encomenda realizada com sucesso!");
				} else {
					System.out.println("Nenhum produto foi adicionado à encomenda.");
				}
				break;

			case 3:
				System.out.println("\n=== HISTÓRICO DE COMPRAS ===");
				if (cliente.getEncomendas().isEmpty()) {
					System.out.println("Nenhuma encomenda feita.");
				} else {
					for (Encomenda e : cliente.getEncomendas()) {
						System.out.println(e);
					}
				}
				break;

			case 4:
				System.out.println("\n=== Editar Perfil ===");

				String resposta;

				// Nome
				System.out.println("Nome atual: " + cliente.getNome());
				do {
					System.out.print("Deseja alterar o nome? (s/n): ");
					resposta = input.nextLine().trim();
				} while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				if (resposta.equalsIgnoreCase("s")) {
					System.out.print("Novo nome: ");
					String novoNome = input.nextLine();
					cliente.setNome(novoNome);
				}

				// Email
				System.out.println("Email atual: " + cliente.getEmail());
				do {
					System.out.print("Deseja alterar o email? (s/n): ");
					resposta = input.nextLine().trim();
				} while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				if (resposta.equalsIgnoreCase("s")) {
					String novoEmail;
					do {
						System.out.print("Novo email: ");
						novoEmail = input.nextLine();
					} while (!gereSistema.validacaoEmail(novoEmail));
					cliente.setEmail(novoEmail);
				}

				// Password
				System.out.println("Password atual: " + cliente.getPassword());
				do {
					System.out.print("Deseja alterar a password? (s/n): ");
					resposta = input.nextLine().trim();
				} while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				if (resposta.equalsIgnoreCase("s")) {
					String novaPass;
					do {
						System.out.print("Nova password: ");
						novaPass = input.nextLine();
					} while (!gereSistema.validacaoSenha(novaPass));
					cliente.setPassword(novaPass);
				}

				// Morada
				System.out.println("Morada atual: " + cliente.getMorada());
				do {
					System.out.print("Deseja alterar a morada? (s/n): ");
					resposta = input.nextLine().trim();
				} while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				if (resposta.equalsIgnoreCase("s")) {
					System.out.print("Nova morada: ");
					String novaMorada = input.nextLine();
					cliente.setMorada(novaMorada);
				}

				// Telemóvel
				System.out.println("Telemóvel atual: " + cliente.getTelemovel());
				do {
					System.out.print("Deseja alterar o telemóvel? (s/n): ");
					resposta = input.nextLine().trim();
				} while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				if (resposta.equalsIgnoreCase("s")) {
					String inputTel;
					do {
						System.out.print("Novo telemóvel (9 dígitos): ");
						inputTel = input.nextLine().trim();
					} while (!inputTel.matches("\\d{9}"));
					cliente.setTelemovel(Integer.parseInt(inputTel));
				}

				// NIF
				System.out.println("NIF atual: " + cliente.getNif());
				do {
					System.out.print("Deseja alterar o NIF? (s/n): ");
					resposta = input.nextLine().trim();
				} while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
				if (resposta.equalsIgnoreCase("s")) {
					String inputNif;
					do {
						System.out.print("Novo NIF (9 dígitos): ");
						inputNif = input.nextLine().trim();
					} while (!inputNif.matches("\\d{9}"));
					cliente.setNif(Integer.parseInt(inputNif));
				}
				System.out.println("Perfil atualizado com sucesso!");
				System.out.println();
				System.out.println(cliente);

				break;

			case 5:
				System.out.print("\nEmail do agricultor que quer avaliar: ");
				String emailAgri = input.nextLine();
				Agricultor agri = null;
				for (Utilizador u : gereSistema.getUtilizadores()) {
					if (u instanceof Agricultor && u.getEmail().equalsIgnoreCase(emailAgri)) {
						agri = (Agricultor) u;
						break;
					}
				}
				if (agri == null) {
					System.out.println("Agricultor não encontrado.");
				} else {
					int nota;

					do {
						System.out.print("Nota (1 a 5): ");

						while (!input.hasNextInt()) {
							System.out.println("Entrada inválida! Digite um número inteiro entre 1 e 5.");
							input.nextLine();
							System.out.print("Nota (1 a 5): ");
						}

						nota = input.nextInt();
						input.nextLine();

						if (nota < 1 || nota > 5) {
							System.out.println("Nota fora do intervalo permitido. Tente novamente.");
						}

					} while (nota < 1 || nota > 5);

					gereSistema.avaliar(emailAgri, nota);
					System.out.println("Avaliação registada!");
				}
				break;

			default:
				System.out.println("Opção inválida.");
			}

		} while (opcaoEscolhida != 0);
	}

}
