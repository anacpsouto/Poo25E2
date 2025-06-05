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
			System.out.println("0) Fazer login");
			System.out.println("-----------------------------------------------------------");
			System.out.print("OPCÃO ESCOLHIDA: ");
			opcaoEscolhida = input.nextInt();
			input.nextLine();
			System.out.println("-----------------------------------------------------------");
			
			switch(opcaoEscolhida) {
				case 0: 
					System.out.println("Você escolheu sair. Até logo!");
					break;
				case 1: 
					boolean loginRealizado = false;
					
					while(!loginRealizado) {
						do {
							
						}while(!gereSistema);
					}
					
				
			}
		}while(opcaoEscolhida != 0 );
		s

	}

}
