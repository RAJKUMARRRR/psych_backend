package com.scaler.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "rounds")
public class Round extends Auditable{

    @Setter
    @Getter
    @ManyToOne
    @NotNull
    private Game game;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    private Question question;

    @Getter
    @Setter
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    private Map<Player,PlayerAnswer> submittedAnswers = new HashMap<>();

    @Getter
    @Setter
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    private Map<Player,PlayerAnswer> selectedAnswers = new HashMap<>();

    @Getter
    @Setter
    @ManyToOne
    private EllenAnswer ellenAnswer;

    @Getter
    @Setter
    @NotNull
    private int roundNumber;
}
