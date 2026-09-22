package com.hibernate.ferreteria.Seguridad;

import com.hibernate.ferreteria.Services.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsuarioService userService;

    public SecurityConfig(UsuarioService userService) {
        this.userService = userService;
    }

    // Cifra las contraseñas utilizando BCrypt.
    // Evita almacenar las contraseñas directamente en texto plano.
    @Bean
    public PasswordEncoder codificaPass() {
        return new BCryptPasswordEncoder();
    }


    // Gestiona el proceso de autenticación:
    // comprueba si el usuario y la contraseña son correctos.
    @Bean
    public AuthenticationManager autenticacion(
            AuthenticationConfiguration authConfig)
            throws Exception {

        return authConfig.getAuthenticationManager();
    }


    // Configura las reglas de seguridad para las peticiones HTTP.
    @Bean
    public SecurityFilterChain securityChain(HttpSecurity http,
                                             AuthenticationManager authManager)
            throws Exception {

        http
                // Desactiva CSRF para trabajar con la API REST.
                .csrf(csrf -> csrf.disable())

                // Define quién puede acceder a cada ruta.
                .authorizeHttpRequests(auth -> auth

                        // Las rutas de autenticación son públicas.
                        .requestMatchers("/api/auth/**").permitAll()

                        // Artículos: solo ADMIN o USER.
                        .requestMatchers("/api/articulos/**")
                        .hasAnyRole("ADMIN", "USER")

                        // Cualquier otra petición necesita autenticación.
                        .anyRequest().authenticated()
                )

                // Indica qué AuthenticationManager utilizar.
                .authenticationManager(authManager)

                // Indica el servicio que busca los usuarios en la BBDD.
                .userDetailsService(userService)

                // Activa el formulario de login.
                .formLogin(form -> form.permitAll())

                // Activa la autenticación mediante Basic Auth.
                .httpBasic(basic -> {});

        // Construye y devuelve la configuración de seguridad.
        return http.build();
    }
}