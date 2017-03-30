package demo.spring.boot.jwt.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping(value= "/authorization", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class LoginController {

	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public LoginResponseDTO efetuarLogin(@RequestBody CredenciaisDTO credenciais) {
		Usuario usuario = findUsuarioByCredenciais(credenciais);
	    String token = createToken(usuario);
		return new LoginResponseDTO(token);
	}

	private String createToken(Usuario usuario) {
		Map<String, Object> claims = new HashMap<String, Object>();
		/* Definição do payload (A segunda parte do token, onde declaramos o conteúdo que iremos manipular no front-end. 
		/* Geralmente são informações sobre uma entidade (normalmente, o usuário) e metadados adicionais. */
		claims.put("usuarioSistema", usuario);
		return TokenUtils.createToken(Jwts.claims(claims));
	}
	
	/**
	 * Para fins de simplificação do exemplo, fiz um mock da busca do usuário. 
	 * Em uma implementação real essa consulta deveria acessar a base de dados em
	 * busca do usuário que corresponda as credenciais recebidas no responseBody.
	 */
	private Usuario findUsuarioByCredenciais(CredenciaisDTO credenciais) {
		return new Usuario(1L, "admin");
	}
}