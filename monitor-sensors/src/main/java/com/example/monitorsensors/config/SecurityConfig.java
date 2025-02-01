package com.example.monitorsensors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
	
	private static final String AUTH_URL = "/auth/**";
	private static final String ROLE_ADMIN = "ADMINISTRATOR";
    private static final String ROLE_VIEWER = "VIEWER";
    private static final String SENSORS_URL = "/sensors/**";
    private static final String SENSOR_TYPES_URL = "/sensor-types/**";
    private static final String MEASUREMENT_UNITS_URL = "/measurement-units/**";
    private static final String SENSOR_SEARCH_URL = "/sensors/search";    
    private static final String SWAGGER_URLS = "/swagger-ui/**";
    private static final String API_DOCS_URLS = "/v3/api-docs/**";
    private static final String API_DOCS_YAML = "/v3/api-docs.yaml";
    
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
        .csrf(csrf -> csrf.disable()) // Disabling CSRF for the REST API
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS)) // without session
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(AUTH_URL).permitAll() // without authorization
            .requestMatchers(SWAGGER_URLS, API_DOCS_URLS, API_DOCS_YAML).permitAll()
            .requestMatchers(HttpMethod.GET, SENSORS_URL).hasAnyRole(ROLE_ADMIN, ROLE_VIEWER) 
            .requestMatchers(HttpMethod.POST, SENSORS_URL).hasRole(ROLE_ADMIN) 
            .requestMatchers(HttpMethod.PUT, SENSORS_URL).hasRole(ROLE_ADMIN) 
            .requestMatchers(HttpMethod.DELETE, SENSORS_URL).hasRole(ROLE_ADMIN)
            .requestMatchers(HttpMethod.GET, SENSOR_TYPES_URL).hasAnyRole(ROLE_ADMIN, ROLE_VIEWER)
            .requestMatchers(HttpMethod.GET, MEASUREMENT_UNITS_URL).hasAnyRole(ROLE_ADMIN, ROLE_VIEWER)
            .requestMatchers(HttpMethod.GET, SENSOR_SEARCH_URL).hasAnyRole(ROLE_ADMIN, ROLE_VIEWER)
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults()); // (Spring Security 6.1+)
		return http.build();
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
			throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}

}
