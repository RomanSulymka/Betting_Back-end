package com.project.betting_backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;

@Entity
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 10)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 50)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Game> games = new HashSet<>();

    //TODO: FIX ONE TO ONE. I guess should be Many to one
    @OneToOne
    private Team favoriteTeam;

    private Double coins;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
