package demo.spring.boot.jwt.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenUtils {

	private static final String  TOKEN_SECRET = "4a1a71a9ebb86dad178c14efb6wed2";
	private static final String  TOKEN_BEARER = "demoToken ";	
	
	private TokenUtils() {}
	
	public static String createToken(Claims claims) {
		final Instant tokenExpirationTime = Instant.now().plus(30, ChronoUnit.MINUTES);
		return Jwts.builder()
		.setId(UUID.randomUUID().toString())
		.setClaims(claims)
		.setIssuedAt(new Date())
		.setExpiration(Date.from(tokenExpirationTime))
		.signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
		.compact();
	}
	
	public static Claims decodeToken(final String authHeader) throws IllegalAccessException {
		if (authHeader == null || !authHeader.startsWith(TOKEN_BEARER)) {
			throw new IllegalAccessException("Authorization header inválido.");
		}
		final String token = authHeader.split(" ")[1];
		return Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
	}
}