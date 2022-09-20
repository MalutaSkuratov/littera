package ru.littera.message.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "messages")
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String message;
    private String author;

    public Message(String title, String message, String author) {
        this.title = title;
        this.message = message;
        this.author = author;
    }
}
