package api.cliente.springboot2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Usa a nova sintaxe
                .authorizeHttpRequests(authorize -> authorize
                        // Permite acesso a qualquer requisição OPTIONS
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        // Permite requisições POST para a URL /usuarios
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        // Permite requisições DELETE para a URL /usuarios/{id}
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/**").permitAll()
                        .anyRequest().authenticated()
                        // ✅ ADICIONE ESTA LINHA para permitir o GET na URL /usuarios
                        .requestMatchers(HttpMethod.GET, "/usuarios").permitAll()
                );
        return http.build();
    }
}