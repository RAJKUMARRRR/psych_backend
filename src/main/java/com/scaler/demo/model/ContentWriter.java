package com.scaler.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contentwriter")
public class ContentWriter extends Employee {
    @ManyToMany(cascade = CascadeType.PERSIST)
    @Getter
    @Setter
    private Set<Question> editedQuestion = new HashSet<>();
}
