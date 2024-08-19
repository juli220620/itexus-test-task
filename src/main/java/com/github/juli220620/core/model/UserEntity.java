package com.github.juli220620.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "second_name")
    private String secondName;

    @NotBlank
    @Email
    private String email;

    @Size(min = 1, max = 3)
    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<RoleEntity> roles;

    @Size(min = 1, max = 3)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_phone",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @Column(name = "number")
    private Set<@Pattern(regexp = "^375[0-9]{9}$") String> phoneNumbers;
}
