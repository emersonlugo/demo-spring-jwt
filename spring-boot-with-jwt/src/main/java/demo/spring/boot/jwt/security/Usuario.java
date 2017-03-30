package demo.spring.boot.jwt.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Usuario {

	private Long id;
	private String login;
	private String senha;
	
	public Usuario() {}
	
	public Usuario(Long id, String login) {
		this.id = id;
		this.login = login;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	@JsonIgnore
	public String getSenha() {
		return senha;
	}
}
