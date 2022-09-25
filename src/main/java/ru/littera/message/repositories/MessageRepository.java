package ru.littera.message.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.littera.message.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
    Message findByTitle(String title);
}
