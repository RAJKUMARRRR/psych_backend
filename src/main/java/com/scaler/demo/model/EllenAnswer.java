package com.scaler.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ellenanswers")
public class EllenAnswer extends Auditable{
    @ManyToOne
    @NotNull
    @Getter
    @Setter
    @JsonBackReference
    private Question question;

    @Getter
    @Setter
    private long votes=0l;

    @NotBlank
    @Getter
    @Setter
    private String answer;
}
