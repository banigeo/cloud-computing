package com.banigeo.webpoc.model.security;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Singular("authoritiesList")
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
               joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
               inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
    private Set<Authority> authoritiesList;

    @NotNull
    private String username;
    @NotNull
    private String password;
    @Builder.Default
    private Boolean enabled = true;
    @Builder.Default
    private Boolean accountNotExpired = true;
    @Builder.Default
    private Boolean accountNotLocked = true;
    @Builder.Default
    private Boolean credentialsNotExpired = true;
}
