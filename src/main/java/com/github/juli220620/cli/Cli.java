package com.github.juli220620.cli;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import picocli.CommandLine;

public class Cli {

    public static void main(String[] args) {
        try {
            var context = new AnnotationConfigApplicationContext("com.github.juli220620");
            var commandLine = new CommandLine(new TopLevelCommand(), context.getBean(CommandLine.IFactory.class));
            var code = commandLine.execute(args);
            System.exit(code);
        } catch (Exception e) {
            System.exit(1);
        }
    }
}