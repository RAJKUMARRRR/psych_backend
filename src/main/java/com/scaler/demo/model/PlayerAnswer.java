package com.scaler.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "playeranswer")
public class PlayerAnswer extends Auditable{
    @NotNull
    @Getter
    @Setter
    @ManyToOne
    @JsonIdentityReference
    private Player player;

    @NotNull
    @Getter
    @Setter
    @ManyToOne
    @JsonBackReference
    private Round round;

    @Getter
    @Setter
    @NotBlank
    private String answer;
}
