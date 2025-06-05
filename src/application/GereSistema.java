/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * 
 */
public class GereSistema {
	private ArrayList<Utilizador>utilizadores;
	private ArrayList<Produto>catalogo;
	//declaração do padrão de senha usado: 
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_]).{8,}$\n";
	//compilação do padrão acima.
	private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    /**
     *
     */
}
