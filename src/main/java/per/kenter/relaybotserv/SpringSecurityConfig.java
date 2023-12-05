package per.kenter.relaybotserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import per.kenter.relaybotserv.service.Oauth2AccountSNSService;
import per.kenter.relaybotserv.service.user.UserService;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    private Oauth2AccountSNSService oauth2AccountSNSService;

    UserService userService;

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
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/api/reqsub").hasRole("NotCreatedLink")).
                formLogin( login -> login.loginPage("/login").defaultSuccessUrl("/index"))
                .oauth2Login().defaultSuccessUrl("/login-succeed").userInfoEndpoint(endpoint -> endpoint.userService(oauth2AccountSNSService))
                .and().build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userService);

        return provider;
    }
}