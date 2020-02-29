package com.scaler.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question extends Auditable{
    @Getter
    @Setter
    @NotBlank
    private String question;

    @Getter
    @Setter
    @NotBlank
    private String correctAnswer;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
    @JsonManagedReference
    private Set<EllenAnswer> ellenAnswers = new HashSet<>();

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private GameMode gameMode;

    public Question(){}

    public Question(@NotBlank String question, @NotBlank String correctAnswer, @NotNull GameMode gameMode) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.gameMode = gameMode;
    }
}
