package com.github.juli220620.cli.find;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.juli220620.cli.AbstractCommand;
import com.github.juli220620.core.service.FindUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;

import java.util.Collections;
import java.util.List;

@Command(name = "find")
@Component
@RequiredArgsConstructor
public class FindUserCommand extends AbstractCommand {

    private final FindUserService findUserService;
    private final ObjectMapper mapper;

    @ArgGroup(multiplicity = "1")
    private UserSearchParameters parameters;

    @Override
    public void process() {
        if (parameters.getId() != null) {
            print(findUserService.findById(parameters.getId())
                    .map(List::of)
                    .orElse(Collections.emptyList()));
        } else {
            print(findUserService.findAllByEmail(parameters.getEmail()));
        }
    }

    private void print(Object data) {
        try {
            System.out.println(
                    mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(data)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
