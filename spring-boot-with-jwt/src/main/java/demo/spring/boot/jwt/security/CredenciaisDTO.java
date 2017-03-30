package demo.spring.boot.jwt.security;

class CredenciaisDTO implements Credenciais {

	private static final long serialVersionUID = 5222103920384128831L;
	
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
}