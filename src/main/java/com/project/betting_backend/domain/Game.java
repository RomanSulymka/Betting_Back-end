package com.project.betting_backend.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String gameName;

    @ManyToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team")
    private Team awayTeam;

    private String gameResult;

    private Double minRate;

    private Double possibleGain;

    private Double userWin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Game game = (Game) o;
        return id != null && Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
