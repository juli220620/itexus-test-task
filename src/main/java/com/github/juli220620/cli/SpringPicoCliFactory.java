package com.github.juli220620.cli;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@RequiredArgsConstructor
public class SpringPicoCliFactory implements CommandLine.IFactory {

    private final ApplicationContext context;
    private final CommandLine.IFactory defaultFactory = CommandLine.defaultFactory();

    @Override
    public <K> K create(Class<K> cls) throws Exception {
        return cls.getAnnotation(CommandLine.Command.class) == null
                ? defaultFactory.create(cls)
                : context.getBean(cls);
    }

}
