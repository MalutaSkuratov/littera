package ru.littera.message.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity  // @Configuration внутри
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // Авторизированные запросы
                .antMatchers("/login", "/registration").permitAll() // Доступные страницы для не авторизированных пользователей. permitAll - Разрешает эти запросы
                .anyRequest().authenticated() //Все остальные запросы должны быть аутенфицированы
                    .and() // Раздеоение блока
                .formLogin()
                .loginPage("/login") //Страница которая отвечает за login
                    .and() // Разделение блока
                .logout().permitAll(); // Выход из аккаунта
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user); // 23:10 Security
    }





}
















