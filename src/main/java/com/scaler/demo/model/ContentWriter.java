package com.scaler.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contentwriters")
public class ContentWriter extends Employee {
    @ManyToMany(cascade = CascadeType.PERSIST)
    @Getter
    @Setter
    @JsonIdentityReference
    private Set<Question> editedQuestion = new HashSet<>();
}
