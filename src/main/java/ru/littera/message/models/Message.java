package ru.littera.message.models;


import lombok.Data;

@Data
public class Message {

    private Long id;
    private String title;
    private String message;
    private String author;

}
