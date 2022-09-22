package ru.littera.message.configurations;


import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.littera.message.services.CustomUserDetailsServices;


@EnableWebSecurity  // @Configuration внутри
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsServices userDetailsServices;
    private final PasswordEncoder passwordEncoder;

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServices)
                .passwordEncoder(passwordEncoder);

    }
}
















