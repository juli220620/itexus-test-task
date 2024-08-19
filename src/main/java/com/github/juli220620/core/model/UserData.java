package com.github.juli220620.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private Set<String> roles;
    private Set<String> phones;
}
