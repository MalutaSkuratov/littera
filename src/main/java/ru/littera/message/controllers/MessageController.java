package ru.littera.message.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.littera.message.dto.MessageDTO;
import ru.littera.message.models.Message;
import ru.littera.message.repositories.MessageRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    private long nextId = 0;
    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public String messages(Model model){  //Модель для передачи сообщения в ФриМаркер. И их отобразить
    model.addAttribute("messages", messageRepository.findAll());
    return "messages";
    }

    @PostMapping("/messages/new")
    public String createMessage(@ModelAttribute MessageDTO messageDTO){
        Message message = new Message(messageDTO.getTitle(), messageDTO.getMessage(), messageDTO.getAuthor());
        messageRepository.save(message);
        return "redirect:/";
    }

    @PostMapping("/messages/delete/{id}")
    private String deleteMessage(@PathVariable Long id){
        messageRepository.deleteById(id);
        return "redirect:/";

    }


}
