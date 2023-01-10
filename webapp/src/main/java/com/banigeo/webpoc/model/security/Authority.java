package com.banigeo.webpoc.model.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name="authorities")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Authority {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer roleId;

    @NotNull
    private String role;

    @ManyToMany(mappedBy = "authoritiesList")
    private Set<User> users;
}
