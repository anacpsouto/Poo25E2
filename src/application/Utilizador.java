/**
 * 
 */
package application;

/**
 * 
 */
public class Utilizador {
	private String nome;
	private String email;
	private String password;
	
	 /**
     * @param nome
     * @param email
     * @param password
     */
	public Utilizador(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
