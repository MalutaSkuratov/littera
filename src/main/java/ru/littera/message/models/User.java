package ru.littera.message.models;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.littera.message.models.enums.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true) //Уникальность
    private String email;

    @Column(name = "password", length = 1000) //Длинна пароля
    private String password;

    @Column(name = "is_active") // Активность пользователя
    private boolean isActive;

    @Column(name = "username")
    private String username;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)// Какой элемент данной колекции является тем, который будет заполнять ячейку текущей роли пользователя
    @CollectionTable(name = "user_role",           //Создаёт отдельную таблицу user_role
            joinColumns = @JoinColumn(name = "user_id"))  // Эквивалентен id у User'а. И связываем его с Ролью (Role), Которая ему полагается
    @Enumerated(EnumType.STRING) // Добавляем Enum в Entity.String - в базе будет хранится имя этого enum'а
    private Set<Role> roles = new HashSet<>();


    @Column(name = "on_created")
    private LocalDateTime onCreated; // Дата создания пользователя

    @PrePersist
    private void onCreate(){
        onCreated = LocalDateTime.now(); // Функция назначающая LocalDateTime 1362875813
    }



    //Security

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {  //
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {  //
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {  //
        return true;
    }

    @Override
    public boolean isEnabled() {  // Бан пользователей
        return isActive;
    }  // функция бана
}
