package com.cursor.moviereview.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Table(name = "rates")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rate {

    @Id
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Size(min = 1, max = 10)
    @Column(name = "value")
    private float value;
    @Column(name = "count")
    private long count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return id == rate.id && value == rate.value && count == rate.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, count);
    }
}
