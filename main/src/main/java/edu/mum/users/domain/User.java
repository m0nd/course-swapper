package edu.mum.users.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    //private boolean isAuthor

    public User(String name) {
        this.name = name;
    }
}
