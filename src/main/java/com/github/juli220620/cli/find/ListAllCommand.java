package com.github.juli220620.cli.find;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.juli220620.cli.AbstractCommand;
import com.github.juli220620.core.service.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Command(name = "list")
@Component
@RequiredArgsConstructor
public class ListAllCommand extends AbstractCommand {

    private final FindUserService findUserService;
    private final ObjectMapper mapper;

    @Override
    public void process() throws Exception {
        System.out.println(
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(findUserService.all())
        );
    }
}
