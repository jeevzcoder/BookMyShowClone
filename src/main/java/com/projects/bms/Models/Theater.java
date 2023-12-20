package com.projects.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{

    private String name;
    @ManyToMany
    private List<Movie> movies;
    @ManyToOne
    private City city;

}
