package br.minhaigreja.configurations;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Value("${jwt.public.key}")
	private RSAPublicKey PUBLIC_KEY;

	@Value("${jwt.private.key}")
	private RSAPrivateKey PRIVATE_KEY;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).headers(headers -> headers.frameOptions(options -> options.disable()))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						(authorize) -> authorize
							.requestMatchers("/api/auth/*").permitAll()
							.anyRequest().authenticated()
						)
				.httpBasic(Customizer.withDefaults()).oauth2ResourceServer(conf -> conf.jwt(Customizer.withDefaults()));

		return http.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {

		return NimbusJwtDecoder.withPublicKey(this.PUBLIC_KEY).build();
	}

	@Bean
	public JwtEncoder jwtEncoder() {

		JWK jwk = new RSAKey.Builder(this.PUBLIC_KEY).privateKey(this.PRIVATE_KEY).build();

		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<SecurityContext>(new JWKSet(jwk));

		return new NimbusJwtEncoder(jwks);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
}
