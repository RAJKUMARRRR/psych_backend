package com.scaler.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property = "id"
)
public abstract class Auditable implements Serializable {
    @Id
    @GeneratedValue(generator = "sequence",
       strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",allocationSize = 10)
    @Getter
    @Setter
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,updatable = false)
    @CreatedDate
    @Getter
    @Setter
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = true)
    @LastModifiedDate
    @Getter
    @Setter
    private Date updatedAt = new Date();

}
