package com.example.demirorenapp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Embeddable
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ContactId implements Serializable {

    private String name;

    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactId contactId = (ContactId) o;
        return name.equals(contactId.name) && lastName.equals(contactId.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }
}
