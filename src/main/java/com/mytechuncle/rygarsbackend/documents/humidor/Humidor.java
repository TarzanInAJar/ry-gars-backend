package com.mytechuncle.rygarsbackend.documents.humidor;

import com.mytechuncle.rygarsbackend.documents.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
public class Humidor {
    @Id
    private String id;
    @DBRef
    private User user;
    private String name;
    private Set<HumidorCigarAddition> cigars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<HumidorCigarAddition> getCigars() {
        return cigars;
    }

    public void setCigars(Set<HumidorCigarAddition> cigars) {
        this.cigars = cigars;
    }
}
