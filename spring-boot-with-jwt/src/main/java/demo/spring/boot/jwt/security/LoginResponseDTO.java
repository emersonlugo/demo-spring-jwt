package demo.spring.boot.jwt.security;

import java.io.Serializable;

class LoginResponseDTO implements Serializable {

	private static final long serialVersionUID = -9076352693417877418L;
	
	private String token;
	
	public LoginResponseDTO(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}