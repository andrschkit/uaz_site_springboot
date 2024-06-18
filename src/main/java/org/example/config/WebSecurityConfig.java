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
@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("getAdmin")
                        .password(passwordEncoder().encode("123"))
                        .roles("ADMIN_GET")
                        .build();

        UserDetails user1 =
                User.builder()
                        .username("postAdmin")
                        .password(passwordEncoder().encode("123"))
                        .roles("ADMIN_POST")
                        .build();

        return new InMemoryUserDetailsManager(user, user1);
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





        http.csrf().disable().authorizeRequests()
                //.antMatchers(HttpMethod.POST, "/editPost", "/addPost").hasRole("ADMIN_POST")
                .antMatchers(HttpMethod.GET, "/editPost", "/addPost").hasRole("ADMIN_GET")
                .antMatchers(
                        "/**"
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
