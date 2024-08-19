package com.github.juli220620.cli.edit;

import com.github.juli220620.cli.AbstractCommand;
import com.github.juli220620.core.model.UserData;
import com.github.juli220620.core.service.EditUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Set;

@Component
@Command(name = "edit")
@RequiredArgsConstructor
public class EditUserCommand extends AbstractCommand {

    private final EditUserService editUserService;

    @Parameters(index = "0", arity = "1")
    private Long id;

    @Option(names = {"-n", "--name"})
    private String name;

    @Option(names = {"-s", "--surname"})
    private String surname;

    @Option(names = {"-e", "--email"})
    private String email;

    @Option(names = {"-r", "--roles"}, arity = "1..3", split = ",")
    private Set<String> roles;

    @Option(names = {"-p", "--phones"}, arity = "1..3", split = ",")
    private Set<String> phones;

    @Override
    public void process() throws Exception {
        editUserService.editUser(new UserData(id, name, surname, email, roles, phones));
    }
}
