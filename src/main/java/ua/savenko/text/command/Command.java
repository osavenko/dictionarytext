package ua.savenko.text.command;

import ua.savenko.text.model.Parameter;

public interface Command {
    Parameter execute(Parameter parameter);
}
