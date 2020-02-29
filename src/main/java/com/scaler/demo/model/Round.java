package com.scaler.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Game game;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    @JsonIdentityReference
    private Question question;

    @Getter
    @Setter
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Map<Player,PlayerAnswer> submittedAnswers = new HashMap<>();

    @Getter
    @Setter
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Map<Player,PlayerAnswer> selectedAnswers = new HashMap<>();

    @Getter
    @Setter
    @ManyToOne
    @JsonIdentityReference
    private EllenAnswer ellenAnswer;

    @Getter
    @Setter
    @NotNull
    private int roundNumber;
}
