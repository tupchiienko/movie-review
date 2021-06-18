package com.cursor.moviereview.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "reviews")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long movieId;
    private String message;
    private long likes;
    private long dislikes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && movieId == review.movieId && likes == review.likes &&
                dislikes == review.dislikes && Objects.equals(message, review.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, message, likes, dislikes);
    }
}
