package ru.littera.message.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login") // Без взаимодействия с контроллером отображает шаблон
                .setViewName("login");
    }
    // Конфигурирует контроллеры. Отображает шаблон
}
