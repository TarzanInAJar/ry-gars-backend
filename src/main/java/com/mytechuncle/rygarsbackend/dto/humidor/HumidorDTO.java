package com.mytechuncle.rygarsbackend.dto.humidor;

import java.util.Set;

public class HumidorDTO {
    private String id;
    private String username;
    private String name;
    private Set<HumidorCigarAdditionDTO> cigars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<HumidorCigarAdditionDTO> getCigars() {
        return cigars;
    }

    public void setCigars(Set<HumidorCigarAdditionDTO> cigars) {
        this.cigars = cigars;
    }

}
