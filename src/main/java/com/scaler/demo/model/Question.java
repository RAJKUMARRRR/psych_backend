package com.scaler.demo.model;

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
    @NotNull
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
    private Set<EllenAnswer> ellenAnswers = new HashSet<>();

    @Getter
    @Setter
    @NotNull
    @Enumerated(EnumType.STRING)
    private GameMode gameMode;
}
