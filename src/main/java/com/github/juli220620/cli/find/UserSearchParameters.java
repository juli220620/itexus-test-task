package com.github.juli220620.cli.find;

import lombok.Getter;
import picocli.CommandLine.*;

@Getter
public class UserSearchParameters {

    @Option(names = {"-i", "--id"}, required = true)
    private Long id;

    @Option(names = {"-e", "--email"}, required = true)
    private String email;

}
