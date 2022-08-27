package ru.littera.message.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.littera.message.models.Message;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {
    private int nextId = 0;
    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public String message(Model model){
    model.addAttribute("messages", messages);
    return "messages";
    }


}
