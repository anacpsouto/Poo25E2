
package application;


public class Utilizador {
	private String nome;
	private String email;
	private String password;
	
	/**
	 * Construtor do Utilizador.
	 * @param nome Nome do utilizador
	 * @param email Email do utilizador
	 * @param password Senha do utilizador
	 */
	public Utilizador(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	
	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}//Fim class