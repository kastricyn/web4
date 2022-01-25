package ru.kastricyn.web4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "WEB4_POINTS")
public class PointEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;

    private double x;
    private double y;
    private double r;
    private boolean result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PointEntity pointEntity = (PointEntity) o;
        return Objects.equals(id, pointEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
