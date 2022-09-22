package ru.littera.message.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "message", columnDefinition = "text")
    private String message;

    @Column(name = "author")
    private String author;

    @Column(name = "on_created")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime onCreated;  //Дата создания пользователя

    @PrePersist
    private void onCreate(){
        onCreated = LocalDateTime.now(); //Функция назначающая LocalDateTime 1362875813
    }

    public Message(String title, String message, String author) {
        this.title = title;
        this.message = message;
        this.author = author;
    }
}
