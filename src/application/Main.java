package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GereSistema gereSistema = new GereSistema();

		Scanner input = new Scanner(System.in);

		int opcaoEscolhida;
		String email = "";
		String password;

		do {
			System.out.println("-----------------------------------------------------------");
			System.out.println("Seja bem-vindo! É um prazer tê-lo conosco.");
			System.out.println("O que deseja fazer ? ");
			System.out.println("1) Fazer login");
			System.out.println("2) Criar um perfil");
			System.out.println("0) Sair da aplicacão");
			System.out.println("-----------------------------------------------------------");
			System.out.print("OPCÃO ESCOLHIDA: ");
			opcaoEscolhida = input.nextInt();
			input.nextLine();
			System.out.println("-----------------------------------------------------------");

			switch (opcaoEscolhida) {
			case 0:
				System.out.println("Você escolheu sair. Até logo!");
				break;
			case 1:
				boolean loginRealizado = false;
				String tipoUtilizador = "";

				while (!loginRealizado) {
					do {
						System.out.print("Email: ");
						email = input.nextLine();
					} while (!gereSistema.validacaoEmail(email) || email.isBlank());

					do {
						System.out.print("Password: ");
						password = input.nextLine();
					} while (!gereSistema.validacaoSenha(password) || password.isBlank());

					tipoUtilizador = gereSistema.fazerLogin(email, password);
					if (!tipoUtilizador.isBlank()) {
						loginRealizado = true;
						if (tipoUtilizador.equals("Agricultor")) {
							menuAgricultor(input);
							break;
						} else {
							menuCliente(input);
							break;
						}
					} else {
						break;
					}
				}
			case 2:
				int intuito;
				String nome;
				do {
					System.out.println("\nO que deseja fazer ? " + "\n1) COMPRAR" + "\n2) VENDER");
					intuito = input.nextInt();
					input.nextLine();
				} while (intuito != 1 && intuito != 2);

				if (intuito == 1) {
					registoCliente(input, gereSistema);
				} else if (intuito == 2) {
					registoAgricultor(input, gereSistema);
				} else {
					break;
				}
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
		}while(nome.isBlank());
		
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
		}while(localRetirada.isBlank());
		
		Agricultor agricultor = new Agricultor(nome,email, password, localRetirada);
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
		}while(nome.isBlank());
		
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
		}while(morada.isBlank());
		
		do {
			System.out.print("Telemovel: ");
			inputStr = input.nextLine().trim();
		}while(inputStr.isBlank() || !inputStr.matches("\\d{9}"));
		
		telemovel = Integer.parseInt(inputStr);
		
		do {
			System.out.print("Nif: ");
			inputStr = input.nextLine().trim();
		}while(inputStr.isBlank() || !inputStr.matches("\\d{9}"));
		
		nif = Integer.parseInt(inputStr);
		
		Cliente cliente = new Cliente(nome, email, password, morada, telemovel, nif);
		gereSistema.inserirUtilizador(cliente);
	}

	public static void menuAgricultor(Scanner input) {
		System.out.println("-----------------------------  MENU AGRICULTOR -----------------------------");
	}

	public static void menuCliente(Scanner input) {
		System.out.println("------------------------------  MENU CLIENTE -------------------------------");
	}

}
