package com.cursor.moviereview.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "movies")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @OneToMany(mappedBy = "movieId")
    @ToString.Exclude
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
            name = "movies_categories",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @ToString.Exclude
    private List<Category> category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(photo, movie.photo) && Objects.equals(rate, movie.rate) &&
                Objects.equals(reviews, movie.reviews) && Objects.equals(category, movie.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, photo, rate, reviews, category);
    }
}
