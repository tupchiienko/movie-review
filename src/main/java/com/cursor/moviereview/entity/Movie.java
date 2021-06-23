package com.cursor.moviereview.entity;

import lombok.*;
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
public class Movie {

    @Id
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "photo")
    private String photo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @ManyToMany
    @JoinTable(
            name = "movies_categories",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @ToString.Exclude
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
