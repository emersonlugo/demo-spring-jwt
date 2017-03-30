package demo.spring.boot.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/api", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class DemoController {

	@RequestMapping(value = "endpoint-protected", method = RequestMethod.GET)
	public ResponseEntity<String> acessProtectedUrl() {
		return new ResponseEntity<String>("Você acaba de acessar um endpoint protegido. Parabéns!!", HttpStatus.OK);
	}
}