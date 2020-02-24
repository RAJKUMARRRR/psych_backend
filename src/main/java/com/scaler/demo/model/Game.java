package com.scaler.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(name = "games")
public class Game extends Auditable{
    @Getter
    @Setter
    @ManyToMany
    private Set<Player> players = new HashSet<>();

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @NotBlank
    private GameMode gameMode;

    @Getter
    @Setter
    @OneToMany(mappedBy = "game",cascade = CascadeType.ALL)
    private List<Round> rounds = new ArrayList<>();

    @Getter
    @Setter
    private int numOfRounds = 10;

    @Getter
    @Setter
    private boolean hasEllen;

    @ManyToOne
    @Getter
    @Setter
    @NotBlank
    private Player leader;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Map<Player, Stat> playerStats = new HashMap<>();

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus = GameStatus.PLAYERS_JOINING;

    @ManyToMany
    @Getter
    @Setter
    private Set<Player> readyPlayers = new HashSet<>();
}
