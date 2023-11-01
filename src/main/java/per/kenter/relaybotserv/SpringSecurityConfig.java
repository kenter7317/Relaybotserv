package per.kenter.relaybotserv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.csrf(AbstractHttpConfigurer::disable)
                .headers(headers ->
                        headers.frameOptions().sameOrigin())
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/callback", "/api/**", "/api/callback", "/index", "/static/**","/css/**", "/favicon.ico").permitAll())
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(STATELESS)
                )
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/api/reqsub").hasRole("NotCreatedLink");
                }).
                formLogin().disable()
                /*.oauth2Login()*/
                .build();
    }
}