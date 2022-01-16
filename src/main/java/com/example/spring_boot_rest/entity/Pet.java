package com.example.spring_boot_rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @Valid
    private Category category;
    private String photoUrls;

    @ManyToMany
    private Tag tag;
    private String name;
    private String status;
}
