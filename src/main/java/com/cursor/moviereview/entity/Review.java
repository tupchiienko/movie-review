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
public class Review extends BaseEntity {

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "likes_count")
    private int likesCount;

    @Column(name = "dislikes_count")
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
