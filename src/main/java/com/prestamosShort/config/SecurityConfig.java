package com.prestamosShort.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
     //@Bean
    /**public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())//se usa solamente cuando se van a logear con usuario y contraseña con token es de otra forma
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    //configurar los endpoins publicos
                    http.requestMatchers(HttpMethod.POST, "/api/usuarios" ).permitAll();
                    //configurar los endpoinsts privados
                    http.requestMatchers(HttpMethod.GET, "/api/usuarios/{id}").hasAnyAuthority("ADMIN", "OPERADOR");
                    //configurar el resto de endpoint -NO ESPECIFICADOS
                    http.anyRequest().denyAll();//si el usuario le pega a un edpoin que no este definido arriba no lo va a dejer pasar
                    http.anyRequest().authenticated();//otra manera como el de la linia 47 osea el de arriba de este.

                })
    .build();

    }**/

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
 return httpSecurity
 .csrf(csrf -> csrf.disable())
 .httpBasic(Customizer.withDefaults())//se usa solamente cuando se van a logear con usuario y contraseña con token es de otra forma
 .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
 .build();

 }

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetailsService> userDetailsServiceList = new ArrayList<>();

        userDetailsServiceList.add((UserDetailsService) User.withUsername("sebastian")
                .password("1234")
                .roles("ADMIN")
                .authorities("READ","CREATE")
                .build());
        userDetailsServiceList.add((UserDetailsService) User.withUsername("esteban")
                .password("1234")
                .roles("USER")
                .authorities("READ")
                .build());
        return new InMemoryUserDetailsManager((UserDetails) userDetailsServiceList);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
