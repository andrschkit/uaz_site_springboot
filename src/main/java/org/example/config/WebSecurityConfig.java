package org.example.config;


//import org.example.handlers.MyCustomLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.example.StaticString.*;

@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("superuser")
                        .password(passwordEncoder().encode("123"))
                        .roles("ADMIN")
                        .build();


        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public AuthenticationSuccessHandler successHandler() {
        return new MyCustomLoginSuccessHandler("/");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO работает только если убрать защиту CSRF
        // и ставить проверку логина только на get запросы(если ставить и на post, то протухшая сессия выкинет ошибку)
        // при этом таймаут сессии стоит 1 минута,
        // т.е. после нее csrf протухает и выкидывается ошибка при попытке сделать Post запрос.
        // сохранение данных сессии как в видосе не помогает
        // Идея  - сохранять черновик





        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, URL_ADD_POSTS, URL_EDIT_POSTS).hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, URL_ADD_POSTS, URL_EDIT_POSTS).hasRole("ADMIN")
                .antMatchers(
                        "/**", URL_API_KILL_SESSION, "/robots.txt"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //.successHandler(successHandler())
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .logout()
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(2)


                /*.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)*/;
    }

}
