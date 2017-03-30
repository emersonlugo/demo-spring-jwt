package demo.spring.boot.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import demo.spring.boot.jwt.security.SecurityFilter;


@SpringBootApplication
public class SpringBootJwtApplication {
	
	/**
	 * Configuração do pattern dos endpoints que serão interceptados pelo @SecurityFilter
	 */
	private static final String URL_PATTERN = "/api/*";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new SecurityFilter());
		registrationBean.addUrlPatterns(URL_PATTERN); 
		return registrationBean;
	}
}