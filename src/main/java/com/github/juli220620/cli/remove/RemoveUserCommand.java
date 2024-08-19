package com.github.juli220620.cli.remove;

import com.github.juli220620.cli.AbstractCommand;
import com.github.juli220620.core.service.RemoveUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "remove")
@RequiredArgsConstructor
public class RemoveUserCommand extends AbstractCommand {

    private final RemoveUserService removeUserService;

    @Parameters(index = "0", arity = "1")
    private Long id;

    @Override
    public void process() {
        removeUserService.removeUser(id);
    }
}
