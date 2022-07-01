package com.project.betting_backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private Integer numberOfWins;

    private Double teamRating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Team team = (Team) o;
        return id != null && Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
