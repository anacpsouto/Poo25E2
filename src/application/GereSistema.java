/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */
public class GereSistema {
	private ArrayList<Utilizador>utilizadores;
	private ArrayList<Produto>catalogo;
	//declaração do padrão de senha usado: 
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_]).{8,}$";
	private static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	//compilação do padrão acima.
	
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
		if(!matcher.matches()) {
			System.out.println("Email inválido!");
		}
		return matcher.matches();
	}
	
	public boolean validacaoSenha(String password) {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches()) {
            System.out.println("\nA sua senha precisa conter:\n"
                    + "-Pelo menos 8 caractéres.\n"
                    + "-Pelo menos 1 letra maiúscula.\n"
                    + "-Pelo menos 1 letra minúscula.\n"
                    + "-Pelo menos 1 número\n"
                    + "-Pelo menos 1 caractere especial (@#$%&)\n");
        }

        return matcher.matches();
	}
	
	public String fazerLogin(String email, String password) {
		boolean encontrou = false;
		for(Utilizador utilizador : utilizadores) {
			if(utilizador.getEmail().equals(email)) {
				encontrou = true;
				if(utilizador.getPassword().equals(password)) {
					System.out.println(utilizador.getClass().getSimpleName());
					return utilizador.getClass().getSimpleName();
				}
			}
		}
		if(encontrou) {
			System.out.println("E-mail ou senha incorretos! \n");
			return "";
		}
		
		System.out.println("Utilizador não encontrado. \n");
		return "";
	}
	
	public void inserirUtilizador(Utilizador newUtilizador) {
		utilizadores.add(newUtilizador);
	}	
	
}
