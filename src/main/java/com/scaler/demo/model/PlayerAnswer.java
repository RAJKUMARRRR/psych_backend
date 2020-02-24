package com.scaler.demo.model;

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
    private Player player;

    @NotNull
    @Getter
    @Setter
    @ManyToOne
    private Round round;

    @Getter
    @Setter
    @NotBlank
    private String answer;
}
