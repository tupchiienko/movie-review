package com.cursor.moviereview.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "directors")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id && Objects.equals(name, director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
