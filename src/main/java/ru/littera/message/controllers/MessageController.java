package ru.littera.message.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.littera.message.models.Message;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {
    private long nextId = 0;
    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public String messages(Model model){  //Модель для передачи сообщения в ФриМаркер. И их отобразить
    model.addAttribute("messages", messages);
    return "messages";
    }

    @PostMapping("/messages/new")
    public String createMessage(@ModelAttribute Message message){
        message.setId(++nextId);
        messages.add(message);
        return "redirect:/";
    }

    @PostMapping("/messages/delete/{id}")
    private String deleteMessage(@PathVariable Long id){
        messages.removeIf(message -> message.getId().equals(id));
        return "redirect:/";

    }


}
