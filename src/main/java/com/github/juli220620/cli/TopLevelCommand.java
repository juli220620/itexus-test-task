package com.github.juli220620.cli;

import com.github.juli220620.cli.add.AddUserCommand;
import com.github.juli220620.cli.edit.EditUserCommand;
import com.github.juli220620.cli.find.FindUserCommand;
import com.github.juli220620.cli.find.ListAllCommand;
import com.github.juli220620.cli.remove.RemoveUserCommand;
import picocli.CommandLine.Command;

@Command(subcommands = {
        AddUserCommand.class,
        RemoveUserCommand.class,
        ListAllCommand.class,
        FindUserCommand.class,
        EditUserCommand.class})
public class TopLevelCommand {}
