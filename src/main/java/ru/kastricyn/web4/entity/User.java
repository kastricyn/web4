package ru.kastricyn.web4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Deque;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private char[] password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
