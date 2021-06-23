package com.cursor.moviereview.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Table(name = "reviews")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Review {

    @Id
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "message", nullable = false)
    private String message;
    @Column(name = "likes")
    @Size
    private int likes;
    @Column(name = "dislikes")
    @Size
    private int dislikes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && likes == review.likes &&
                dislikes == review.dislikes && Objects.equals(message, review.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, likes, dislikes);
    }
}
