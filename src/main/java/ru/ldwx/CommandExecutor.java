package ru.ldwx;

import ru.ldwx.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allCommands = new HashMap<>();

    private CommandExecutor() {
    }

    static {
        allCommands.put(Operation.CREATE, new ZipCreateCommand());
        allCommands.put(Operation.ADD, new ZipAddCommand());
        allCommands.put(Operation.REMOVE, new ZipRemoveCommand());
        allCommands.put(Operation.EXTRACT, new ZipExtractCommand());
        allCommands.put(Operation.CONTENT, new ZipContentCommand());
        allCommands.put(Operation.EXIT, new ExitCommand());
    }

    public static void execute(Operation operation) throws Exception {
        allCommands.get(operation).execute();
    }
}
