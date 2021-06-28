package com.cursor.moviereview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(name = "movies")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Movie extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "photo")
    private String photo;

    @Column(name = "director_name", nullable = false)
    private String directorName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id", nullable = false)
    private Rate rate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movies_categories",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToMany
    @JoinTable(
            name = "movies_reviews",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    @ToString.Exclude
    private List<Review> reviews;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(photo, movie.photo) && Objects.equals(rate, movie.rate) &&
                Objects.equals(reviews, movie.reviews) && Objects.equals(categories, movie.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, photo, rate, reviews, categories);
    }
}
