package com.example.demirorenapp.entity;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Contacts {
    @EmbeddedId
    private  ContactId contactId;
    @ElementCollection
    private List<String> phones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return contactId.equals(contacts.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId);
    }
}
