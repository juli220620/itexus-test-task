package com.github.juli220620.cli.add;

import com.github.juli220620.cli.AbstractCommand;
import com.github.juli220620.core.model.UserData;
import com.github.juli220620.core.service.AddUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Set;

@Component
@Command(name = "add")
@RequiredArgsConstructor
public class AddUserCommand extends AbstractCommand {

    private final AddUserService addUserService;

    @Option(names = {"-n", "--name"}, required = true)
    private String name;

    @Option(names = {"-s", "--surname"}, required = true)
    private String surname;

    @Option(names = {"-e", "--email"}, required = true)
    private String email;

    @Option(names = {"-r", "--roles"}, required = true, arity = "1..3", split = ",")
    private Set<String> roles;

    @Option(names = {"-p", "--phones"}, required = true, arity = "1..3", split = ",")
    private Set<String> phones;

    @Override
    public void process() throws RuntimeException {
        var userData = new UserData(null, name, surname, email, roles, phones);
        addUserService.addUser(userData);
    }
}
