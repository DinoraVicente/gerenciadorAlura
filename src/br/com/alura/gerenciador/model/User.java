package br.com.alura.gerenciador.model;

public class User {
	private String login;
	private String password;
	
	public User() {
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean userExists(String login, String password) {
		if(!this.login.equals(login)) {
			return false;
		}
		if(!this.password.equals(password)) {
			return false;
		}
		return true;
	}
}
