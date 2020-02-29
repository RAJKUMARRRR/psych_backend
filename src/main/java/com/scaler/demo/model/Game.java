package com.scaler.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "games")
public class Game extends Auditable{
    @Getter
    @Setter
    @ManyToMany
    @JsonIdentityReference
    private Set<Player> players = new HashSet<>();

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @NotNull
    private GameMode gameMode;

    @Getter
    @Setter
    @OneToMany(mappedBy = "game",cascade = CascadeType.ALL)
    @JsonIgnore
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
    @NotNull
    @JsonIgnore
    private Player leader;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    @JsonIgnore
    private Map<Player, Stat> playerStats = new HashMap<>();

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus = GameStatus.PLAYERS_JOINING;

    @ManyToMany
    @Getter
    @Setter
    @JsonIgnore
    private Set<Player> readyPlayers = new HashSet<>();
}
