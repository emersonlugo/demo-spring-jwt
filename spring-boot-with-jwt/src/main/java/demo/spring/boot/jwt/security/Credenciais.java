package demo.spring.boot.jwt.security;

import java.io.Serializable;

public interface Credenciais extends Serializable {

	public String getLogin();
	
	public String getSenha();
}
