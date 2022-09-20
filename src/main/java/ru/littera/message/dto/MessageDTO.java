package ru.littera.message.dto;


import lombok.Data;

@Data
public class MessageDTO {
    private String title;
    private String message;
    private String author;
}
