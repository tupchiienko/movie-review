package com.cursor.moviereview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
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
    @NotBlank(message = "Review message is mandatory")
    @Max(value = 2048, message = "Review message must be less than 2048 characters")
    private String message;
    @Column(name = "likes_count")
    @PositiveOrZero(message = "Likes count must not be less than 0")
    private int likesCount;
    @Column(name = "dislikes_count")
    @PositiveOrZero(message = "Dislikes count must not be less than 0")
    private int dislikesCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && likesCount == review.likesCount &&
                dislikesCount == review.dislikesCount && Objects.equals(message, review.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, likesCount, dislikesCount);
    }
}
