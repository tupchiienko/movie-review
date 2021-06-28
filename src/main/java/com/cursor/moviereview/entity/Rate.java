package com.cursor.moviereview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Table(name = "rates")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rate extends BaseEntity {

    @Column(name = "value", nullable = false, precision = 2, scale = 2)
    private BigDecimal value;

    @Column(name = "votes_count", nullable = false)
    private long votesCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return id == rate.id && value.equals(rate.value) && votesCount == rate.votesCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, votesCount);
    }
}
