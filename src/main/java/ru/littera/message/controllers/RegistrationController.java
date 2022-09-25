package ru.littera.message.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.littera.message.models.User;
import ru.littera.message.models.enums.Role;
import ru.littera.message.repositories.UserRepository;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
@Log4j2
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute User user){
        user.setActive(true); //Признак активности
        user.setRoles(Collections.singleton(Role.USER));//
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Registration new User with username: {}", user.getUsername());
        userRepository.save(user);
        return "redirect:/login";
    }


}
