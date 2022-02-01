package edu.mum.users.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;

    public User(String name) {
        this.name = name;
    }
}
