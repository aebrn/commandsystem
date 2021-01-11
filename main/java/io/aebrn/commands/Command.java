package io.aebrn.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aebrn
 * 12/12/2020
 */
public abstract class Command {
    private final String[] aliases;
    private String syntax;
    private Argument[] arguments;

    public Command(String... aliases) {
        this.aliases = aliases;

        Syntax syntax = this.getClass().getAnnotation(Syntax.class);
        if (this.getClass().isAnnotationPresent(Syntax.class)) {
            this.syntax = syntax.value();
        }

        Arguments arguments = this.getClass().getAnnotation(Arguments.class);
        if (this.getClass().isAnnotationPresent(Arguments.class)) {
            for (String argument : arguments.value()) {
                this.arguments = addArguments(new Argument(argument), this.arguments);
            }
        } else {
            this.arguments = null;
        }
    }

    protected String handleArguments(String[] input) {
        boolean correctSyntax = (input.length - 1) == arguments.length;
        if (correctSyntax) {
            for (int index = 0; index < arguments.length; index++) {
                Argument argument = arguments[index];
                argument.setPresent(input.length > index);
                argument.setValue(input[index + 1]);
                correctSyntax = argument.isPresent();
            }
        }

        return correctSyntax ? execute() : getSyntax(input[0]);
    }

    private Argument[] addArguments(Argument argument, Argument[] arguments) {
        List<Argument> argumentList = new ArrayList<>(Arrays.asList(arguments));
        argumentList.add(argument);
        return argumentList.toArray(arguments);
    }

    public abstract String execute();

    public Argument getArgument(String label) {
        for (Argument argument : arguments) {
            if (label.equalsIgnoreCase(argument.getLabel())) {
                return argument;
            }
        }
        return null;
    }

    public String[] getAliases() {
        return aliases;
    }

    public Argument[] getArguments() {
        return arguments;
    }

    private String getSyntax(String input) {
        return String.format("%s %s", input, syntax);
    }
}
